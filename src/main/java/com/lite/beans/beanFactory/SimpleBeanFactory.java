package com.lite.beans.beanFactory;

import com.lite.beans.BeansException;
import com.lite.beans.registry.DefaultSingletonBeanRegistry;
import com.lite.model.BeanDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hs
 */
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{

    private final List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private final List<String> beanNames = new ArrayList();
    private final Map<String, Object> singletons = new ConcurrentHashMap<>();


    @Override
    public Object getBean(String beanName) throws BeansException {

        Object singleton = singletons.get(beanName);
        if (singleton == null) {
            int i = beanNames.indexOf(beanName);
            if (i == -1) {
                throw new BeansException("beanName indexOf is -1");
            }

            BeanDefinition beanDefinition = beanDefinitions.get(i);
            try {
                singleton = Class.forName(beanDefinition.getClassName()).getConstructor().newInstance();

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                     ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //注册bean
            singletons.put(beanDefinition.getId(), singleton);

        }


        return singleton;
    }

    @Override
    @Deprecated
    public void registerBeanDefinition(BeanDefinition beanDefinition) {

            beanDefinitions.add(beanDefinition);
            beanNames.add(beanDefinition.getId());
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        registerSingle(beanName,obj);
    }

    @Override
    public Boolean containsBean(String beanName) {
        return containsSingleton(beanName);
    }
}
