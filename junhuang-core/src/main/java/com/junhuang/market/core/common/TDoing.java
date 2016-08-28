package com.junhuang.market.core.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by oyhk on 16/2/18.
 *
 * 有事物回滚的 doing
 */
public interface TDoing<T> extends BaseDoing<T> {

    default JsonResult<T> go(Logger log) {
        return this.go(null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, Logger log) {
        return this.go(null, r, null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, ObjectMapper objectMapper, Logger log) {
        return this.go(null, r, objectMapper, log);
    }

    default JsonResult<T> go(Object body, HttpServletRequest r, ObjectMapper objectMapper, Logger log) {
        JsonResult<T> jr = new JsonResult();
        try {
            this.showRequestBody(body, objectMapper, log);
            this.showParams(r, log);
            this.service(jr);
        }  catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            this.errorLog(log, e, jr);
        }finally {
            this.showReturnData(jr, objectMapper, log);
        }
        return jr;
    }


    void service(JsonResult<T> jr) throws Exception;

}
