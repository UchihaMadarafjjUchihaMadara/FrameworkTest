package com.demo.service;

import com.demo.data.ResultData;
import com.demo.vo.UserLoginVo;


/**
 * @Description: 登录服务模块
 * 
 * @author DELL
 * 
 * @since 2017-04-26
 *
 */
public interface UserLoginService {
	/**
	 * @Title: loginIsSuccess
	 * @Description：根据studentId和password验证登录
	 * 
	 * @param studentLoginVo
	 * @return ResultData
	 * @throws：
	 * 
	 */
	public ResultData loginIsSuccess(UserLoginVo userLoginVo);
}
