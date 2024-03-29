package com.example.sdudoc.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.sdudoc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认认证失败处理
 *
 */
@Component
public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String json = objectMapper.writeValueAsString(new ResultMap(getClass() + ":onAuthenticationFailure()", exception.getMessage()));
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
    }
}
