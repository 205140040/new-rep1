package com.yfairy.android.demo;

import android.util.Log;

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
        Log.e("etag","error");

        //第二章：探究活动(28/555)<br>
    }
}
