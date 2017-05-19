package com.demo.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.demo.data.ResultData;
import com.demo.service.UserLoginService;
import com.demo.tools.Tools;
import com.demo.vo.UserLoginVo;

@Service
@Primary
public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public ResultData loginIsSuccess(UserLoginVo userLoginVo) {
		// TODO Auto-generated method stub
		if(!Tools.objectIsNullOrNot(userLoginVo.getUsername()) && !Tools.objectIsNullOrNot(userLoginVo.getPassword())){
			
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userLoginVo.getUsername(), userLoginVo.getPassword());
			Subject subject = SecurityUtils.getSubject();
			SecurityUtils.getSecurityManager().logout(subject);
			
			try {
				subject.login(usernamePasswordToken);
				
				return new ResultData(10000, "成功！", null, System.currentTimeMillis());
				
			} catch (UnknownAccountException e){
				return new ResultData(10104, "登陆用户不存在！", null, System.currentTimeMillis());
	        } catch (IncorrectCredentialsException e){
	        	return new ResultData(10103, "登陆密码错误！", null, System.currentTimeMillis());
	        } catch (LockedAccountException e) {
	        	return new ResultData(10303, "您的账户已被锁定,请与管理员联系！", null, System.currentTimeMillis());
	        } catch (ExcessiveAttemptsException e){
	        	return new ResultData(10100, "登录失败次数过多,请稍后再试！", null, System.currentTimeMillis());
	        } catch (Exception e){
	        	System.out.println(e);
	        	return new ResultData(10010, "系统发生错误，请联系管理员！", null, System.currentTimeMillis());
	        }
            
        }
		
		return new ResultData(10102, "登陆失败！", null, System.currentTimeMillis());
	}
	

}
