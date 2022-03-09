package com.luke.hot_list.utils;

import com.alibaba.fastjson.JSON;
import com.luke.hot_list.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luke_long
 * @version 1.0
 * @date 2022/2/24 9:41
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.luke.hot_list.annotation.Log)")
    public void operationLog(){}

    /**
     * 处理完请求后执行此处代码
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "operationLog()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult)
    {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 如果处理请求时出现异常，在抛出异常后执行此处代码
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "operationLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e, null);
    }

    /**
     * 日志处理
     */
    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult)
    {
        try
        {
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            Log controllerLog = null;
            if (method != null) {
                controllerLog = method.getAnnotation(Log.class);
            }
            Map<String, String> log = new HashMap<>(7);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = null;
            if (attributes != null) {
                request = attributes.getRequest();
            }
            String requestTitle = null;
            if (controllerLog != null) {
                requestTitle = controllerLog.title();
            }
            String requestResult = JSON.toJSONString(jsonResult);
            String requestArgs = JSON.toJSONString(joinPoint.getArgs());
            String requestUrl = null;
            if (request != null) {
                requestUrl = request.getRequestURL().toString();
            }
            String requestMethod = null;
            if (request != null) {
                requestMethod = request.getMethod();
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();

            log.put("requestTitle", requestTitle);
            log.put("requestResult", requestResult);
            log.put("requestArgs", requestArgs);
            log.put("requestUrl", requestUrl);
            log.put("requestMethod", requestMethod);
            log.put("className", className);
            log.put("methodName", methodName);

            String logJson = JSON.toJSONString(log);
            System.out.println(logJson);

        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
}