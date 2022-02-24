package com.luke.hot_list.utils;

import com.alibaba.fastjson.JSON;
import com.luke.hot_list.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult)
    {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    /**
     * 如果处理请求时出现异常，在抛出异常后执行此处代码
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e)
    {
        handleLog(joinPoint, controllerLog, e, null);
    }

    /**
     * 日志处理
     */
    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult)
    {
        try
        {
            Map<String, String> log = new HashMap<>(7);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String requestTitle = controllerLog.title();
            String requestResult = JSON.toJSONString(jsonResult);
            String requestArgs = JSON.toJSONString(joinPoint.getArgs());
            String requestUrl = request.getRequestURL().toString();
            String requestMethod = request.getMethod();
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