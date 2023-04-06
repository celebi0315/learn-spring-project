package com.lite.model;

/**
 * @author hs
 */
public class BeanDefinition {

    String id;

    String className;

    public BeanDefinition(String id) {
        this.id = id;
    }

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
