package org.example;


import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

@Slf4j
public class AgentDemo {
    public static void premain(String args, Instrumentation instrumentation) {
        log.info("进入premain, args={}", args);
        new AgentBuilder.Default()
                // 忽略拦截的包
                .ignore(nameStartsWith("org.example.ignore"))
                // 配置需要拦截的类
                .type(isAnnotatedWith(named("org.springframework.web.bind.annotation.RestController")))
                // 定义在匹配的类上进行字节码转换的规则
                .transform(new AgentTransformer())
                // 配置监听器，收集代理过程中的信息、添加逻辑
                .with(new Listener())
                .installOn(instrumentation);
    }
}