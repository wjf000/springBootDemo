package com.wjf.demo.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.wjf.demo.utils.JWTUtils;
import com.wjf.demo.utils.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    /**
     * 在指定的请求执行之前执行，此方法的返回值决定请求是否继续执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Token");
        if (!StringUtils.hasText(token)) {
            throw new MyException("token不能为空");
        }
        try {
            JWTUtils.verify(token);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！错误 ->", e);
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过期！ ->", e);
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！错误 ->", e);
            return false;
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            return false;
        } return true;
    }
}
