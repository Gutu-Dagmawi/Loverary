package com.library.utils;


import java.awt.Dimension;
import java.awt.Toolkit;


public class Constants{
	// Database Constants
	public static final String URL = "jdbc:postgresql://localhost:5432/loverary";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "etseye123";
	
	// Screen Constants
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int CENTER_X = (SCREEN_SIZE.width) / 2;
	public static final int CENTER_Y = (SCREEN_SIZE.height) / 2;

}