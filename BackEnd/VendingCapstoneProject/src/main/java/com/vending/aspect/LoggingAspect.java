package com.vending.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Logger log = Logger.getLogger(this.getClass());
    /**
     * Point cut that matches all repositories, services and Web REST end points.
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Point cut, the implementations are in the advice.
    }

    /**
     * Point cut that matches all Spring beans in the application's main packages.
     */
    @Pointcut("within(net.guides.springboot2.springboot2jpacrudexample..*)" +
            " || within(net.guides.springboot2.springboot2jpacrudexample.service..*)" +
            " || within(net.guides.springboot2.springboot2jpacrudexample.controller..*)")
        public void applicationPackagePointcut() {
            // Method is empty as this is just a Point cut, the implementations are in the advice.
        }

        /**
         * Advice that logs methods throwing exceptions.
         *
         * @param joinPoint join point for advice
         * @param e exception
         */
    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        //log.error("Exception in {0}.{1}() with cause = {2}", joinPoint.getSignature().getDeclaringTypeName(),
            //joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
        log.error("Exception in "+ joinPoint.getSignature().getDeclaringTypeName() +"."
            +joinPoint.getSignature().getName()+"() with cause = "+ (e.getCause() != null ? e.getCause() : "NULL"));
    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
        	log.debug("Enter: "+ joinPoint.getSignature().getDeclaringTypeName()+"."+
                    joinPoint.getSignature().getName()+"() with argument[s] = "+Arrays.toString(joinPoint.getArgs()));
//            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
//                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), result);
            	log.debug("Exit: "+ joinPoint.getSignature().getDeclaringTypeName()+"."+
                        joinPoint.getSignature().getName()+"() with result = "+ result);
            }
            return result;
        } catch (IllegalArgumentException e) {
//            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        	log.error("Illegal argument: "+ Arrays.toString(joinPoint.getArgs())+" in "+
                    joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"()");
            throw e;
        }
    }
}