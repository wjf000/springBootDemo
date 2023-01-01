package com.wjf.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wjf.demo.entity.VueAdminTemplateUser;
import org.springframework.util.StringUtils;

import java.util.Calendar;

/**
 * @author admin
 */
public class JWTUtils {

    /**
     * @param u user
     * @return token
     */
    public static String getToken(VueAdminTemplateUser u) {
        Calendar instance = Calendar.getInstance();
        // 默认令牌过期时间七天
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("UserId", u.getId()).withClaim("username", u.getUsername());

        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(u.getPassword()));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) throws MyException {
        if (!StringUtils.hasText(token)) {
            throw new MyException("token不能为空");
        }

        // 获取登录用户真正的密码
        String password = "111111";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }
}
