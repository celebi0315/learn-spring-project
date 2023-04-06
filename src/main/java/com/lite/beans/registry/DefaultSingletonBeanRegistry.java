package com.lite.beans.registry;

import com.lite.beans.BeansException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * xml 默认单例bean管理
 *
 * @author hs
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    protected List<String> beanNames = new ArrayList<>();
    protected final Map<String, Object> singletons = new ConcurrentHashMap<>();


    @Override
    public void registerSingle(String beanName, Object obj) {
        synchronized (this.singletons) {
            singletons.put(beanName, obj);
            beanNames.add(beanName);
        }
    }

    @Override
    public Boolean containsSingleton(String beanName) {
        return singletons.containsKey(beanName);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletons.get(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return this.beanNames.toArray(new String[this.beanNames.size()]);
    }


    public void removeSingleton(String beanName) {

        synchronized (this.singletons) {
            singletons.remove(beanName);
            beanNames.remove(beanName);
        }
    }

}
