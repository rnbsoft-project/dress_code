package com.rnbsoft.dress_code.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 인터셉터는 사용자가 인증되지 않은 상태에서
// 보호된 페이지에 접근하려고 할 때, 로그인 페이지로 리다이렉트
@Component
public class AuthInterceptor implements HandlerInterceptor {

        public boolean preHandle(HttpServletRequest request
                                                  , HttpServletResponse response
                                                  , Object handler) throws Exception
        {
            HttpSession session = request.getSession();

            // 로그인이 되어있지 않을 경우, 접근을 제한하고 로그인 페이지로 이동
            if(session.getAttribute("userName") == null) {
                    response.sendRedirect("/loginForm");
                    return false;
            }
            // 로그인이 되어있다면 요청한 페이지에 접근
            return true;
        }
}
