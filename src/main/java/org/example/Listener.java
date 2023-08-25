package org.example;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.utility.JavaModule;

@Slf4j
public class Listener implements AgentBuilder.Listener {
    /**
     * 某个类将被加载时回调
     *
     * @param typeName    The binary name of the instrumented type.
     * @param classLoader The class loader which is loading this type or {@code null} if loaded by the boots loader.
     * @param module      The instrumented type's module or {@code null} if the current VM does not support modules.
     * @param loaded      {@code true} if the type is already loaded.
     */
    @Override
    public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
        log.info("onDiscovery typeName:{}", typeName);
    }

    /**
     * 某个类完成transform后回调
     *
     * @param typeDescription The type that is being transformed.
     * @param classLoader     The class loader which is loading this type or {@code null} if loaded by the boots loader.
     * @param module          The transformed type's module or {@code null} if the current VM does not support modules.
     * @param loaded          {@code true} if the type is already loaded.
     * @param dynamicType     The dynamic type that was created.
     */
    @Override
    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module,
                                 boolean loaded, DynamicType dynamicType) {
        log.info("onTransformation typeName:{}", typeDescription.getActualName());
    }

    /**
     * 某个类被加载但被ignore了回调
     *
     * @param typeDescription The type being ignored for transformation.
     * @param classLoader     The class loader which is loading this type or {@code null} if loaded by the boots loader.
     * @param module          The ignored type's module or {@code null} if the current VM does not support modules.
     * @param loaded          {@code true} if the type is already loaded.
     */
    @Override
    public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {
        log.info("onIgnored typeName:{}", typeDescription.getActualName());
    }

    /**
     * transform过程中发生异常回调
     *
     * @param typeName    The binary name of the instrumented type.
     * @param classLoader The class loader which is loading this type or {@code null} if loaded by the boots loader.
     * @param module      The instrumented type's module or {@code null} if the current VM does not support modules.
     * @param loaded      {@code true} if the type is already loaded.
     * @param throwable   The occurred error.
     */
    @Override
    public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {
        log.info("onError typeName:{}", typeName);
    }

    /**
     * 某个类被处理完后调用
     *
     * @param typeName    The binary name of the instrumented type.
     * @param classLoader The class loader which is loading this type or {@code null} if loaded by the boots loader.
     * @param module      The instrumented type's module or {@code null} if the current VM does not support modules.
     * @param loaded      {@code true} if the type is already loaded.
     */
    @Override
    public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
        log.info("onComplete typeName:{}", typeName);
    }
}
