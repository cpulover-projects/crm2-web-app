package com.cpulover.spring.crm2webapp.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.cpulover.spring.crm2webapp.entity.Customer;

import lombok.extern.java.Log;

@Aspect
@Component
@Log
public class LoggingAspect {
	
	// define advice before all methods in all packages
	@Before("com.cpulover.spring.crm2webapp.aop.CommonPointcut.forAll()")
	private void beforeAll(JoinPoint joinPoint) {
		log.info(">>> Logging before executing method");

		// get method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		log.info("    Method: " + methodSig);

		// get method parameters
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			log.info("    Param: " + arg);
		}
	}
	
}
