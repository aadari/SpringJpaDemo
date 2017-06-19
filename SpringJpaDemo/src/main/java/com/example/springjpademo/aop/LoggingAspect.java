package com.example.springjpademo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect 
{
	@Before("execution(* com.example.springjpademo.services.EmployeeService.findByLastName(..))")
    public void logBeforeV1(JoinPoint joinPoint) 
    {
        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }
     
//    @Before("execution(* EmployeeManager.*(..))")
//    public void logBeforeV2(JoinPoint joinPoint) 
//    {
//        System.out.println("EmployeeCRUDAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
//    }
//     
//    @After("execution(* EmployeeManager.*(..))")
//    public void logAfterV2(JoinPoint joinPoint) 
//    {
//        System.out.println("EmployeeCRUDAspect.logAfterV2() : " + joinPoint.getSignature().getName());
//    }

}
