package com.cc.youmengtools.youMengLogin;

import android.app.Activity;
import android.content.Context;

import com.cc.youmengtools.utils.IToast;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Title （标题）:
 * Created by （作者）: MapleChan
 * e-mail （邮箱）: cc7126@139.com
 * date （时间）: 2018/11/28 16:00
 * Describe（描述）:
 */
public class CCLogin {
	private Context context;
	private Map<String, String> paramsac;
	private UMAuthListener umAuthListener;

	public CCLogin(Context myContext, UMAuthListener myUmAuthListener) {
		this.context = myContext;
		this.umAuthListener = myUmAuthListener;
	}

	/**
	 * 默认回调微信登陆
	 *
	 * @return
	 */
	public Map<String, String> WeChatlogin() {
		UMShareAPI.get(context).getPlatformInfo((Activity) context, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
			@Override
			public void onStart(SHARE_MEDIA share_media) {

			}

			@Override
			public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
				paramsac = map;
			}

			@Override
			public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
				IToast.show(context, "分享失败！");
			}

			@Override
			public void onCancel(SHARE_MEDIA share_media, int i) {
				IToast.show(context, "分享已取消！");
			}
		});
		return paramsac;
	}

	/**
	 * 监听回调方法由外层提供的微信登陆
	 *
	 * @param umAuthListener
	 * @return
	 */
	public Map<String, String> WeChatlogin(UMAuthListener umAuthListener) {
		UMShareAPI.get(context).getPlatformInfo((Activity) context, SHARE_MEDIA.WEIXIN, umAuthListener);
		return paramsac;
	}

	/**
	 * 默认监听回调方法的QQ登陆
	 *
	 * @return
	 */
	public Map<String, String> QQlogin() {
		UMShareAPI.get(context).getPlatformInfo((Activity) context, SHARE_MEDIA.QQ, new UMAuthListener() {
			@Override
			public void onStart(SHARE_MEDIA share_media) {

			}

			@Override
			public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
				paramsac = map;
			}

			@Override
			public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
				IToast.show(context, "分享失败!");
			}

			@Override
			public void onCancel(SHARE_MEDIA share_media, int i) {
				IToast.show(context, "分享已取消！");
			}
		});
		return paramsac;
	}

	/**
	 * 监听回调方法由外层提供的QQ登陆
	 *
	 * @param umAuthListener
	 * @return
	 */
	public Map<String, String> QQlogin(UMAuthListener umAuthListener) {
		UMShareAPI.get(context).getPlatformInfo((Activity) context, SHARE_MEDIA.QQ, umAuthListener);
		return paramsac;
	}
}
