package com.demo.linux;

public class LiDemo {

	public static void main(String[] args) {
		/**
		 * 基础指令的操作:
		 * 1.显示日期与时间：date
		 * 2.日历cal 使用方法:cal [month] [year] 显示某年，某月
		 * 3.计算器bc
		 * 1.1显示格式化日期:date +%Y-%m-%d
		 * 4.常用按键
		 * 4.1tab命令补全
		 * 4.2ctrl+c中断目前的程序，如输入 find / ，程序一直运行，ctrl+c后可以中断
		 * 5.man page 查看命令说明，如 man date,
		 * 此时可用用space键翻页，或输入/ 某个单词，查找相关信息
		 * 6.文书编辑器:nano
		 * 7.惯用的关机指令：shutdown 如：shutdown -r now(关机时需要指定时间),
		 * shutdown -h +10 十分钟后关机,
		 * shutdown -c 取消关机指令
		 * 第六章：档案权限与目录配置
		 * 1.ls列出文件信息
		 * 1.1 -rwxrwx---
		 * 第一个字符-,代表这个档案，是档案，还是目录，后者连接文件
		 * rwx 代表档案拥有者的权限，r读，w写，x可执行
		 * 后边rwx代表档案所属群组权限
		 * 最后边的---代表，第三者的权限，-代表无权限
		 * chgrp改变文件所属群组，如：chgrp -R （递归改变所有的） 组名  文件名 
		 * 如：chgrp -R users1 test1.txt
		 * 
		 * chown改变文件所有者
		 * chmod改变文件的权限 r:4,w:2,x:1
		 * 使用方法:chmod -R xyz 如：chmod 777 可读，可写，可执行
		 * 变换目录的指令cd(change directory)
		 * 目录的r权限拥有，但是没有x的权限，则无法进入该目录，x 可执行权限控制是否可进入该目录
		 * mkdir(make directory)建立目录
		 * x 在目录中与能否进入目录有关，w 则是有无权限更改，删除,新建
		 * 2.linux目录
		 * usr(unix software resource) 存放操作系统软件资源，类似window program files
		 * var 目录针对常态型变动的档案
		 * 3.绝对路径与相对路径
		 */
	}

}
