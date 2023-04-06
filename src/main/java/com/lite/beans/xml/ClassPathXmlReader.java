package com.lite.beans.xml;

import com.lite.beans.Resource;
import com.lite.beans.beanFactory.BeanFactory;
import com.lite.model.BeanDefinition;
import org.dom4j.Element;

/**
 * xml信息已读取完，转换成beanDefinition
 *
 * @author hs
 */
public class ClassPathXmlReader {

    private BeanFactory beanFactory;

    public ClassPathXmlReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanName = element.attributeValue("class");
            beanFactory.registerBeanDefinition(new BeanDefinition(beanId, beanName));
        }
    }
}
