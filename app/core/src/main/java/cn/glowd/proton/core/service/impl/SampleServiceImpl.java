package cn.glowd.proton.core.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.glowd.proton.core.model.SampleModel;
import cn.glowd.proton.core.service.SampleService;
import cn.glowd.proton.dal.mapper.HealthPackageDOMapper;
import cn.glowd.proton.rest.api.vo.request.HealthPackageRequestVO;

/**
 * 
 * @author glowd
 *
 */
public class SampleServiceImpl implements SampleService {

    @Autowired
    HealthPackageDOMapper healthPackageMapper;

    @Override
    public void sayHello() {
        System.out.println("SampleServiceImpl:sayHello");
    }

    @Override
    public SampleModel parseSample(HealthPackageRequestVO healthPackageVO) {
        HealthPackageRequestVO healthPackageFrom = healthPackageVO;
        SampleModel sampleModelTo = new SampleModel();
        BeanUtils.copyProperties(healthPackageFrom, sampleModelTo);
        return sampleModelTo;
    }

}
