package com.library.controller;


import com.library.utils.Constants;
import javax.swing.JFrame;


public class MainController {
	private static JFrame currentView = null;
	
	public static void setView(JFrame newView){
		// Dispose old view 
		if(currentView != null){
			currentView.dispose();
		} 
		
		newView.setLocation((Constants.CENTER_X) - (newView.getWidth()/2), (Constants.CENTER_Y)- (newView.getHeight()/2));
		currentView = newView;
		
		
		currentView.setVisible(true);
	}
}
