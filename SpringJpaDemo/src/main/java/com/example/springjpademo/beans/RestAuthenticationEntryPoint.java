package com.example.springjpademo.beans;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint
{

	@Override
	 public void commence( HttpServletRequest request, HttpServletResponse response,
	 AuthenticationException authException ) throws IOException
	 {
		response.addHeader("WWW-Authenticate", "my-realm");
	   response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"unauthorized");
	 }

}
