package com.lite.context;

import cn.hutool.core.util.StrUtil;
import com.lite.model.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hs
 */
public class XmlApplicationContext {


    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String,Object> singletons = new HashMap<>();

    public XmlApplicationContext(String fileName) {
        readXml(fileName);
        instanceBeans();
    }


    public void readXml(String fileName) {

        SAXReader saxReader = new SAXReader();

        try {
            URL resource = this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(resource);
            Element rootElement = document.getRootElement();
            for (Element element : rootElement.elements()) {
                String id = element.attributeValue("id");
                String filename = element.attributeValue("class");
                beanDefinitions.add(new BeanDefinition(id, filename));
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }


    public void instanceBeans() {

        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletons.put(
                        beanDefinition.getId(),
                        Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance());

            } catch (InvocationTargetException | ClassNotFoundException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public Object getBean(String beanName) {

        if (StrUtil.isBlank(beanName)) {
            return null;
        }

        return singletons.get(beanName);
    }

}

























