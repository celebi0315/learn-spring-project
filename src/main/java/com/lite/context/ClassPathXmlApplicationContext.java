package com.lite.context;

import com.lite.beans.BeansException;
import com.lite.beans.beanFactory.BeanFactory;
import com.lite.beans.beanFactory.SimpleBeanFactory;
import com.lite.beans.xml.ClassPathXmlReader;
import com.lite.beans.xml.ClassPathXmlResource;
import com.lite.model.BeanDefinition;

/**
 * xml, 做如下三件事
 * 1. 解析 XML 文件中的内容。
 * 2. 加载解析的内容，构建 BeanDefinition。
 * 3. 读取 BeanDefinition 的配置信息，实例化 Bean，然后把它注入到 BeanFactory 容器中。
 *
 * @author hs
 */
public class ClassPathXmlApplicationContext implements BeanFactory {


    BeanFactory beanFactory;


    public ClassPathXmlApplicationContext(String beanName) {
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();

        ClassPathXmlResource resource = new ClassPathXmlResource(beanName);
        ClassPathXmlReader reader = new ClassPathXmlReader(simpleBeanFactory);
        reader.loadBeanDefinitions(resource);

        this.beanFactory = simpleBeanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    @Deprecated
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

    @Override
    public void registerBean(String beanName, Object obj) {

    }

    @Override
    public Boolean containsBean(String beanName) {
        return null;
    }
}
