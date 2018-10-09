package cn.glowd.proton.rest.api.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcContext;

import cn.glowd.proton.core.model.SampleModel;
import cn.glowd.proton.core.service.impl.SampleServiceImpl;
import cn.glowd.proton.dal.mapper.HealthPackageDOMapper;
import cn.glowd.proton.dal.mapper.manual.ExtHealthPackageDOMapper;
import cn.glowd.proton.dal.model.HealthPackageDO;
import cn.glowd.proton.rest.api.HealthPackageRestApi;
import cn.glowd.proton.rest.api.reponse.ResponseResult;
import cn.glowd.proton.rest.api.vo.reponse.HealthPackageResponseVO;
import cn.glowd.proton.rest.api.vo.request.HealthPackageRequestVO;

/**
 * HealthPackageRestApiImpl
 * 
 * @see http://docs.jboss.org/resteasy/docs/3.1.4.Final/userguide/html_single/index.html<br>
 * @see https://dangdangdotcom.github.io/dubbox/rest.html
 * 
 * @see http api设计规范 https://lexiangla.com/docs/27c78dba373e11e8892b5254004fae61
 * 
 *      1. 解释 <br>
 *      Consumes({MediaType.APPLICATION_JSON})：指定HealthPackageRestApiImpl接收JSON格式的数据。REST框架会自动将JSON数据反序列化为HealthPackageVO对象<br>
 *      produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回 <br>
 *      2. 我们返回一般统一使用json格式返回，，每个实现类上面加上@Produces(MediaType.APPLICATION_JSON)，使用jackson来序列化对象的<br>
 *      3. 如果要使用xml格式返回，需要在对应的实现类上面加@Produces(MediaType.APPLICATION_XML)，而且需要在需要返回的对象上面声明xml annotation，使用JAXB序列化<br>
 *      参考 http://www.mkyong.com/webservices/jax-rs/download-xml-file-from-jax-rs-with-jaxb-resteasy/<br>
 *      4. rest接口实现必须加上Rest，例如XXXXXRestApi，XXXXXRestApiImpl<br>
 *      5. 测试用例：运行起来之后，直接点击「开始测试」按钮<br>
 * 
 * 
 * @author glowd
 *
 */
@Produces({MediaType.APPLICATION_JSON})
@Path("v1/health_package")
public class HealthPackageRestApiImpl implements HealthPackageRestApi {

    // private static final Logger LOGGER = LoggerFactory.getLogger(HealthPackageRestApiImpl.class);
    @Autowired
    private HealthPackageDOMapper healthPackageMapper;
    @Autowired
    private ExtHealthPackageDOMapper extHealthPackageMapper;
    @Autowired
    private SampleServiceImpl sampleServiceImpl;

    @GET
    @Path("say_hello")
    @Override
    public ResponseResult<String> sayHello(@QueryParam("name") String name) {

        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
            + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        String result = "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
        return new ResponseResult<String>().ok().data(result);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("sample")
    @Override
    public ResponseResult<String> doSample(HealthPackageRequestVO healthPackageRequestVO) {
        sampleServiceImpl.sayHello();
        SampleModel sampleModel = sampleServiceImpl.parseSample(healthPackageRequestVO);
        return new ResponseResult<String>().ok().data(sampleModel.toString());
    }

    /**
     * 当系统抛出异常时，可以不打日志，com.alibaba.dubbo.rpc.filter.ExceptionFilter,会拦截所有的异常，并且打ERROR级别的日志
     */
    @GET
    @Path("error")
    @Override
    public ResponseResult<String> testError() {

        int i = 1 / 0;
        return new ResponseResult<String>().ok().data("Cannot be reached " + i);
    }

    /***
     * Consumes REST框架会自动将json数据反序列化为HealthPackageVO对象，作为参数 <br>
     * Produces REST框架会自动将HealthPackageVO序列化为json，作为返回值
     * 
     * @param healthPackageVO
     * @return HealthPackageVO
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("add")
    @Override
    public ResponseResult<HealthPackageResponseVO> add(HealthPackageRequestVO healthPackageVO) {

        HealthPackageDO po = new HealthPackageDO();
        BeanUtils.copyProperties(healthPackageVO, po);
        healthPackageMapper.insert(po);
        return getById(po.getId());
    }

    @GET
    @Path("insert")
    @Override
    public ResponseResult<HealthPackageResponseVO> insert(@QueryParam("package_id") int packageId,
        @QueryParam("module_id") int moduleId) {

        HealthPackageDO po = new HealthPackageDO();
        po.setPackageId(packageId);
        po.setModuleId(moduleId);
        healthPackageMapper.insert(po);
        return getById(po.getId());
    }

    @GET
    @Path("update_by_id")
    @Override
    public ResponseResult<HealthPackageResponseVO> updateById(@QueryParam("id") long id,
        @QueryParam("package_id") int packageId, @QueryParam("module_id") int moduleId) {

        HealthPackageDO po = new HealthPackageDO();
        po.setId(id);
        po.setPackageId(packageId);
        po.setModuleId(moduleId);
        healthPackageMapper.updateByPrimaryKey(po);
        return getById(po.getId());
    }

    @GET
    @Path("get_by_id")
    @Override
    public ResponseResult<HealthPackageResponseVO> getById(@QueryParam("id") long id) {

        HealthPackageDO healthPackageFrom = healthPackageMapper.selectByPrimaryKey(id);
        HealthPackageResponseVO healthPackageTo = new HealthPackageResponseVO();
        BeanUtils.copyProperties(healthPackageFrom, healthPackageTo);
        return new ResponseResult<HealthPackageResponseVO>().ok().data(healthPackageTo);

    }

    @GET
    @Path("list_by_module_id")
    @Override
    public ResponseResult<List<HealthPackageResponseVO>> listByModuleId(@QueryParam("module_id") int moduleId) {

        List<HealthPackageDO> healthPackageDOList = extHealthPackageMapper.extSelectByModuleId(moduleId);
        List<HealthPackageResponseVO> healthPackageVOList = new ArrayList<>();
        healthPackageDOList.forEach(healthPackageFrom -> {
            HealthPackageResponseVO healthPackageTo = new HealthPackageResponseVO();
            BeanUtils.copyProperties(healthPackageFrom, healthPackageTo);
            healthPackageVOList.add(healthPackageTo);
        });

        return new ResponseResult<List<HealthPackageResponseVO>>().ok().data(healthPackageVOList);
    }

}
