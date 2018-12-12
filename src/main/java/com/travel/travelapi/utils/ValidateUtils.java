package com.travel.travelapi.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtils {
    public static String validateNull(String field,String message){
        if(StringUtils.isBlank(field)){
            return message+"不能为空";
        }else {
            return "";
        }
    }
}
