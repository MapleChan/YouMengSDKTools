# YouMengSDKToos
友盟SDK集成库


1、初始化操作
在BaseApplication里面的onCreate()方法里初始化
/**
 * 初始化友盟SDK
 * @param context
 * @param appid  平台的appid
 */
InitYouMeng.init(Context context, String appid);

/**
 * 初始化微信
 * @param appid
 * @param AppSecret 平台的appkey
 */
	InitYouMeng.initweixin(appid,AppSecret);
  
2、分享操作
CCShare ccShare = new CCShare(content,shareListener);
//测试分享，仅QQ和微信，（弹窗时友盟的弹窗）
ccShare.shareToQQandWeiChat(string,activity);
/**
	 * 分享到QQ
	 *
	 * @param title
	 * @param shareUrl
	 * @param imgUrl
	 * @param text
	 */
	ccShare.shareToQQ(title, shareUrl, imgUrl, text);
  
  /**
	 * 分享到微信
	 *
	 * @param title
	 * @param shareUrl
	 * @param imgUrl
	 * @param text
	 */
	ccShare.shareWeChat(title, shareUrl,imgUrl,text)
  
  /**
	 * 分享到微信朋友圈
	 *
	 * @param title
	 * @param shareUrl
	 * @param imgUrl
	 * @param text
	 */
	ccShare.shareWeChatFirend(title,shareUrl,imgUrl,text)
  
  /**
	 * 复制
	 *
	 * @param context
	 * @param shareUrl
	 */
	ccShare.copyText(context,shareUrl)
  
  
分享回调方法如下：
private UMShareListener shareListener = new UMShareListener() {
		/**
		 * @descrption 分享开始的回调
		 * @param platform 平台类型
		 */
		@Override
		public void onStart(SHARE_MEDIA platform) {

		}

		/**
		 * @descrption 分享成功的回调
		 * @param platform 平台类型
		 */
		@Override
		public void onResult(SHARE_MEDIA platform) {
		}

		/**
		 * @descrption 分享失败的回调
		 * @param platform 平台类型
		 * @param t 错误原因
		 */
		@Override
		public void onError(SHARE_MEDIA platform, Throwable t) {
		}

		/**
		 * @descrption 分享取消的回调
		 * @param platform 平台类型
		 */
		@Override
		public void onCancel(SHARE_MEDIA platform) {

		}
	};

3、登陆操作
CCLogin ccLogin = new CCLogin(content,myUmAuthListener)

/**
*默认回调微信登陆
* return Map<String,String>
*/
ccLogin.WeChatlogin();

/**
*回调由外层提供的微信登陆
* return Map<String,String>
*/
ccLogin.WeChatlogin(umAuthListener);

/**
*默认回调QQ登陆
* return Map<String,String>
*/
ccLogin.QQlogin();

/**
*回调由外层提供的QQ登陆
* return Map<String,String>
*/
ccLogin.WeChatlogin(umAuthListener);


登陆回调方法如下：
private UMAuthListener umAuthListener = new UMAuthListener() {
		/**
		 * @descrption 登陆开始的回调
		 */
		@Override
		public void onStart(SHARE_MEDIA share_media) {
			
		}

		/**
		 * @descrption 登陆成功的回调
		 * @param map 返回值
		 */
		@Override
		public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

		}

		/**
		 * @descrption 登陆失败的回调
		 */
		@Override
		public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

		}

		/**
		 * @descrption 登陆取消的回调
		 */
		@Override
		public void onCancel(SHARE_MEDIA share_media, int i) {

		}
	};

备注：清单文件需要自行添加友盟相关代码
<!--↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓友盟SDK需要添加的东西↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
        <meta-data
            android:name="UMENG_APPKEY"
            android:value="友盟appkey"/>
        <meta-data
            android:name="UMENG_CHANNEL"
            android:value="Umeng"/>
        <!--微信-->
        <activity
            android:name=".wxapi.WXEntryActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:exported="true"
            android:theme="@android:style/Theme.Translucent.NoTitleBar" />
        <!--支付宝-->
        <activity
            android:name=".apshare.ShareEntryActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:exported="true"
            android:screenOrientation="portrait"
            android:theme="@android:style/Theme.Translucent.NoTitleBar" />
        <!--QQ-->
        <activity
            android:name="com.tencent.tauth.AuthActivity"
            android:launchMode="singleTask"
            android:noHistory="true" >
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data android:scheme="腾讯appkey" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.tencent.connect.common.AssistActivity"
            android:theme="@android:style/Theme.Translucent.NoTitleBar"
            android:configChanges="orientation|keyboardHidden|screenSize"/>
        <!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑友盟SDK需要添加的东西↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑-->
