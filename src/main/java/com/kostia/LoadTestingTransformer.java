package com.kostia;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LoadTestingTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        try {
            int invocationCount = Integer.parseInt(System.getProperty("invocationCount", "1"));
            if (invocationCount > 1) {
                iTestAnnotation.setInvocationCount(invocationCount);
            }
        } catch (Exception e) {
            // ignore
        }
    }
}