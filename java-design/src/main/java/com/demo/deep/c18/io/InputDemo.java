package com.demo.deep.c18.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.StringReader;

public class InputDemo {

	public static void main(String[] args) {
		//reader缓冲输入文件
		try {
			String file="C:\\Users\\admin\\Desktop\\tio.txt";
			BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\tio.txt"));
			StringBuilder stringBuilder=new StringBuilder();
			//当readLine返回null时就到了文件的末尾
			String s;
			while(null!=(s=bufferedReader.readLine())){
				stringBuilder.append(s+"\n");
			}
			System.out.println(stringBuilder.toString());
			bufferedReader.close();
			//StringReader
			StringReader stringReader=new StringReader(stringBuilder.toString());
			int c;
			while((c=stringReader.read())!=-1){
				//一次读取一个字符
				System.out.print((char)c);
			}
			System.out.println();
			stringReader.close();
			//fileinputstream
			FileInputStream fileInputStream=new FileInputStream(file);
			int i;
			while((i=fileInputStream.read())!=-1){
				//一次读取一个字符
				System.out.print((char)i);
			}
			System.out.println();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
