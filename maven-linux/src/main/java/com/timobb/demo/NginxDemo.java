package com.timobb.demo;

public class NginxDemo {

	public static void main(String[] args) {
		/**
		 * 1.ngigx 安装http://www.cnblogs.com/skynet/p/4146083.html
		 * 每次执行./configure 然后执行make 然后执行make install 
		 * 2.
		 * http://www.cnblogs.com/jianxie/p/3990377.html
		 * 2.1nginx启动: sudo
		 * /usr/local/nginx/sbin/nginx 
		 * 2.2重启: cd /usr/local/nginx/sbin ./nginx -s  reload 
		 * 2.3停止: 查询nginx主进程号
		 * ps -ef | grep nginx
		 * 从容停止 kill -QUIT 主进程号 
		 * 第3章:nginx基本配置
		 * 1.配置文件在conf下,nginx.conf
		 * 3.2.1虚拟主机
		 * 3.2.3配置基于域名的虚拟主机
		 * 3.4开启压缩配置gzip:
		 * http://www.cnblogs.com/mitang/p/4477220.html
		 *3.6:nginx的浏览器缓存设置
		 *第4章：nginx与php的安装
		 *第5章：nginx与jsp的安装与配置(重要)
		 *1.安装tomcat，
		 *http://cxshun.iteye.com/blog/1535188
		 *nginx结合tomcat实现动静分离
		 *http://www.tuicool.com/articles/A3mMJv
		 *2.查看nginx location如何配置，匹配规则
		 *第 6章：nginxHTTP负载均衡和反向代理的配置与优化
		 *1.DNS轮循实现负载均衡，如为一个域名添加多个A记录，但是这样有缺点
		 *6.5Nginx负载均衡服务器双机高可用
		 *第7章nginx的rewrite规则与实例
		 *1.rewrite功能就是实现url重定向
		 *第8章：nginx模块开发
		 *第9章：nginx的web缓存服务
		 *第10章：nginx在国内知名网站的应用案例
		 *第11章：nginx的非典型应用
		 *11.1用HTTPS（SSL)构建一个安全的nginxweb服务器
		 *dao 168
		 */
	}

}
