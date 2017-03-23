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

		// <EditText
		// android:layout_width="match_parent"
		// android:layout_height="wrap_content"
		//
		// android:hint="请输入"/>

		// 3.2.4 ImageView(96/555)<br>

		// <ImageView android:id="@+id/img1"
		// android:layout_width="wrap_content"
		// android:layout_height="wrap_content"
		// android:src="@drawable/imgview1"/>

		// 3.2.5 进度条

		// <ProgressBar android:id="@+id/pb1"
		// android:layout_width="match_parent"
		// android:layout_height="wrap_content" />

		// switch (pb1.getVisibility()){
		// case View.VISIBLE:
		// pb1.setVisibility(View.GONE); //完全隐藏
		// break;
		// case View.GONE:
		// pb1.setVisibility(View.VISIBLE); //显示
		// break;
		// }

		// 3.2.6 alertDialog

		// AlertDialog.Builder ad=new AlertDialog.Builder(ThridActivity.this);
		// ad.setTitle("alert");
		// ad.setMessage("你好啊,haha");
		// ad.setCancelable(false);
		// ad.setPositiveButton("确定", new DialogInterface.OnClickListener() {
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		//
		// }
		// });
		// ad.setNegativeButton("取消", new DialogInterface.OnClickListener() {
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		//
		// }
		// }
		// );
		// ad.show();

		// 3.2.7 ProgressDialog

		// 进度条dialog
		// ProgressDialog progressDialog=new ProgressDialog(ThridActivity.this);
		// progressDialog.setTitle("进度dialog");
		// progressDialog.setMessage("Loading...");
		// progressDialog.setCancelable(true);
		// progressDialog.show();

		// progressDialog.dismiss(); //关闭ProgressDialog

		// 3.3详解四种基本布局

		// linear 英[ˈlɪniə(r)]
		// 美[ˈlɪniər]
		// adj. 直线的，线形的; 长度的; <数>一次的，线性的; 通过单独的若干阶段来发展;

		// LinearLayout 又称作线性布局，是一种非常常用的布局。正如它名字所描述的一样，这
		// 个布局会将它所包含的控件在线性方向上依次排列。相信你之前也已经注意到了，我们在上
		// 一节中学习控件用法时，所有的控件就都是放在 LinearLayout 布局里的，因此上一节中的控
		// 件也确实是在垂直方向上线性排列的。

		// android:orientation="horizontal"水平
		// android:orientation="vertical" 竖直

		// android:layout_weight。这个属性
		// 允许我们使用比例的方式来指定控件的大小，它在手机屏幕的适配性方面可以起到非常重要
		// 的作用

		/*
		 * <Button android:id="@+id/tbtn3" android:text="启动alert"
		 * android:layout_width="0dp" android:layout_height="wrap_content"
		 * android:layout_weight="1" />
		 * 
		 * <Button android:id="@+id/tbtn2" android:text="显/隐pb"
		 * android:layout_width="0dp" android:layout_height="wrap_content"
		 * android:layout_weight="1" /> <ProgressBar android:id="@+id/pb1"
		 * android:layout_width="0dp" android:layout_height="wrap_content"
		 * android:layout_weight="1" /> <Button android:id="@+id/tbtn4"
		 * android:text="Btn4" android:layout_width="0dp"
		 * android:layout_height="wrap_content" android:layout_weight="1" />
		 */

		// 3.3.2 RelativeLayout 相对布局(113/555)<br>
		/*
		 * <RelativeLayout
		 * xmlns:android="http://schemas.android.com/apk/res/android"
		 * xmlns:app="http://schemas.android.com/apk/res-auto"
		 * xmlns:tools="http://schemas.android.com/tools"
		 * android:layout_width="match_parent"
		 * android:layout_height="match_parent"
		 * tools:context="com.yfairy.android.uiwidgettest.FourActivity">
		 * 
		 * <Button android:id="@+id/fbtn1" android:text="左上"
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content"
		 * android:layout_alignParentLeft="true"
		 * android:layout_alignParentTop="true"/>
		 * 
		 * <Button android:id="@+id/fbtn2" android:text="右上"
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content"
		 * android:layout_alignParentRight="true"
		 * android:layout_alignParentTop="true" />
		 * 
		 * <Button android:id="@+id/fbtn3" android:text="中间"
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content"
		 * android:layout_centerInParent="true" />
		 * 
		 * <Button android:id="@+id/fbtn4" android:text="左下"
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content"
		 * android:layout_alignParentLeft="true"
		 * android:layout_alignParentBottom="true"/>
		 * 
		 * 
		 * <Button android:id="@+id/fbtn5" android:text="右下"
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content"
		 * android:layout_alignParentRight="true"
		 * android:layout_alignParentBottom="true" />
		 * 
		 * </RelativeLayout>
		 */

		// 3.3.3 FrameLayout

		// 3.3.4 TableLayout

		// 3.4创建自定义控件

		// 3.5 ListView

		// ArrayAdapter<String> arrayAdapter = new
		// ArrayAdapter<String>(ListView1Activity.this,
		// android.R.layout.simple_list_item_1, Arrays.asList("one", "two",
		// "three"));
		// ListView listView = (ListView) findViewById(R.id.listView1);
		// listView.setAdapter(arrayAdapter);

		// 3.5.2 定制listview的界面

		//
		// inflate 英[ɪnˈfleɪt]
		// 美[ɪnˈflet]
		// vt. 使充气（于轮胎、气球等）; （使） 膨胀; （使） 通货膨胀; 物价上涨;

		// 3.5.3 提升listView的效率

		// 3.5.4 listview的点击事件

		// 3.6 单位和尺寸(138/555)<br>

		// 总结一下，在编写 Android 程序的时候，尽量将控件或布局的大小指定成 match_parent
		// 或 wrap_content，如果必须要指定一个固定值，则使用 dp 来作为单位，指定文字大小的时候
		// 使用 sp 作为单位。

		// 3.7 编写界面的最佳实践

		// 第4章：手机平板兼容，探究碎片(153/555)<br>

		// 4.4动态加载布局的技巧

		// Android 中一些常见的限定符可以参考下表。
		// 屏幕特征 限定符 描述
		// 大小
		// small 提供给小屏幕设备的资源
		// normal 提供给中等屏幕设备的资源
		// large 提供给大屏幕设备的资源
		// xlarge 提供给超大屏幕设备的资源

		// 这就意味着，当程序运行在屏幕宽度大于 600dp 的设备上时，会加载 layout-sw600dp/
		// activity_main 布局，当程序运行在屏幕宽度小于 600dp 的设备上时，则仍然加载默认的
		// layout/activity_main 布局。

		// 第5章：广播机制(189/555)<br>

		// 5.2接收系统广播

		// 5.2.1

		// 5.3 发送自定义广播(198/555)<br>
		System.out.println("hello");

		// <!-- 退出广播监听器 -->
		// <receiver android:name=".LogoutBroadcastReceiver">
		// <intent-filter>
		// <action android:name="LogoutBroadcastReceiver" />
		// </intent-filter>
		// </receiver>

		// 5.4 使用本地广播<br>

		// 第6章：数据存储(数据库)(221/555)<br>

		// 6.2文件存储

		// FileOutputStream out = null;
		// FileInputStream in=null;
		// //存储文件
		// try {
		// //输出文件
		// String fileName="file1";
		// out = openFileOutput(fileName, Context.MODE_PRIVATE);
		// out.write("见到你很高兴".getBytes("UTF-8"));
		//
		//
		// //读取文件
		// in=openFileInput(fileName);
		// byte[] data=new byte[in.available()];
		// in.read(data);
		// Log.i("ThreeActivityFileData", new String(data,"UTF-8"));
		//
		// Log.i("ThreeActivity", "end");
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if (null != out) {
		// try {
		// out.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// if(null!=in){
		// try {
		// in.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }

		// 6.3 SharedPreferences 存储

		// 保存数据
		// SharedPreferences.Editor sharedPreferencesEditor =
		// getSharedPreferences("sp1", MODE_PRIVATE).edit();
		// sharedPreferencesEditor.putString("name", "张三");
		// sharedPreferencesEditor.putInt("age", 18);
		// sharedPreferencesEditor.commit();
		// //读取数据
		// SharedPreferences sharedPreferences = getSharedPreferences("sp1",
		// MODE_PRIVATE);
		// Log.i("SharedPreferences:name", sharedPreferences.getString("name",
		// null));
		// Log.i("SharedPreferences:age", "" + sharedPreferences.getInt("age",
		// 0));

		// 6.4 sqlLite 数据库存储(239/555)<br>

		// 6.4.2升级数据库(246/555)<br>

		// 6.4.3添加数据

		// 6.4.7 使用 SQL 操作数据库 这个好用

		// 创建数据库
		// String dbSql="CREATE TABLE yf_student (" +
		// " id INTEGER PRIMARY KEY autoincrement," +
		// " name varchar(50) ,"
		// + " sex varchar(50) "
		// + ") ";
		// SQLiteHelperImpl sqLiteOpenHelper=new
		// SQLiteHelperImpl(this,"appdb1",null,3);
		// sqLiteOpenHelper.setCreateDbSql(dbSql);
		//
		// String dbSql2="CREATE TABLE yf_table1 (" +
		// " id INTEGER PRIMARY KEY autoincrement," +
		// " name varchar(50) ,"
		// + " sex varchar(50) "
		// + ") ";
		// sqLiteOpenHelper.setCreateDbSqlList(Arrays.asList(dbSql,dbSql2));
		// SQLiteDatabase sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
		//
		// //选择事件
		// switch (v.getId()) {
		//
		//
		// case R.id.three_button1:
		// //发送自定义广播
		// Intent intent = new Intent("LogoutBroadcastReceiver");
		// // sendBroadcast(intent);
		// //有序广播
		// sendOrderedBroadcast(intent, null);
		//
		// Log.i("ThreeActivity", intent.toString());
		//
		// break;
		// case R.id.three_button2:
		// //保存数据
		// SharedPreferences.Editor sharedPreferencesEditor =
		// getSharedPreferences("sp1", MODE_PRIVATE).edit();
		// sharedPreferencesEditor.putString("name", "张三");
		// sharedPreferencesEditor.putInt("age", 18);
		// sharedPreferencesEditor.commit();
		// //读取数据
		// SharedPreferences sharedPreferences = getSharedPreferences("sp1",
		// MODE_PRIVATE);
		// Log.i("SharedPreferences:name", sharedPreferences.getString("name",
		// null));
		// Log.i("SharedPreferences:age", "" + sharedPreferences.getInt("age",
		// 0));
		//
		// break;
		// case R.id.three_button3:
		//
		// //添加数据
		// ContentValues contentValues=new ContentValues();
		// contentValues.put("name","张三");
		// contentValues.put("sex","哈哈");
		// sqLiteDatabase.insert("yf_student",null,contentValues);
		// contentValues.clear(); //清除ContentValues中的数据
		// //添加第二条数据
		// contentValues.put("name","李思");
		// contentValues.put("sex","女");
		// sqLiteDatabase.insert("yf_student",null,contentValues);
		// contentValues.clear();
		// Log.i("ThreeActivity","insert success");
		//
		//
		//
		// Log.i("SQLiteOpenHelper", "SQLiteOpenHelper");
		//
		//
		//
		// break;
		//
		// case R.id.three_button4 : //添加按钮
		// Random random=new Random();
		// int rno=random.nextInt(1000);
		// sqLiteDatabase.execSQL("insert into yf_student (name, sex ) values(?,
		// ?) ",new Object[]{"孙琦"+rno,"哈哈"+rno});
		// ProgressDialog progressDialog=new ProgressDialog(this);
		// progressDialog.setTitle("进度");
		// progressDialog.setMessage("添加中...");
		// progressDialog.setCancelable(true);
		// progressDialog.show();
		// break;
		//
		// case R.id.three_button5 : //查询按钮
		// List<String> datas=new ArrayList<>();
		// Cursor cursor=sqLiteDatabase.rawQuery("select * from
		// yf_student",null);
		// while (cursor.moveToNext()){
		// Integer id=cursor.getInt(cursor.getColumnIndex("id"));
		// String name=cursor.getString(cursor.getColumnIndex("name"));
		// String sex=cursor.getString(cursor.getColumnIndex("sex"));
		// datas.add("id:"+id+" name:"+name+" sex:"+sex);
		// }
		// ArrayAdapter<String> newArrayAdapter=new
		// ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
		// listView1.setAdapter(newArrayAdapter);
		// break;
		// case R.id.three_button6 :
		// sqLiteDatabase.execSQL("delete from yf_student");
		// Toast.makeText(this,"删除所有数据成功",Toast.LENGTH_SHORT).show();
		// break;
		//
		// default:
		// break;
		// }
		
		//6.5 sqlLite 数据库实战(261/555)<br>

	}

}
