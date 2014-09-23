package com.gaogao.common.base;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 计时切面
 * 
 * @author gaohaiming 2013-7-27
 * 
 */
public class TimeUseAspect {
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	ThreadLocal<Long> tiemUse = new ThreadLocal<Long>();

	// 前置通知
	public synchronized void beforeAdvice(JoinPoint jp) {
		startTime.set(System.currentTimeMillis());
		System.out.println("===========开始" + jp.getTarget());
	}

	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		startTime.set(System.currentTimeMillis());
		Object retVal = pjp.proceed();
		tiemUse.set(System.currentTimeMillis() - startTime.get());
		if (tiemUse.get() > 0) {
			System.out.println((pjp.getTarget().toString().split("@")[0]
					.toString() + "耗时(ms):" + tiemUse.get()));
		}
		return retVal;
	}

	public synchronized void afterAdvice(JoinPoint jp) {
		System.out.println("======耗时"
				+ (System.currentTimeMillis() - startTime.get()) + "=====结束"
				+ jp.getTarget());
	}

	// 后置最终通知
	public synchronized void afterFinallyAdvice() {
		System.out.println(this.toString() + "===========after finally advice");
	}
	
	public Object doThrowing(JoinPoint jp, Throwable ex) {
	    System.out.println("method " + jp.getTarget().getClass().getName()  
                + "." + jp.getSignature().getName() + " throw exception");  
        System.out.println(ex.getMessage()); 
        return "aaa";
	}
}
