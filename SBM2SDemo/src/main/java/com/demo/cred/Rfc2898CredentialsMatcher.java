package com.demo.cred;

import java.io.UnsupportedEncodingException;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.util.ByteSource;

import com.demo.tools.CryptoUtils;

public class Rfc2898CredentialsMatcher extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// TODO Auto-generated method stub
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		SimpleAuthenticationInfo sInfo = (SimpleAuthenticationInfo) info;
		
		// 获取各种凭证
		Object credentials = sInfo.getCredentials();
		char[] pw = usernamePasswordToken.getPassword();
		ByteSource credentialsSalt = sInfo.getCredentialsSalt();
		
		// 将凭证解码成字符串
		try {
			String hashedPassword = String.valueOf(credentials);
			String password = String.valueOf(pw);
			String salt = new String(Base64.decode(credentialsSalt.toBase64()), "UTF-8");
			
			return CryptoUtils.verify(hashedPassword, password, salt);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}
	

}
