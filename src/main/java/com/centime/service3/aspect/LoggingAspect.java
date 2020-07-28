package com.centime.service3.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.centime.service3.service.*.*(..))")
	public void logMethodArgument(JoinPoint joinPoint) {
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.info("Method called is:: " + joinPoint.getSignature() + "with arguments::" + arguments);

	}
	 
	@Before("@annotation(com.centime.service3.annotation.LogMethodParam)")
	public void log(JoinPoint joinPoint) {
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.info("Method called is:: " + joinPoint.getSignature() + " with arguments::" + arguments);
	}
	 
	 
}
