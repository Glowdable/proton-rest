package cn.glowd.proton.core.service;

import cn.glowd.proton.core.model.SampleModel;
import cn.glowd.proton.rest.api.vo.request.HealthPackageRequestVO;

/**
 * 
 * @author glowd
 * @date 2018/03/01
 */
public interface SampleService {
    /**
     * say Hello
     */
    public void sayHello();

    /**
     * 从请求VO，HealthPackageRequestVO中解析SampleModel
     * 
     * @param healthPackageVO
     * @return
     */
    public SampleModel parseSample(HealthPackageRequestVO healthPackageVO);

}
