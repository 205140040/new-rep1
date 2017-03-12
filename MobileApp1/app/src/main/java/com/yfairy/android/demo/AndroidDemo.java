package com.yfairy.android.demo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by jiangzi on 2017/3/12.
 */

public class AndroidDemo {
    public static void hello() {
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
         *  教程: Android学习之路<br>
         * http://stormzhang.com/android/2014/07/07/learn-android-from-rookie/<br>
         *
         * 推荐书籍：第一行代码<br>
         * 第一章：开启启程(1/555)<br>
         * 第二章:探究活动(28/555)<br>
         */
        System.out.println("hello");
        Log.d("tag1", "log debug ...");
        //第一章：开启启程(1/555)<br>

        //目录介绍:java放代码的地方,
        //res:存放资源文件目录:drawabl存放图片，layout存放布局,values存放字符串
        //AndroidManifest.xml存放整个项目的配置文件

        //通过AndroidMonitor打开查看日志的窗口LogCat:
        System.err.println("通过AndroidMonitor打开查看日志的窗口:");
        //1.4.2使用日志工具Log，Log.v()(verbose),  Log.d()(debug), Log.i()(info),Log.e()(error)
        Log.e("etag", "error");

        //第二章：探究活动(28/555)<br>
        //活动activity，是一种包含用户界面的组件，主要用于和用户进行交互<br>

        //加载布局
        // setContentView(R.layout.first_layout);
        //所有的活动都要在manifest中注册
        //注册活动
        //  <activity android:name=".FirstActivity" android:label="FirstActivity"  >
        //        <intent-filter>
        //              <action android:name="android.intent.action.MAIN" />
        //             <category android:name="android.intent.category.LAUNCHER" />
        //      </intent-filter>
        //    </activity>

        //设置无标题
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        //添加Toast提示 setOnClickListener
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"click button1",Toast.LENGTH_SHORT).show();
//            }
//        });

        //2.2.6在活动中使用菜单

        //Android Studio下创建menu布局文件
        //http://www.cnblogs.com/ssqqhh/p/5213331.html

        //销毁一个活动，类似退出
        //finish();

        //2.3使用Intent在活动间穿梭
        //通过Intent启动活动
        //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
       // startActivity(intent);
        //点击back键就可以销毁活动类似调用finish,返回上级菜单

        //2.3.2使用隐式Intent(45/555)<br>
    }
}
