package cn.glowd.proton.rest.api;

import java.util.List;

import cn.glowd.proton.rest.api.reponse.ResponseResult;
import cn.glowd.proton.rest.api.vo.reponse.HealthPackageResponseVO;
import cn.glowd.proton.rest.api.vo.request.HealthPackageRequestVO;

/**
 * HealthPackageApi，接口不抛出错误，全部返回200，错误信息使用
 * 
 * @author glowd
 *
 */
public interface HealthPackageRestApi {

    public ResponseResult<String> testError();

    /**
     * say Hello
     * 
     * @param name
     * @return
     */
    public ResponseResult<String> sayHello(String name);

    /**
     * sample例子,返回
     */
    public ResponseResult<String> doSample(HealthPackageRequestVO healthPackageRequestVO);

    /**
     * 更新记录
     * 
     * @param id
     * @param packageId
     * @param moduleId
     * @return
     */
    public ResponseResult<HealthPackageResponseVO> updateById(long id, int packageId, int moduleId);

    /**
     * 插入一个对象，和add同义，只是传入参数为字段
     * 
     * @param packageId
     * @param moduleId
     * @return 插入记录的id
     */
    public ResponseResult<HealthPackageResponseVO> insert(int packageId, int moduleId);

    /***
     * 插入一个对象，和insert同义，只是传入参数为对象
     * 
     * @param healthPackageVO
     * @return
     */
    public ResponseResult<HealthPackageResponseVO> add(HealthPackageRequestVO healthPackageVO);

    /**
     * get By Id
     * 
     * @param id
     * @return HealthPackageVO
     */
    public ResponseResult<HealthPackageResponseVO> getById(long id);

    /**
     * select By ModuleId
     * 
     * @param id
     * @return List<HealthPackageVO>
     */
    public ResponseResult<List<HealthPackageResponseVO>> listByModuleId(int id);

}
