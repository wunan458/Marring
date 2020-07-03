package cn.marring.api.filter;

import cn.marring.api.configuration.AppContext;
import cn.marring.dao.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wn 2020-06-30 11:26
 */
@Component
public class ThirdSessionAuthFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        //获取请求头部分的Authorization
        String authHeader = request.getHeader(this.tokenHeader);
        //如果请求路径为微信通知后台支付结果则不需要token（之后会在具体的controller中，对双方签名进行验证防钓鱼）
        String url = request.getRequestURI().substring(request.getContextPath().length());

        if (url.equals("/auth/auth_user") || url.equals("/test")
                || url.equals("/doc.html") || url.contains("webjars")
                || url.equals("/swagger-resources") || url.equals("/v2/api-docs")) {
            chain.doFilter(request, response);
            return;
        }

        if (null == authHeader || !authHeader.startsWith("Bearer")) {
            throw new RuntimeException("非法访问用户");
        }
        // The part after "Bearer "
        final String thirdSessionId = authHeader.substring(tokenHead.length());
        String wxSessionObj = stringRedisTemplate.opsForValue().get(thirdSessionId);
        if (StringUtils.isEmpty(wxSessionObj)) {
            throw new RuntimeException("用户身份已过期");
        }

        // 设置当前登录用户
        try (AppContext appContext = new AppContext(wxSessionObj.substring(wxSessionObj.indexOf("#") + 1))) {
            chain.doFilter(request, response);
        }
    }

}