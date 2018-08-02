package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class resources {
	
	public static WebDriver driver;
	public static Properties Repository = new Properties();
	public static Properties Config = new Properties();
	public static Properties AppText = new Properties();
	
	public static File f ;
	public static FileInputStream FI;
	
public static void Initialize() throws IOException {
		
		
		System.out.println(System.getProperty("user.dir"));
		
		f = new File(System.getProperty("user.dir")+"//src//com//Repository//config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"//src//com//Repository//birst.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
	}

}
