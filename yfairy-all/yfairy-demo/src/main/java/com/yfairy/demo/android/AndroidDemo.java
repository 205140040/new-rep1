package com.yfairy.demo.android;

public class AndroidDemo {

	public static void main(String[] args) {
		/**
		 * 机器人<br>
		 * 官网:https://developer.android.com<br>
		 * 1.2.2搭建开发环境，Android sdk，ADT<br>
		 * Eclipse+ADT+Android SDK 搭建安卓开发环境<br>
		 * http://www.mamicode.com/info-detail-516839.html<br>
		 * sdk下载网址:https://android-sdk.cn.uptodown.com/windows/download<br>
		 * <br>
		 * launch 英[lɔ:ntʃ]<br>
		 * 
		 * vt. 发射; 发动; [计算机]开始（应用程序）; 开展（活动、计划等）;<b<br>
		 * r> vi. 投入; 着手进行; 热衷于…;<br>
		 * n. 投掷; 大船上的小艇; 大型敞篷摩托艇;<br>
		 * 
		 * <br>
		 * 给Android Studio设置代理<br>
		 * http://blog.csdn.net/lchad/article/details/43567675<br>
		 * 
		 * 快速Android开发系列网络篇之Android-Async-Http<br>
		 * http://www.cnblogs.com/angeldevil/p/3729808.html<br>
		 */

		/**
		 * 机器人<br>
		 * 官网:https://developer.android.com<br>
		 * 1.2.2搭建开发环境，Android sdk，ADT<br>
		 * Eclipse+ADT+Android SDK 搭建安卓开发环境<br>
		 * http://www.mamicode.com/info-detail-516839.html<br>
		 * sdk下载网址:https://android-sdk.cn.uptodown.com/windows/download<br>
		 * <br>
		 * launch 英[lɔ:ntʃ]<br>
		 * vt. 发射; 发动; [计算机]开始（应用程序）; 开展（活动、计划等）;<b<br>
		 * r> vi. 投入; 着手进行; 热衷于…;<br>
		 * n. 投掷; 大船上的小艇; 大型敞篷摩托艇;<br>
		 * <br>
		 * 给Android Studio设置代理<br>
		 * http://blog.csdn.net/lchad/article/details/43567675<br>
		 *
		 * 快速Android开发系列网络篇之Android-Async-Http<br>
		 * http://www.cnblogs.com/angeldevil/p/3729808.html<br>
		 *
		 * 教程: Android学习之路<br>
		 * http://stormzhang.com/android/2014/07/07/learn-android-from-rookie/<br>
		 *
		 * 推荐书籍：第一行代码<br>
		 * 第一章：开启启程(1/555)<br>
		 * 第二章:探究活动(28/555)<br>
		 */
		System.out.println("hello");
		// Log.d("tag1", "log debug ...");
		// 第一章：开启启程(1/555)<br>

		// 目录介绍:java放代码的地方,
		// res:存放资源文件目录:drawabl存放图片，layout存放布局,values存放字符串
		// AndroidManifest.xml存放整个项目的配置文件

		// 通过AndroidMonitor打开查看日志的窗口LogCat:
		System.err.println("通过AndroidMonitor打开查看日志的窗口:");
		// 1.4.2使用日志工具Log，Log.v()(verbose), Log.d()(debug),
		// Log.i()(info),Log.e()(error)
		// Log.e("etag", "error");

		// 第二章：探究活动(28/555)<br>
		// 活动activity，是一种包含用户界面的组件，主要用于和用户进行交互<br>

		// 加载布局
		// setContentView(R.layout.first_layout);
		// 所有的活动都要在manifest中注册
		// 注册活动
		// <activity android:name=".FirstActivity" android:label="FirstActivity"
		// >
		// <intent-filter>
		// <action android:name="android.intent.action.MAIN" />
		// <category android:name="android.intent.category.LAUNCHER" />
		// </intent-filter>
		// </activity>

		// 设置无标题
		// requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 添加Toast提示 setOnClickListener
		// button1.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// Toast.makeText(FirstActivity.this,"click
		// button1",Toast.LENGTH_SHORT).show();
		// }
		// });

		// 2.2.6在活动中使用菜单

		// Android Studio下创建menu布局文件
		// http://www.cnblogs.com/ssqqhh/p/5213331.html

		// 销毁一个活动，类似退出
		// finish();

		// 2.3使用Intent在活动间穿梭
		// 通过Intent启动活动
		// Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
		// startActivity(intent);
		// 点击back键就可以销毁活动类似调用finish,返回上级菜单

		// 2.3.2使用隐式Intent(45/555)<br>

		// intent 英[ɪnˈtent]
		// 美[ɪnˈtɛnt]
		// n. 意图，目的; 意思，含义;
		// adj. 专心的，专注的; 意愿坚决的; 急切的; 一心想…的;

		// category 英[ˈkætəgəri]
		// 美[ˈkætəgɔ:ri]
		// n. 类型，部门，种类，类别，类目; [逻，哲] 范畴; 体重等级;

		// 2.3.4像下一个活动传递数据
		// Intent intent=new Intent(SecondActivity.this,FourActivity.class);
		// intent.putExtra("data","data1修改");
		// startActivity(intent);

		// 从Intent中取得数据
		// Intent intent=getIntent();
		// String data=intent.getStringExtra("data");
		// Log.i("intentdata",data);

		// 2.3.5返回数据给上一个活动(53/555)<br>

		// 启动有返回结果的intent,requestCode请求码，用于区别哪个活动
		// startActivityForResult(intent, requestCode);

		// 活动结果回调
		// @Override
		// protected void onActivityResult(int requestCode, int resultCode,
		// Intent data) {
		// //活动结果回调
		// //requestCode确定是启动哪一个活动,在启动多个活动时区分哪一个活动
		// switch (requestCode) {
		// case 1:
		// if (resultCode == RESULT_OK) {
		// //活动返回的code
		// Log.i("intentdata", data.getStringExtra("intentdata"));
		// }
		// break;
		// default:
		// break;
		// }
		// }

		// @Override
		// public void onBackPressed() {
		// //系统点击返回事件，像上一个活动返回数据
		// intentHandle();
		// }
		//
		// private void intentHandle() {
		// Intent intent = new Intent();
		// intent.putExtra("intentdata", "result1");
		// //像上一个活动传递数据
		// setResult(RESULT_OK, intent);
		// finish();
		// }

		// 2.4活动的生命周期

		// onCreate,onStart,onResume,onPause,onStop,onDestroy,onRestart

		// @Override
		// protected void onSaveInstanceState(Bundle outState) {
		// //在活动被回收之前保存该活动的数据
		// super.onSaveInstanceState(outState);
		// outState.putString("huishouData","data");
		// }

		//

		// protected void onCreate(Bundle savedInstanceState) {
		// super.onCreate(savedInstanceState);
		// Log.i(TAG,"onCreate");
		// if(null!=savedInstanceState){
		// //获取活动被回收之前的数据
		// String huishouData=savedInstanceState.getString("huishouData");
		// }
		// }

		// 2.5活动的启动模式(69/555)<br>

		// android:launchMode配置启动模式
		// <activity android:name=".StandardActivity"
		// android:launchMode="standard" ></activity>

		// standard 英[ˈstændəd]
		// 美[ˈstændərd]
		// n. 标准，规格; 旗，军旗; 度量衡标准; 直立支柱;
		// adj. 标准的，合格的; 普遍的，一般的; 公认为优秀的;

		// standard默认的，每次都新建一个活动

		// singleTop检查活动在栈顶时，每次创建都保持单列，不在栈顶每次都新建一个活动

		// singleTask同一个活动栈中保持单列，不同的活动栈新建

		// singleInstance所有的活动栈中都保持单列，只新建一次

		// studio 英[ˈstju:diəʊ]
		// 美[ˈstu:dioʊ]
		// n. 工作室，画室; [影] 演播室，电影制片厂;

		// 2.6活动的最佳实践
		// 所有活动继承一个父类，设置打印活动
		// 把活动添加到list中，方便全部退出
		{
			String aString;
		}

		// 第3章：UI开发(85/555)<br>

		// widget 英[ˈwɪdʒɪt]
		// 美[ˈwɪdʒɪt]
		// n. 小器具，装饰品，窗口小部件;

		// android:layout_width="match_parent"
		// match_parent当前大小和父容器大小一致
		// wrap_content 表示让
		// 当前控件的大小能够刚好包含住里面的内容，也就是由控件内容决定当前控件的大小

		// android:gravity="center" 水平垂直都居中

		// <TextView
		// android:id="@+id/textView1"
		// android:layout_width="match_parent"
		// android:layout_height="wrap_content"
		// android:gravity="center"
		// android:text="Hello World!"
		// android:textColor="?android:attr/textColorLinkInverse"
		// android:textSize="24sp" />
		
		
//		 <EditText
//	        android:layout_width="match_parent"
//	        android:layout_height="wrap_content"
//
//	        android:hint="请输入"/>
		
		//3.2.4 ImageView(96/555)<br>
	}

}
