package com.calc.launcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launcher {
    public void launch() {
       // String[] contextPaths = new String[] {"main/java/todo/app-context.xml"};
//        String[] contextPaths = new String[] {"classpath*:app-context.xml"};
//        new ClassPathXmlApplicationContext(contextPaths);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:calc-context.xml");
        
       String[] c =  context.getBeanDefinitionNames();
        for (int i = 0; i < c.length; i++) {
            String string = c[i];
           // System.out.println(string);
        }
        
    }
}