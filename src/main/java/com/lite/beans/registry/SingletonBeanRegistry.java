package com.lite.beans.registry;

/**
 * @author hs
 */
public interface SingletonBeanRegistry {

    void registerSingle(String beanName, Object obj);

    Boolean containsSingleton(String beanName);

    Object getSingleton(String beanName);

    String[] getSingletonNames();

}
