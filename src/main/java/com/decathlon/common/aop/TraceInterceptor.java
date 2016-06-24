package com.decathlon.common.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * TraceInterceptor is an AOP-based utility class to help us debug our applicaiton. This is a subclass of CustomizableTraceInterceptor.
 * Created by dengyuanqin on 16/3/29.
 */
public class TraceInterceptor extends CustomizableTraceInterceptor{
    protected static Logger logger = Logger.getLogger("aop");

    protected void writeToLog(Log logger, String message, Throwable ex){
        if (ex!=null){
            logger.debug(message,ex);
        }else {
            logger.debug(message);
        }
    }
    protected boolean isInterceptorEnabled(MethodInvocation invocation,Log logger){
        return true;
    }
}
