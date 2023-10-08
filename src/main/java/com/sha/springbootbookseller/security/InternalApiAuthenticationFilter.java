package com.sha.springbootbookseller.security;

import com.sha.springbootbookseller.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class InternalApiAuthenticationFilter extends OncePerRequestFilter {

    private final String accessKey;

    public InternalApiAuthenticationFilter(String accessKey) {
        this.accessKey = accessKey;
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().startsWith("/api/internal");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String requestedKey = SecurityUtils.extractAuthTokenFromRequest(request);

            if(null == requestedKey || !requestedKey.equals(accessKey)) {
                log.warn(">> Internal Key endpoint requested without/ wrong key uri: {} ", request.getRequestURI());
                throw new RuntimeException(">> Unauthorized Access.");
            }

            UserPrincipal user = UserPrincipal.createSuperUser();

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            log.error(">> Unable to set user authentication in security context." , e);
        }
        filterChain.doFilter(request,response);
    }
}
