package com.devlhse.crazyrace.util;

public class StringUtils {

    public static String[] splitLineInput(String lineOfFile) {
        if(lineOfFile == null){
            return new String[0];
        }
        return lineOfFile.split("\\s+");
    }
    
    public static int convertToInt(String input) {
    	try {
    		return Integer.valueOf(input);
    	}catch(Exception e) {
    		return 0;
    	}
    }
    
    public static double convertToDouble(String input) {
    	try {
    		return Double.valueOf(input);
    	}catch(Exception e) {
    		return 0;
    	}
    }
}
