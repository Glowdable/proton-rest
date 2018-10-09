package cn.glowd.proton.rest.api.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.rpc.RpcContext;

import cn.glowd.proton.dal.mapper.HealthPackageDOMapper;
import cn.glowd.proton.dal.mapper.manual.ExtHealthPackageDOMapper;
import cn.glowd.proton.dal.model.HealthPackageDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:META-INF/spring/*.xml"})
public class HealthPackageRestApiTest {

    @Autowired
    HealthPackageDOMapper healthPackageMapper;
    @Autowired
    ExtHealthPackageDOMapper extHealthPackageMapper;

    @Test
    public void sayHello() {
        String name = "glowd";
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
            + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
    }

    @Test
    public void update() {
        long id = 1;
        int packageId = 1;
        int moduleId = 1;
        HealthPackageDO healthPackage = new HealthPackageDO();
        healthPackage.setId(id);
        healthPackage.setPackageId(packageId);
        healthPackage.setModuleId(moduleId);
        healthPackageMapper.updateByPrimaryKey(healthPackage);
        outPrint("update:" + healthPackageMapper.selectByPrimaryKey(id));
    }

    @Test
    public void insert() {
        int packageId = 1;
        int moduleId = 1;
        HealthPackageDO healthPackage = new HealthPackageDO();
        healthPackage.setPackageId(packageId);
        healthPackage.setModuleId(moduleId);
        healthPackageMapper.insert(healthPackage);
        outPrint("insert:" + healthPackageMapper.selectByPrimaryKey(healthPackage.getId()));
    }

    @Test
    public void selectById() {
        long id = 1;
        outPrint("selectById:" + healthPackageMapper.selectByPrimaryKey(id));
    }

    @Test
    public void selectByModuleId() {
        int moduleId = 1;
        outPrint("selectByModuleId:" + extHealthPackageMapper.extSelectByModuleId(moduleId));
    }

    public void outPrint(Object message) {
        System.out.println(message);
    }

}
