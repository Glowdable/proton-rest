package cn.glowd.proton.rest.api.impl;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HealthPackageRestApiImplTest {

    public static void main(String[] args) throws IOException {

        // 直接在proton-common中加载proton.propertie或者setSampleConfig();

        // classpath*: 可以加载多个配置文件,如果有多个配置文件
        ClassPathXmlApplicationContext context
            = new ClassPathXmlApplicationContext(new String[] {"classpath*:META-INF/spring/*.xml"});
        context.start();

        String[] str = context.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("..." + string);
        }

        System.in.read(); // press any key to exit
        context.close();
    }

    @SuppressWarnings("unused")
    private static void setSampleConfig() {
        System.setProperty("app.name", "proton-provider");
        System.setProperty("app.owner", "glowd");
        System.setProperty("app.registry.address", "zookeeper://127.0.0.1:2181");
        System.setProperty("app.protocol.dubbo.name", "dubbo");
        System.setProperty("app.protocol.dubbo.port", "20880");
        System.setProperty("master.jdbc.driver", "com.mysql.jdbc.Driver");
        System.setProperty("master.jdbc.url",
            "jdbc:mysql://dbserver:3306/dw?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true");
        System.setProperty("master.jdbc.username", "root");
        System.setProperty("master.jdbc.password", "");
    }

}