package com.cc.youmengsdktoos;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView share = (TextView) findViewById(R.id.tv_share);
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 请查看你的build.gradle文件，如果 targetSdkVersion小于或等于22，可以忽略这一步，如果大于或等于23，需要做权限的动态申请：
				 */
				if (Build.VERSION.SDK_INT >= 23) {
					String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
					ActivityCompat.requestPermissions(MainActivity.this, mPermissionList, 123);
				}

				
				/*new ShareAction(MainActivity.this).withText("hello").setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
						.setCallback(shareListener).open();*/
			}
		});
		
	}

	/*private UMShareListener shareListener = new UMShareListener() {
		*//**
		 * @descrption 分享开始的回调
		 * @param platform 平台类型
		 *//*
		@Override
		public void onStart(SHARE_MEDIA platform) {
			Toast.makeText(MainActivity.this, "开始了", Toast.LENGTH_LONG).show();

		}

		*//**
		 * @descrption 分享成功的回调
		 * @param platform 平台类型
		 *//*
		@Override
		public void onResult(SHARE_MEDIA platform) {
			Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
		}

		*//**
		 * @descrption 分享失败的回调
		 * @param platform 平台类型
		 * @param t 错误原因
		 *//*
		@Override
		public void onError(SHARE_MEDIA platform, Throwable t) {
			Toast.makeText(MainActivity.this, "失败了" + t.getMessage(), Toast.LENGTH_LONG).show();
		}

		*//**
		 * @descrption 分享取消的回调
		 * @param platform 平台类型
		 *//*
		@Override
		public void onCancel(SHARE_MEDIA platform) {
			Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();

		}
	};*/

	//其中123是requestcode，可以根据这个code判断，用户是否同意了授权。如果没有同意，可以根据回调进行相应处理
	@Override
	public void onRequestPermissionsResult(int requestCode,
										   String permissions[], int[] grantResults) {
		if (requestCode == 123) {
			Toast.makeText(MainActivity.this, "权限同意了", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(MainActivity.this, "权限没同意", Toast.LENGTH_LONG).show();
		}

	}

	//QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
//		UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
	}
}
