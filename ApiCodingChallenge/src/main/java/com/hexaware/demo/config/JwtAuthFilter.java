package com.hexaware.demo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired private JwtService jwtService;
    @Autowired private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

    	String authHeader = request.getHeader("Authorization");
    	String token = null, username = null;

    	if (authHeader == null || !authHeader.startsWith("Bearer ")) {
    	    chain.doFilter(request, response); 
    	    return;
    	}

    	token = authHeader.substring(7);
    	try {
    	    username = jwtService.extractUsername(token);
    	} catch (Exception e) {
    	    
    	    chain.doFilter(request, response);  
    	    return;
    	}

    }
}
