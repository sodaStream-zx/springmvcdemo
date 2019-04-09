package com.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * @author 一杯咖啡
 */
public class LogWritor {
    private static final Logger log = Logger.getLogger(LogWritor.class);
    int i = 0;

    public void logBefore(JoinPoint jp) {
        /*System.out.println("前置通知开始。。。。。");
        System.out.println("---------------------------");
        System.out.println("jp.getThis : "+jp.getThis().toString());
        System.out.println("jp.getstaticpart :  "+jp.getStaticPart());
        System.out.println("mehtod : "+jp.getSignature());
        System.out.println("jp.gettarget : "+jp.getTarget().toString());
        System.out.println("jp.getKind : "+jp.getKind());
        System.out.println("jp.getSourceLocation() : "+jp.getSourceLocation());
        System.out.println("jp.args[] : "+jp.getArgs());
        System.out.println("jp.longString : "+jp.toLongString());
        System.out.println("jp.toShortString : "+jp.toShortString());
        System.out.println("---------------------------");*/
        log.info(jp.getSignature() + "方法调用开始");
        i++;
        log.info("调用该方法次数： " + i);
    }
}
