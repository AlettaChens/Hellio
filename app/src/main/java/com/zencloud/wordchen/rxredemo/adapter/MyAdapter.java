package com.zencloud.wordchen.rxredemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zencloud.wordchen.rxredemo.R;
import com.zencloud.wordchen.rxredemo.entity.Mike;
import com.zencloud.wordchen.rxredemo.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends MyBaseAdapter {
	private Context context;

	public MyAdapter(List<Mike> categorybean, Context context) {
		super(categorybean, context);
		this.context = context;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
//每次先获取将要展示的数据
		Mike categorybean = getData().get(i);
//优化布局的帮助类
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_layout, null);
			viewHolder = new ViewHolder();
//查找对应控件，并设置到帮助类中，以免重复创建，是内存泄露，
			viewHolder.categoryimageView = (ImageView) convertView.findViewById(R.id.img);
//以下三个控件同上
			viewHolder.categoryname = (TextView) convertView.findViewById(R.id.tv_categoryname);
			viewHolder.fullname = (TextView) convertView.findViewById(R.id.fullname);
			viewHolder.code = (TextView) convertView.findViewById(R.id.code);
			convertView.setTag(viewHolder);
		}
//以下控件设置对应的数据
		viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.categoryname.setText(categorybean.getCategoryName());
		viewHolder.fullname.setText(categorybean.getFullName());
		viewHolder.code.setText(categorybean.getCode());
		viewHolder.categoryimageView.setImageBitmap(null);
		GlideUtils.getInstance().loadImage(context, categorybean.getImageGUID(), viewHolder.categoryimageView);
		return convertView;
	}

	static class ViewHolder {
		ImageView categoryimageView;
		TextView categoryname;
		TextView fullname;
		TextView code;
	}
}