package com.lite.test;

import com.lite.beans.BeansException;
import com.lite.context.ClassPathXmlApplicationContext;
import com.lite.context.XmlApplicationContext;
import com.lite.test.beans.LoginService;

/**
 * @author hs
 */
public class DemoTest {

    public static void main(String[] args) throws BeansException {
        // XmlApplicationContext xmlApplicationContext = new XmlApplicationContext("bean.xml");
        //
        // LoginService loginService = (LoginService) xmlApplicationContext.getBean("loginService");
        // loginService.write();


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        LoginService loginService2 = (LoginService) classPathXmlApplicationContext.getBean("loginService");
        loginService2.write();
    }

}
