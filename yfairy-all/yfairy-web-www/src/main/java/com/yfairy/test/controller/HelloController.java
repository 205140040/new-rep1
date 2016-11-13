package com.yfairy.test.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yfairy.user.service.IHelloService;

@RequestMapping("/hello")
@Controller
public class HelloController {
	@Reference
	private IHelloService helloService;

	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello() {
		return helloService.hello("酱紫");
	}

	@RequestMapping("/writeWord")
	public void writeWord(HttpServletResponse response) {
		try {
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + new String("doc.doc".getBytes(), "ISO-8859-1"));
			byte[] res = helloService.writeWordByTemplate();
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(res);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
