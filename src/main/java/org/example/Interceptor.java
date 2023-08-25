package org.example;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

@Slf4j
public class Interceptor {
    @RuntimeType
    public Object intercept(
            @This Object obj,
            @Origin Method method,
            @AllArguments Object[] args,
            @SuperCall Callable<?> zuper
    ) {
        log.info("enter interceptor, obj.id={},args={}", obj, args);
        long start = System.currentTimeMillis();
        Object rst = null;
        try {
            rst = zuper.call();
        } catch (Exception e) {
            log.error("error", e);
        } finally {
            long end = System.currentTimeMillis();
            log.info("exec in {} ms", end - start);
        }
        return rst;
    }
}
