package com.tm.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.tm.common.util.aes.AES;

public class TokenHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		 	String token = request.getHeader("token"); 
	        String method=request.getMethod().toUpperCase();
	        if(token!=null && AES.isOk(token) && method.equals("POST")){//成功
	             //
	        }else{  
	            return;
	        }  
	        nextHandler.handle(target, request, response, isHandled);
	    }  
	}
