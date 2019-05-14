package com.zencloud.wordchen.rxredemo.utils;

import android.content.Context;


import com.zencloud.wordchen.rxredemo.R;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class DialogUtils {
	private static DialogUtils instance;
	private SweetAlertDialog loadDialog;

	private DialogUtils() {

	}

	public static DialogUtils getInstance() {
		if (instance == null) {
			synchronized (DialogUtils.class) {
				if (instance == null) {
					instance = new DialogUtils();
				}
			}
		}
		return instance;
	}

	/**
	 * @param context 上下文
	 * @param title   标题
	 *                <p>
	 *                加载中
	 */
	public void loadDialog(Context context, String title) {
		loadDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
		loadDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.BaseColor));
		loadDialog.setTitleText(title);
		loadDialog.setCancelable(false);
		loadDialog.show();
	}

	public void loadDialogDismiss() {
		if (loadDialog.isShowing()) {
			loadDialog.dismiss();
		}

	}

	/**
	 * @param context 上下文
	 * @param title   标题
	 * @param content 内容
	 * @param type    提示
	 */
	public void showMsgDialog(Context context, String title, String content, int type) {
		SweetAlertDialog msgDialog = new SweetAlertDialog(context, type);
		msgDialog.setTitleText(title);
		msgDialog.setContentText(content);
		msgDialog.show();
	}

	/**
	 * @param context 上下文
	 *
	 *                网络超时 错误提示
	 */
	public void errorDialog(Context context) {
		SweetAlertDialog msgDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
		msgDialog.setTitleText("提示");
		msgDialog.getProgressHelper().setBarColor(R.color.BaseColor);
		msgDialog.setContentText("网络超时，请重试");
		msgDialog.setConfirmText(context.getResources().getString(R.string.confirm));
		msgDialog.show();
		msgDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
			@Override
			public void onClick(SweetAlertDialog sweetAlertDialog) {
				sweetAlertDialog.dismiss();
			}
		});
	}

	//警告
	public void showWarmDialog(Context context, String title, String content, String confirmText, SweetAlertDialog.OnSweetClickListener listener) {
		SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
		dialog.setTitleText(title);
		dialog.setContentText(content);
		dialog.setConfirmText(confirmText);
		dialog.setCancelText("取消");
		dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
			@Override
			public void onClick(SweetAlertDialog sweetAlertDialog) {
				sweetAlertDialog.dismiss();
			}
		});
		dialog.setConfirmClickListener(listener);
		dialog.show();
	}


}
