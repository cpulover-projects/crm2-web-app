package com.cpulover.spring.crm2webapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonPointcut {

	@Pointcut("execution(* com.cpulover.spring.crm2webapp.controller.*.*(..))")
	public void forController() {
	}

	@Pointcut("execution(* com.cpulover.spring.crm2webapp.repository.*.*(..))")
	public void forRepository() {
	}
	
	@Pointcut("execution(* com.cpulover.spring.crm2webapp.service.*.*(..))")
	public void forService() {
	}
	
	@Pointcut("execution(* com.cpulover.spring.crm2webapp.service.*.find*(..))")
	public void forServiceFind() {
	}

	@Pointcut("forController() || forRepository() || forService()")
	public void forAll() {
	}

}
