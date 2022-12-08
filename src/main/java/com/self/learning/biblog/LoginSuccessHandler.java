package com.self.learning.biblog;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomUserDetails custom = (CustomUserDetails) authentication.getPrincipal();
		
        String redirectURL = request.getContextPath();

        if (custom.hasRole("admin")) {
            redirectURL = "/admin";
        } else if (custom.hasRole("customer")) {
            redirectURL = "/";
        }
         
        response.sendRedirect(redirectURL);
	}

}
