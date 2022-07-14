package com.plateer.ec1.util;

public class PaddingUtil {
    public static String padLeftZeros(String input, int length){
        if(input.length() >= length) return input;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < length - input.length()){
            sb.append('0');
        }
        sb.append(input);
        return sb.toString();
    }
    public static String padRightZeros(String input, int length){
        if(input.length() >= length) return input;
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        while(sb.length() < length - input.length()){
            sb.append('0');
        }
        return sb.toString();
    }
    public static String padLeftString(String input, int length){
        if(input.length() >= length) return input;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < length - input.length()){
            sb.append(' ');
        }
        sb.append(input);
        return sb.toString();
    }
    public static String padRightString(String input, int length){
        if(input.length() >= length) return input;
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        while(sb.length() < length - input.length()){
            sb.append(' ');
        }
        return sb.toString();
    }
}
