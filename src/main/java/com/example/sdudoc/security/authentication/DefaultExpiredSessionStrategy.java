package com.example.sdudoc.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.sdudoc.util.ResultMap;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 默认 Session 过期处理
 *
 */
public class DefaultExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        ResultMap resultMap = new ResultMap(getClass().getName() + ":onExpiredSessionDetected()",
                "您的 Session 已过期，请重新登录。" + event.getSessionInformation().getLastRequest());
        String json = objectMapper.writeValueAsString(resultMap);

        event.getResponse().setContentType("application/json;charset=UTF-8");
        event.getResponse().getWriter().write(json);
    }
}
