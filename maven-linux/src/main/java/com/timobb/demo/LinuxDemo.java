package com.timobb.demo;

public class LinuxDemo {

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
		 * 1.compress：compress [rcv] 档案或目录 ==>压缩
		 * uncompress *.z 解压缩
		 * 2.gzip:可以解开compress，zip，gzip所压缩的文件
		 * gzip [-cdtv#] 档名 ，-v可以显示出压缩比等信息，-#压缩等级
		 * gzip -d 档案，将档案解压缩
		 * cat可以读取纯文本，zcat可以读取压缩的文件
		 * 3.bzip2比gzip更好，用法和gzip类似
		 * bzcat:读取bzip2压缩的文件
		 * 4.打包指令tar,上面的压缩指令只能针对单一文件
		 * tar [-ctxjzvfC]
		 * -c:建立打包档案，可配合-v显示打包的档名
		 * -t:查看打包的档案含有哪些信息
		 * -x:解打包或者解压缩
		 * -j:通过bzip2进行压缩或者解压缩
		 * -z:通过gzip进行压缩或者解压缩
		 * -v:显示正在处理的文件名
		 * -f:filename 要处理的文件名，建议写一个单独的-f
		 * -C:用在解压缩指定解压到特定的目录
		 * 用法:打包:tar -zcv -f test2.tar.gz test2.txt
		 * 查看tar中的数据类容:tar -ztv -f test2.tar.gz
		 * 解打包:tar -zxv -f test2.tar.gz
		 * 5.dump备份文件
		 * restore:还原dump备份的文件
		 * dd: if:输入流,of:输出流,==>把文件从某处移到某处
		 * 第十章：vim程序编辑器
		 * 1.vi 文件名  编辑文档
		 * vi使用方法，vi 文件名进入一般模式，
		 * 输入i，进入更改模式，
		 * 更改后按esc退出到一般模式,然后输入":wq"写入并退出
		 * 操作:x删除,dd删除游标所在的一整列,yy复制游标所在的一整行
		 * p:将复制的数据在光标的下一行粘贴
		 * 2.vim:使用时会开启一个.swp的文件，用于在断电等未知异常后恢复文档
		 * 目前一般用vim代替vi使用了
		 * 3.iconv:编码转换:
		 * iconv:--list 累出iconv支持的格式
		 * -f :from 来源的编码
		 * -t:to 转换后的编码
		 * -o:转换后的文件
		 * 如：icnov -f big5 to utf-8 test1.txt
		 * 第十一章：认识与学习bash
		 * 1.cat .bash_history 查看自己常用的shell命令，比如黑客可以根据此命令，进行操作
		 * 2.命令与档案补全功能，连按两次tab键
		 * 3.设置命令别名:如alias ll='ls -l'
		 * 直接输入alias 查看有哪些别名
		 * 4.程序化脚本shell scripts
		 * 5.type查看指令是bash内键的还是外部的,type ls
		 * 6.变量的取用与设定，echo
		 * 如echo $varible或者echo ${varible}
		 * 设定变量:varibleName=varibleValue即可,如myname=myvalue
		 * 7.用env观察环境变量,environment的缩写，环境
		 * 8.用set观察所有的变量
		 * 9.export 将自定义变量转换成环境变量，子程序只能继承父程序的环境变量，
		 * 所以通过转换使用自定义变量
		 * 10.locale -a 显示支持的语言编码
		 * 11.read读取键盘输入设为变量
		 * read [-pt]
		 * :p,后面可以接提示符
		 * t:后面可以接等待的秒数
		 * 12.declare声明变量的类型
		 * -a:将变量声明为array
		 * -i:将变量声明为int
		 * -x:与export类似
		 * -r:将变量设置为readonly
		 * 如declare -i sum2=1+2+3,echo $sum2结果为，6
		 * 13.ulimit限制档案开启的数量
		 * 14.变量的类容取代与删除:
		 * 15.alias 设置命令别名，unalias取消命令别名，
		 * 如alias ll='ls -l' ,unalias ll
		 * 历史命令:history
		 * 直接输入history查看所有历史
		 * history -c 清除历史，
		 * history -w 立即把历史些人.histroy文件
		 * 16.stty：设置系统按键功能
		 * stty -a:将所有的按键列出来
		 * 17.通配符的使用:
		 * *0到多个，？至少有一个
		 * 如:ls -l te*.txt 查找te开头的txt文件
		 * 18。
		 * 标准输入:stdin   standard in
		 * 标准输出:stdout
		 * 标准错误:stderr
		 * 19.命令执行的判断
		 * 一次执行多个命令，使用;分割命令即可，一次执行多个命令
		 * 如:ls -l ;cat test2.txt
		 * 20.管线命令(pipe)
		 * 管线命令使用"|" 操作,
		 * 如:ls -l /etc | more  这样分页查看etc下的信息
		 * 21.cut将信息的某一段切出来
		 * 如:echo $PATH | cut -d ':' -f 5
		 * 22.grep 从一行讯息中取出我们想要的
		 * grep [-acinv]
		 * 如:last | grep 'jiangzi'
		 * -v:取相反的数据,类似非
		 * 23.sort 排序
		 * 如：cat /etc/passwd | sort
		 * uniq:将重复的资料只显示一次
		 * 如:cat /etc/passwd | sort | uniq
		 * 24.wc 计算出文本有多少行，多少字,多少字符
		 * 如:wc test2.txt
		 * 25.tee 将数据流重导向到另外一个文件，考试时长考
		 * 26.split分割命令
		 * 第十二章：正规表示法与文件格式处理
		 * 1.grep找出指定的的字符串
		 * -A:after 的意思，出了列出改行，还列出改行的后面的行
		 * -B：before,列出改行及之前的行
		 * 如cat test2.txt | grep -A2 'ni'
		 * 也可直接使用grep 关键词  文件
		 * 如:grep 'me' test2.txt
		 * grep -v 'me' test2.txt取不是me关键词的类容
		 * -n:显示行号
		 * -i:取类容，忽略大小写，如grep -i 'me' test2.txt
		 * [a-z]一个方括号只代表一个字符，【a-z】代表a-z直接的一个字符
		 * ^非 如：grep '[^g]oo' test2.txt
		 * 取非小写,grep '[^a-z]' test2.txt
		 * 取大小写，英文，数字
		 * grep '[a-zA-Z0-9]' test2.txt
		 * 
		 * 取以某个单词开头的，^，如grep '^hell' test2.txt
		 * ^在方括号类代表反向选择，在其外代表以某某开头
		 * $表示以什么结尾的，如：grep '\.$' test2.txt取以.结尾的类容
		 * .点，表示一定有一个任意字符
		 * *代表重复前一个0到n次
		 * 如：grep 'g..d' 取出包含g??d个单词，如good
		 * 使用{}限定前一个字符的数量,如grep 'o{1}' 匹配1个o
		 * ,{1,3}最低有一个，最多有3个
		 * {2,}至少有几个
		 * 增强的正则表示法:配合egrep使用
		 * +:一个或一个以上的前一个字符
		 * ?:0个或一个前一个字符
		 * |:或
		 * 2.格式化打印printf
		 * 3.awk好用的数据处理工具
		 * 5.档案比对工具:diff
		 * diff
		 * -from file 原始档案
		 * -to file 新档案
		 * 如diff test2old.txt test2.txt
		 *6. 档案打印准备，pr
		 *如pr test2.txt
		 *第十三章：学习shell scripts
		 *1.shell script（程序脚本)
		 *.sh脚本执行的方式:
		 *1.1通过绝对路径,如/home/jiangzi/testshdir/testsh1.sh
		 *或者相对路径:./testsh1.sh，在当前命令的目录中输入
		 *1.2以bash程序执行:如bash shell.sh或者sh shell.sh
		 *2.echo -e 在shell脚本中是输出类容到屏幕上
		 *read -p "firstname" firstname
		 *echo -e "your name is : $firstname"
		 *exit 0
		 *上面动态读取输入，并输出到屏幕上
		 *3.动态的使用小命令:$(command)
		 *如:date=$(date +%Y%m%d)取格式化的日期
		 *file=${filename}${date} 动态的设置变量和取变量
		 *4.数值运算，简单的加减乘除
		 *var=$((x+y))
		 *5.利用test指令的测试功能
		 *如：test -e sh3.sh && echo "exits" || echo "not exits"
		 *测试某个文件是否存在
		 *-e 是测试一个东西在不在
		 *-f 该档案是否存在，file是档案
		 *-d 该目录是否存在
		 *-r,-w,-x测试该档案的权限
		 *数值比较
		 *-eq 相等
		 *-gt n1大于n2
		 *-lt n1小于n2
		 *6.条件判断式
		 *1.单层判断
		 *if[条件];then:
		 *fi结束if
		 *多层
		 *if[条件判断式];then
		 *	chenli
		 *else
		 *	buchewngli
		 *fi
		 *多个
		 *if[];then
		 *elif[];then
		 *elif[];then
		 *else
		 *	else block
		 *fi
		 *
		 *case $变量名称 in "变量类容"程序段
		 *esac
		 *7.利用function功能
		 *function fname(){
		 *程序块
		 *}
		 *8.循环
		 *while [con]
		 *do 
		 *done
		 *,
		 *for ...do ...done
		 *如:for var in a b c d
		 *do
		 * echo "$var"
		 *done
		 *exit 0
		 *第二种for
		 *for((初始值;限制值;步骤))
		 *do ...
		 *done
		 *如:for((i=0;i<10;i++))
		 *do 
		 *	echo "$i"
		 *done
		 *第十四章:Linux账号管理
		 *1.liux的账号，与群组
		 *使用者标识符：UID,GID在/etc/passwd中
		 *密码在/etc/shadow中
		 *文件/etc/passwd中每一行都代表一个账号
		 *文件/etc/group存取group信息
		 *2.账号管理
		 *2.1useradd添加账号
		 *如:sudo useradd vbird1 使用系统默认设置创建新的账号
		 *useradd -D 查看useradd默认值的设置
		 *2.2passwd:设定账号密码
		 *如:sudo passwd vbird1
		 *提示输入密码:
		 *再次输入密码:
		 *设置成功
		 *直接输入:passwd 不加账号，就是更改自己的密码
		 *更改的密码:是原始的加123
		 *2.3chage详细的密码参数显示功能
		 *如:chage -l jiangzi
		 *2.4usermod调整账号添加时的参数
		 *2.5userdel删除用户账号
		 *如:userdel -r vbird1 
		 *-r:家目录也一起删除
		 *2.6finger查询用户信息
		 *finger jiangzi
		 *chfn更改账户finger显示的信息
		 *3.chsh change shell的缩写
		 *4.使用id查询当前账户UID，GID
		 *id root查询root的UID,GID
		 *5.群组操作
		 *groupadd name 新建一个组
		 *groupmod 修改group信息
		 *groupdel 删除群组
		 *如：groupdel tgrouop1
		 *5.3gpasswd为群组设置密码
		 *gpasswd -a 用户 组名
		 *将用户添加到某个组中
		 *如:gpasswd -a tuser1 jiangzi
		 *gpasswd -d 将某个人移除改组
		 *6.使用者身份切换
		 *1.如何让一般使用者转变身份为root
		 *1.1以su 直接把身份变为root 需要root密码
		 *1.2以sudo 执行root的指令,比较常用
		 *su username 切换用户
		 *su - username或su -l username 切换用户，目录也切换到该用户
		 *如 su - tuser2
		 *exit 退出切换的用户
		 *2.sudo 
		 *在/etc/sudoers中的用户才能使用sudo
		 *sudo -u 后面接欲使用者，如果没有，则默认为root
		 *如:sudo -u tuser2 touch test2.txt用tuser2的身份创建文件
		 *visudo 修改sudoers
		 *7.who查询目前登录在系统上面的用户
		 *lastlog查询账号最近登录的时间
		 *write,mesg
		 *使用者谈话
		 *mail给使用的用户发邮件
		 *第十五章：磁盘配额与进阶文件管理
		 *第十六章:列行性工作排程
		 *列行工作类似定时任务
		 *1.只执行一次的任务
		 *1.1:at [mldvc]
		 *ubuntu不支持at
		 *2.定时执行的任务cron
		 *crontab
		 *-e:编辑工作内容
		 *-l:查询cron内容
		 *-r：移除cron
		 *第十七章:程序管理与SELinux初探
		 *1.父子progress通过PPID关联
		 *2.工作管理job control
		 *2.1&将指令丢到背景中运行
		 *如:cp thello.txt thello2.txt &
		 *显示:[1] 2541
		 *方括号中的2541为PID
		 *2.2使用vi时可以通过ctrl+z暂停，到bash中查找文件
		 *jobs：观察目前的背景工作状态
		 *-l:列出任务时显示pid
		 *-r:只列出运行中的任务
		 *-s:列出暂停的工作
		 *fg:(foreground)将背景工作拿到前景执行
		 *如:fg 2 将 【2】这个编号的背景工作拿到前景执行
		 *bg:让背景下的工作变为运行中
		 *3.管理背景中的工作:kill
		 *kill -l:列出目前kill能使用的singal有哪些
		 *kill -9 :立即强制删除一个工作
		 *如kill -9 %2 
		 *kill -15:以正常的方式结束一个工作
		 *nohup:可以在通过软件连接服务器时，
		 *即使退出也可以让任务在服务器背景运行
		 *3.ps查看程序的运行情况
		 *如查询自己bash的程序:ps -l
		 *查询所有系统运作的程序:ps aux
		 *当列表中CMD后面有<defunct>则代表为僵尸程序
		 *发现僵尸程序找到PPID，kill掉
		 *top:动态观察程序的变化
		 *top -d 后面接秒，间隔多少秒下滑是一次程序的变化
		 *如:top -d 5
		 *使用top后按q退出
		 *top -d 5 -p pid 查看某个pid的运行情况
		 *pstree:
		 *pstree -A:列出系统上所有的程序树
		 *pstree -Aup:同时显示pid与users
		 *当有僵尸程序时，可通过pstree找出
		 *dao 617
		 */
		System.out.println("hello linux");
	}

}
