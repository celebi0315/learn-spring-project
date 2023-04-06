package com.lite.beans.beanFactory;

import com.lite.beans.BeansException;
import com.lite.model.BeanDefinition;

/**
 * @author hs
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    void registerBeanDefinition(BeanDefinition beanDefinition);

    void registerBean(String beanName, Object obj);

    Boolean containsBean(String beanName);
}
