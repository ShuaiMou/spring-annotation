package com.saul.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  //告诉spring当前类是切面类
public class LogAspects {
	//抽取公共的切入点表达式
	//1，本类引用
	//2，其他的切面引用
	@Pointcut("execution(public int com.saul.aop.MathCaculator.*( . . ))")
	public void Pointcut(){};
	
	//@Before 在目标方法之前切入；切入点表达式（指定在哪个方法切入）
	//@Before(value = "public int com.saul.aop.MathCaculator.div(int, int)")
	//@Before(value = "public int com.saul.aop.MathCaculator.*( . . )")
	@Before("Pointcut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName() + "运行。。。参数列表是: {" + Arrays.asList(args)+ "}");
	}
	
	@After("Pointcut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println( joinPoint.getSignature().getName()+ "结束。。。");
	}
	
	//JoinPoint一定要出现在参数列表第一位
	@AfterReturning(value = "Pointcut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result){
		System.out.println(joinPoint.getSignature().getName() + "正常返回。。。运行结果: {" + result + "}");
	}
	
	@AfterThrowing(value = "Pointcut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception){
		System.out.println(joinPoint.getSignature().getName() +"异常。。。异常信息: {" + exception.getMessage() + "}");
	}
}
