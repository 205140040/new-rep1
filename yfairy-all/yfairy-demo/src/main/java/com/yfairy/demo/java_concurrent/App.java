package com.yfairy.demo.java_concurrent;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(new Date().toLocaleString());
        System.out.println("哈哈");
        System.out.println(Thread.currentThread());
    }
}
