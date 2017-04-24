package com.yfairy.mbgenerator.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class GeneratorRun {

	private static final String generatorConfigPath = "com/yfairy/mbgenerator/demo/generatorConfig.xml";

	private static final boolean SYSO_FLAG = false;

	private static final String DB_PREFIX = "yf_";

	private static final String targetProject = "src/main/java";

	private static final String baseTargetPackage = "com.yfairy.demo";

	public static void main(String[] args) {
		/**
		 * MyBatis Generator<br>
		 * 官网:http://www.mybatis.org/generator/<br>
		 * 
		 */
		// delete all mapper.xml
		String userDir = System.getProperty("user.dir");
		System.out.println("userDir:" + userDir);
		Path srcpath = Paths.get(userDir, "src/main/java");
		File srcFile = srcpath.toFile();
		System.out.println("srcFile:" + srcFile.getAbsolutePath());
		listDirectoryAndDeleteMapperXml(srcFile);

		// 生成不同的表的配置文件
		List<String> tableNames = Arrays.asList("yf_blog_author", "yf_student", "yf_student_address", "yf_user",
				"yf_user_address");
		List<String> repPreTableNames = new ArrayList<>();
		for (String tn : tableNames) {
			String rs = tn.replace(DB_PREFIX, "");
			repPreTableNames.add(rs);
		}
		System.out.println(repPreTableNames);

		// 把表分组
		Map<String, Set<String>> tableGroup = new ConcurrentHashMap<>();
		for (String tn : repPreTableNames) {
			String group = tn.split("_")[0];
			println(group);
			Set<String> value = tableGroup.get(group);
			if (null == value) {
				value = new HashSet<>();
			}
			value.add(tn);
			tableGroup.put(group, value);
		}
		System.out.println(tableGroup);

		// 遍历组，生成组的generatorConfig
		for (Entry<String, Set<String>> entry : tableGroup.entrySet()) {
			String key = entry.getKey();
			StringBuilder javaModelGenerator = new StringBuilder();
			String l1 = "<javaModelGenerator targetPackage=\"" + baseTargetPackage + "." + key
					+ ".dbmodel\" targetProject=\"src/main/java\" >";
			String l2 = "<property name=\"enableSubPackages\" value=\"true\" />";
			String l3 = "<property name=\"trimStrings\" value=\"true\" />";
			String l4 = "</javaModelGenerator> ";
			javaModelGenerator.append(l1).append("\n").append(l2).append("\n").append(l3).append("\n").append(l4);

			Set<String> sets = entry.getValue();
			for (String tableName : sets) {
				String javaObjName = dbTableNameToJavaObjName(tableName);
				System.out.println("javaObjName:" + javaObjName);
				System.out.println();
				String tl1 = "<table tableName=\"" + DB_PREFIX + tableName + "\" domainObjectName=\"" + javaObjName
						+ "\"";
				System.out.println("table:" + tl1);
			}

			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("group:" + key);
			System.out.println(javaModelGenerator.toString());
			System.out.println("-------------------------------");
			System.out.println();

		}

		/**
		 * 使用XML配置文件从Java运行MBG
		 */
		// runGenerator();
		
		System.out.println("keng");

		Logger.getGlobal().info("success...");

	}

	private static String dbTableNameToJavaObjName(String tableName) {
		StringBuilder result = new StringBuilder();
		String[] ts = tableName.split("_");
		for (String t : ts) {
			if (null != t) {
				String firstStr = t.substring(0, 1);
				String firstStrUpper = firstStr.toUpperCase();
				String other = t.substring(1, t.length());
				result.append(firstStrUpper).append(other);
			}
		}
		return result.toString();
	}

	private static void println(String line) {
		if (SYSO_FLAG) {
			System.out.println(line);
		}
	}

	private static void runGenerator() {
		InputStream inputStream = null;
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Resource resource = new ClassPathResource(generatorConfigPath);
			inputStream = resource.getInputStream();
			Configuration config = cp.parseConfiguration(inputStream);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void listDirectoryAndDeleteMapperXml(File rootFile) {
		File[] files = rootFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				println("目录:" + file.getAbsolutePath());
				listDirectoryAndDeleteMapperXml(file);
			} else {
				println("文件:" + file.getAbsolutePath());
				if (null != file && file.exists()) {
					String fileName = file.getName();
					println(fileName);
					if (fileName.endsWith("Mapper.xml")) {
						file.delete();
					}
				}
			}
		}
	}

}
