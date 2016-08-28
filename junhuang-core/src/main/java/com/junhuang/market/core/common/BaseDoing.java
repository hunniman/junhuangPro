package com.junhuang.market.core.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by oyhk on 16/2/18.
 *
 */
public interface BaseDoing<T> {


    default void showRequestBody(Object body, ObjectMapper objectMapper, Logger log) throws JsonProcessingException {
        if (body != null && objectMapper != null) {
            log.info("request body => {}", objectMapper.writeValueAsString(body));
        }
    }

    /**
     * 请求参数记录
     * @param r
     * @param log
     */
    default void showParams(HttpServletRequest r, Logger log) {
        if (r != null) {
            Enumeration<String> parameterNames = r.getParameterNames();
            StringBuffer parameterStringBuffer = new StringBuffer("params => { ");
            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                parameterStringBuffer.append(parameterName).append(" : ").append(r.getParameter(parameterName)).append(" ,");
            }
            parameterStringBuffer.deleteCharAt(parameterStringBuffer.length() - 1);
            parameterStringBuffer.append(" }");
            log.info(parameterStringBuffer.toString());
        }
    }

    default void showReturnData(JsonResult jr, ObjectMapper objectMapper, Logger log) {
        if (objectMapper != null) {
            try {
                log.info("return data : {}", objectMapper.writeValueAsString(jr));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 错误日志输出
     * @param log
     * @param e
     * @param viewData
     */
    default void errorLog(Logger log, Exception e, ViewData viewData) {
        viewData.view = "/error";
        this.errorLog(log, e);
    }

    /**
     * 错误日志输出
     * @param log
     * @param e
     * @param jr
     */
    default void errorLog(Logger log, Exception e, JsonResult<T> jr) {
        jr.setCode(JsonResult.CD0[0]);
        jr.setDesc(JsonResult.CD1[1]);
        this.errorLog(log, e);
    }

    default void errorLog(Logger log, Exception e) {
        log.error(e.getMessage());
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElements[i];
            log.error(stackTraceElement.toString());
        }
        e.printStackTrace();
    }


}
