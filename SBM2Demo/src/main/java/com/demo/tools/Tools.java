package com.demo.tools;

import java.util.List;
import java.util.Map;

/**
 * @Description: 工具类
 * 
 * @author DELL
 * 
 * @since 2017-04-26
 *
 */
public class Tools {


	/**
	 * 
	 * @Title: objectIsNullOrNot   
	 * @Description: 判断对象是否存在
	 * 
	 * @param: object      
	 * @return: boolean      
	 * @throws:
	 * 
	 */
    public static boolean objectIsNullOrNot(Object object) {

        if (object == null) {
            return true;
        }

        if(object instanceof String && object == ""){
            return true;
        }

        if (object instanceof List<?> && ((List<?>) object).size() == 0) {
            return true;
        }

        if (object instanceof Map<?, ?> && ((Map<?, ?>) object).size() == 0) {
            return true;
        }

        return false;
    }
}
