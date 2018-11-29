package com.cc.youmengtoos.InitYouMeng;

import android.content.Context;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Title （标题）: 初始化友盟SDk
 * Created by （作者）: MapleChan
 * e-mail （邮箱）: cc7126@139.com
 * date （时间）: 2018/11/28 16:28
 * Describe（描述）:
 */
public class InitYouMeng {
	/**
	 * 初始化友盟SDK
	 * @param context
	 * @param appid  平台的appid
	 */
	public static void init(Context context, String appid){
		UMConfigure.init(context,appid,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
	}

	/**
	 * 初始化微信
	 * @param appid
	 * @param AppSecret 平台的appkey
	 */
	public static void initweixin(String appid,String AppSecret){
		PlatformConfig.setWeixin(appid, AppSecret);
	}
}
