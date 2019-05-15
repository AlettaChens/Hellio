package com.zencloud.wordchen.rxredemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.zencloud.wordchen.rxredemo.R;
import com.zencloud.wordchen.rxredemo.adapter.MyAdapter;
import com.zencloud.wordchen.rxredemo.entity.Mike;
import com.zencloud.wordchen.rxredemo.entity.MikeDatabase;
import com.zencloud.wordchen.rxredemo.utils.DialogUtils;
import com.zencloud.wordchen.rxredemo.utils.RequestUtils;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 总体流程:控件的依赖注入使用ButterKnife，使用RXJava+Retrofit发起网络请求,
 * 获取到数据之后使用Room存入本地Sqlite数据库中,之后从数据库中读出来显示
 * 到ListView上，图片加载模块使用Glide来处理，最后将数据从数据库中删除.
 */
public class MainActivity extends AppCompatActivity {

	@BindView(R.id.lv_display)
	ListView lvDisplay;
	@BindView(R.id.btn_save_data)
	Button btnSaveData;
	private MyAdapter displayListViewAdapter;
	private Disposable disposable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	/**
	 * 从网络下载数据并且存入数据库中
	 */
	private void sendRequestWithRxJava() {
		DialogUtils.getInstance().loadDialog(MainActivity.this, "获取数据并且存入数据库中");
		RequestUtils.getInstance().getCall().subscribeOn(Schedulers.io())// 切换到IO线程进行网络请求
				.observeOn(AndroidSchedulers.mainThread())// 切换回到主线程 处理请求结果
				.subscribe(new Observer<ArrayList<Mike>>() {
					@Override
					public void onSubscribe(Disposable d) {
						disposable = d;
					}

					@Override
					public void onNext(ArrayList<Mike> mikes) {
						MikeDatabase.getInstance(MainActivity.this).mikeDao().insertAll(mikes);
						DisplayData();
					}

					@Override
					public void onError(Throwable e) {
						Log.e("TAG", e.toString());
						Toast.makeText(MainActivity.this, "操作失败"+e.toString(), Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onComplete() {
						DialogUtils.getInstance().loadDialogDismiss();
						Log.e("TAG", "complet");
					}
				});
	}

	/**
	 * 从数据中查询数据并且展示在界面上,然后删除数据库中的数据
	 */
	private void DisplayData() {
		List<Mike> mikeArrayList = MikeDatabase.getInstance(MainActivity.this).mikeDao().getAllMikes();
		displayListViewAdapter = new MyAdapter(mikeArrayList, MainActivity.this);
		lvDisplay.setAdapter(displayListViewAdapter);
		MikeDatabase.getInstance(MainActivity.this).mikeDao().deleteAll(mikeArrayList);
	}

	@OnClick({R.id.btn_save_data})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.btn_save_data:
				sendRequestWithRxJava();
				break;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		if(!disposable.isDisposed()){
			disposable.dispose();
		}
	}
}
