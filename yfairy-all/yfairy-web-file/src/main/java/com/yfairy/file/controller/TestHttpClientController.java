package com.yfairy.file.controller;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testHttpClient")
public class TestHttpClientController {
	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Map<String, String[]> params = request.getParameterMap();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("响应类容:");
			for (Entry<String, String[]> entry : params.entrySet()) {
				stringBuilder.append(entry.getKey() + ":" + entry.getValue()[0].toString() + "  ,");
			}
			out.println(stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
