package com.demo.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 正则表达式工具类
 * 
 * @author DELL
 * 
 * @since 2017-04-26
 *
 */
public class RegularExpression {
	
	/**
	 * 
	 * @Title: getNumberByRegularExpression   
	 * @Description: 判断对象是否存在
	 * 
	 * @param: string
	 * @return: String      
	 * @throws:
	 * 
	 */
	public static String getNumberByRegularExpression(String string){
		String regEx = "[^0-9]";
		
		Pattern pattern = Pattern.compile(regEx);   
		Matcher matcher = pattern.matcher(string);
		
		String result = matcher.replaceAll("").trim();
		
		if (!Tools.objectIsNullOrNot(result)) {
			return result;
		}
		
		return "0";
	}

}
