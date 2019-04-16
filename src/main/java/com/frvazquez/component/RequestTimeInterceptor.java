package com.frvazquez.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.frvazquez.entity.LogEntity;
import com.frvazquez.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// guardamos el tiempo actual en milisegundos
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if (auth != null && auth.isAuthenticated()) {
			username = auth.getName();
		}

		LogEntity logger = new LogEntity(new Date(), auth.getDetails().toString(), username, url);
		logRepository.save(logger);
		LOG.info("REQUEST URL : " + url + " TIEMPO " + (System.currentTimeMillis() - startTime));
	}

}
