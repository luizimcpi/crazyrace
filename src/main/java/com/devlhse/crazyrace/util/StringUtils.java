package com.devlhse.crazyrace.util;

public class StringUtils {

    public static String[] splitLineInput(String lineOfFile) {
        if(lineOfFile == null){
            return new String[0];
        }
        return lineOfFile.split("\\s+");
    }
}
