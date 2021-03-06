package com.frvazquez.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("tarkComponent")
public class TaskComponent {

	private static final Log logger = LogFactory.getLog(TaskComponent.class);
	
	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		logger.info("TIME IS : " + new Date());
	}
	
}
