package com.lite.context;

import com.lite.beans.annotation.ComponentScan;

import java.net.URL;

/**
 * @author hs
 */
public class ApplicationContext {


    private Class<?> confClass;



    public ApplicationContext(Class<?> confClass) {

        this.confClass = confClass;


        //获取componentScan目录下有component注解的文件
        if (confClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan annotation = confClass.getAnnotation(ComponentScan.class);
            String classPath = annotation.value();


            ClassLoader classLoader = ApplicationContext.class.getClassLoader();
            URL url = classLoader.getResource(classPath);


        }



    }


    public static Object getBean(String beanName) {



        return null;
    }
}
