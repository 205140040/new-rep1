package com.yfairy.demo.javacore;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ScriptAndAptDemo {

	public static void main(String[] args) {
		/**
		 * 第10章：脚本,编译，与注解处理731/858<br>
		 */

		//10.2编译器api
		JavaCompiler javaCompiler=ToolProvider.getSystemJavaCompiler();
		javaCompiler.run(null, System.out, System.err, "ScriptAndAptDemo");
		
		//10.3使用注解
		
	}

}
