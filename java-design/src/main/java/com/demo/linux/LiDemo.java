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
		 * 绝对路径：由根目录/开头的，如：/home/testd1
		 * 相对路径：如./home/testd1
		 * ./代表当前的目录,
		 * ../代表上一级目录,cd ../代表打开上级目录
		 * 第七章：linux档案与目录管理
		 * 1.cd:变换目录
		 * pwd:显示当前的目录
		 * mkdir:建立新的目录
		 * rmdir：删除一个空的目录
		 * pwd:(print work directory)用法 pwd -P 或pwd，-P是显示完整路径，而非连接路径
		 * mkdir:建立文件夹，mkdir [-mp] 文件名称
		 * -m :创建时配置文件的权限,-p自动递归创建文件夹，如果直接输入mkdir a/b/c无法创建，
		 * 通过mkdir -p a/b/c则可以
		 * rmdir:删除空的目录,rmdir [-p] -p连同上层空的目录一起删除
		 * rm -r 目录 ,将目录下的所有东西都删除
		 * 2.echo $PATH 显示环境变量
		 * 3.档案与目录的显示:ls
		 * 常用的ls -l ,-l长数据串显示，包含文件的大小，权限等信息
		 * cp :复制档案或目录， cp 源文件名  新文件
		 * cp -r 代表递归复制
		 * rm:移除档案或目录
		 * rm [-fir]
		 * -f:忽略不存在的
		 * -r：递归删除
		 * -i:给出删除提示
		 * mv:移动档案或目录，或者更改名称
		 * -f:force 强制的意思，强制覆盖
		 * -i:询问是否覆盖
		 * rename也可以用来改变名称
		 * 4.查看档案内容
		 * cat:由第一行开始显示档案的类容(concatenate的简写，连续，讲一个文件的类容连续输出在屏幕上)
		 * tac:从最后一行开始显示
		 * nl:显示并且输出行号
		 * more:一页一页的显示类容
		 * less:与more类似，但可以向前翻页
		 * head:只看头几行 head [-n number] 显示前多少行
		 * tail(尾巴):只看尾巴几行 tail [-n number] 显示后多少行
		 * od:以二进制的方式查看
		 * 5.touch修改档案时间，或者建立一个空的档案
		 * umask -S 查看默认的权限
		 * file:查看文件类型,file 文件或目录名称
		 * which [-a] 文件:寻找执行档
		 * -a :将找到的所有的文件路径都列出来
		 * whereis ：寻找特定的档案
		 * locate:寻找档案，但是默认数据库记录档案，一天更新一次，所有新建的无法找到，
		 * 可使用updatedb后，再用locate
		 * find:查找文件，因为不是通过文档数据库查找，而是全盘查找，速度慢
		 * 第八章：linux磁盘与文件系统管理
		 * 1.df列出文件系统的磁盘使用量,df -h
		 * 2.ln[sf] 来源文件 目标文件,制作link 快捷方式
		 * -s:如果不加参数就是hard link，加了s就是symbolic link
		 * -f:如果目标文件存在时，先移除目标文件在建立
		 * fdisk:磁盘分区
		 * mkfs:磁盘格式化
		 * fsck:磁盘检验
		 * 3.mount:磁盘挂载
		 * umount [-fn]:将挂载的文件卸除
		 * 第九章：档案与文件系统的打包与压缩
		 * dao 301页
		 */
	}

}
