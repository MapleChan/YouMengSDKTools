package com.cc.youmengtools.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;

/**
 * Title （标题）: 检查权限工具类
 * Created by （作者）: MapleChan
 * e-mail （邮箱）: cc7126@139.com
 * date （时间）: 2018/11/28 15:29
 * Describe（描述）: 权限
 */
public class CCPermission {

	/**
	 * 检查单个权限
	 *
	 * @param activity
	 * @param permission
	 * @param code
	 * @return
	 */
	public static boolean checkPermission(Activity activity, String permission, int code) {
		return checkPermission(activity, new String[]{permission}, code);
	}

	/**
	 * 申请没有的权限,已申请的会被过滤,
	 * 如果没有过滤,会导致已申请的权限再次申请
	 * 返回申请失败,不执行相应的方法
	 *
	 * @param activity
	 * @param permission
	 * @param code
	 * @return true 就是可以直接调用 false就是需要等待权限申请
	 */
	public static boolean checkPermission(Activity activity, String[] permission, int code) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			ArrayList<String> permissions = new ArrayList<>();
			for (String per : permission) {
				if (ContextCompat.checkSelfPermission(activity, per)
						!= PackageManager.PERMISSION_GRANTED) {
					permissions.add(per);
				}
			}
			if (permissions.size() > 0) {
				Log.i("PermissionUtil", "PermissionUtil");
				activity.requestPermissions(permissions.toArray(new String[permissions.size()]), code);
				return false;
			}
		}
		return true;
	}

	public static boolean checkPermissionForFragment(Fragment fragment, String[] permission, int code) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
			ArrayList<String> permissions = new ArrayList<>();
			for (String per : permission) {
				if (ContextCompat.checkSelfPermission(fragment.getActivity(), per)
						!= PackageManager.PERMISSION_GRANTED) {
					permissions.add(per);
				}
			}
			if (permissions.size() > 0) {
				fragment.requestPermissions(permissions.toArray(new String[permissions.size()]), code);
				return false;
			}
		}
		return true;
	}
}
