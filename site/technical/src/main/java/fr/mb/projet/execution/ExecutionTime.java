package fr.mb.projet.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;




@Aspect
public class ExecutionTime {
	
	private static final Logger logger = LogManager.getLogger(ExecutionTime.class);
	
	
	
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();
	    logger.debug("Start : "+start);
	 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    logger.debug(joinPoint.getSignature() + " executed in " + executionTime + "ms");

	    return proceed;
	}

}
