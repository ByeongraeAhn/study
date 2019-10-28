package com.anbr;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestParameterLoggingFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(RequestParameterLoggingFilter.class);

    public RequestParameterLoggingFilter(Enum Level) {
        System.out.println("로그레벨 : " + Level);
    }

    @Override
    public void init(FilterConfig fc) throws ServletException { 
    }

    @Override
    public void destroy() {  
    }	


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String params = request.getParameterMap()
                            .entrySet()
                            .stream()
                            .map(entry -> entry.getKey() + "=" + String.join(",", entry.getValue()))
                            .flatMap(Stream::of)
                            .collect(Collectors.joining("&"));
        log(params);
        chain.doFilter(request, response);
    }

    private void log(String params) {
        logger.info("=======================================");
        logger.info(params);
        logger.info("=======================================");
    }
}