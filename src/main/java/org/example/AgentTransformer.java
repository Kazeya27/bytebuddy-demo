package org.example;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.utility.JavaModule;

import static net.bytebuddy.matcher.ElementMatchers.*;

@Slf4j
public class AgentTransformer implements AgentBuilder.Transformer {
    private static final String GETMAPPING_PKG = "org.springframework.web.bind.annotation.GetMapping";

    /**
     * @param builder         The dynamic builder to transform.
     * @param typeDescription The description of the type currently being instrumented.被加载类的信息
     * @param classLoader     The class loader of the instrumented class. Might be {@code null} to represent the bootstrap class loader.
     * @param module          The class's module or {@code null} if the current VM does not support modules.
     * @return
     */
    @Override
    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder,
                                            TypeDescription typeDescription,
                                            ClassLoader classLoader,
                                            JavaModule module) {
        log.info("actual name={}", typeDescription.getActualName());

        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<?> interceptor =
                builder
                        // 拦截的方法
                        .method(isAnnotatedWith(named(GETMAPPING_PKG)).and(returns(Integer.class)))
                        // 选择拦截器
                        .intercept(MethodDelegation.to(new Interceptor()));
        return interceptor;
    }
}
