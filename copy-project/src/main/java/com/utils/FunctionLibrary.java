package com.utils;

/*Created by Sakthi Ganesh- 13/12/2006
 * 
 */


//to remove the comma in the numbers
public class FunctionLibrary {
	
	public static String removeComma(String text){
		String splitted[] = text.split(",");
		StringBuffer sb = new StringBuffer();
		String retrieveData = "";
		
		for(int i =0; i<splitted.length;i++){
			retrieveData = splitted[i];
			 sb.append(retrieveData);
		}
		
		
		text = sb.toString();
		return text;
		
	}

}
