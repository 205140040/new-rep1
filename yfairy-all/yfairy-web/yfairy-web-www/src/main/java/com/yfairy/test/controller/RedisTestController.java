package com.yfairy.test.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfairy.common.annotation.NotNeedSession;

@RequestMapping("/redisTest")
@Controller
public class RedisTestController {

	@NotNeedSession
	@RequestMapping("/helloRedis")
	public void helloRedis(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * Spring Session + Redis实现分布式Session共享
		 * http://www.codexiu.cn/nosql/blog/42201/
		 * 这篇文章更详细:
		 * http://edbiji.com/doccenter/showdoc/161/nav/2949.html
		 */
		String attributeName = request.getParameter("attributeName");
		String attributeValue = request.getParameter("attributeValue");
		request.getSession().setAttribute(attributeName, attributeValue);
		PrintWriter out = response.getWriter();
		out.write("Name:" + attributeName + "\tValue:" + attributeValue);
		out.println("<br>");
		out.println("SessionId:" + request.getSession().getId());
	}
}
