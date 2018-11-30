package com.cc.youmengtools.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Title （标题）: 吐司工具
 * Created by （作者）: MapleChan
 * e-mail （邮箱）: cc7126@139.com
 * date （时间）: 2018/11/28 16:00
 * Describe（描述）:
 */
public class IToast {
	private static Toast toast;

	/**
	 * 初始化Toast
	 *
	 * @param context
	 * @param time 吐司时间
	 */
	private static void initToast(Context context ,int time) {
		if (toast == null) {
			toast = Toast.makeText(context, null, time);
		}
	}

	/**
	 * String类型吐司(短吐司)
	 *
	 * @param context
	 * @param info
	 */
	public static void show(Context context, String info) {
		initToast(context,Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setText(info);
		toast.show();
	}


	/**
	 * String类型吐司(长吐司)
	 *
	 * @param context
	 * @param info
	 */
	public static void showLong(Context context, String info) {
		initToast(context,Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setText(info);
		toast.show();
	}

	/**
	 * int类型吐司(短吐司)
	 *
	 * @param context
	 * @param info
	 */
	public static void show(Context context, int info) {
		initToast(context,Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setText(info);
		toast.show();
	}

	/**
	 * int类型吐司(长吐司)
	 *
	 * @param context
	 * @param info
	 */
	public static void showLong(Context context, int info) {
		initToast(context,Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setText(info);
		toast.show();
	}
}
