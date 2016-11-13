package com.yfairy.demo.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerDemo {

	public static void main(String[] args) throws Exception {
		// 官网demo:http://freemarker.org/docs/pgui_quickstart_all.html
		// * freemarker： http://blog.csdn.net/wpydaguan/article/details/44984021

		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setDirectoryForTemplateLoading(new File("D:\\new-rep1\\yfairy-all\\yfairy-demo\\src\\main\\resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);

		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/*
		 * You usually do these for MULTIPLE TIMES in the application
		 * life-cycle:
		 */

		/* Create a data-model */
		Map<String, Object> root = new HashMap<>();
		root.put("user", "Big Joe");
		Product latest = new Product();
		latest.setUrl("products/greenmouse.html");
		latest.setName("green mouse");
		root.put("latestProduct", latest);

		Man m1 = new Man("张三", 18, "哈哈", new Date(), new BigDecimal(8888), false);
		Man m2 = new Man("李思", 19, "哈哈", new Date(), new BigDecimal(8881), true);
		root.put("nowDate", new Date().toLocaleString());
		root.put("man1", m1);
		root.put("man2", m2);
		root.put("page2title", "page2title");
		root.put("page2tableContent", "page2tableContent");

		/* Get the template (uses cache internally) */
		// Template temp = cfg.getTemplate("test.ftlh");
		Template template = cfg.getTemplate("template.html");

		/* Merge data-model with template */
		String desktop = "C:\\Users\\jiangzi\\Desktop";

		File templateWord = new File(desktop, "freemarker1.doc");
		OutputStream outputStream = new FileOutputStream(templateWord);
		Writer out = new OutputStreamWriter(outputStream);
		template.process(root, out);
		outputStream.close();
		out.close();
		System.out.println("success...");
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.
	}

}
