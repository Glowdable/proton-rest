package cn.glowd.proton.rest.api.impl;

/**
 * HealthPackageRestApiImpl
 * 
 * @see http://docs.jboss.org/resteasy/docs/3.1.4.Final/userguide/html_single/index.html<br>
 * @see https://dangdangdotcom.github.io/dubbox/rest.html
 * 
 *      1. api 接口必须加版本号，初始版本 【v1】<br>
 *      2. 不使用rest的PUT和DELETE，因为很多浏览器不支持，很多框架也不支持 <br>
 *      3. POST在需要传输大量数据的时候使用，其余使用GET就可以了 <br>
 *      4. Path设计尽量使用restful格式，路径必须能够清晰的表明意图，例如 <br>
 *      /v1/health_package/update/{id}: 接口版本为v1，操作health_package数据表，对这个表进行更新操作，更新的id为{id} <br>
 *      /v1/health_package/list/{module_id}:接口版本为v1，操作health_package数据表，对这个表进行查询操作并且是多个实体，查询的module_id为{module_id}的所有数据<br>
 *      5. 不要大写，所有参数全部小写，以下划线分隔 <br>
 *      6. 解释 <br>
 *      Consumes({MediaType.APPLICATION_JSON})：指定HealthPackageRestApiImpl接收JSON格式的数据。REST框架会自动将JSON数据反序列化为HealthPackageVO对象<br>
 *      produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回 <br>
 *      7. 我们返回一般统一使用json格式返回，，每个实现类上面加上@Produces(MediaType.APPLICATION_JSON)，使用jackson来序列化对象的<br>
 *      8. 如果要使用xml格式返回，需要在对应的实现类上面加@Produces(MediaType.APPLICATION_XML)，而且需要在需要返回的对象上面声明xml annotation，使用JAXB序列化<br>
 *      参考 http://www.mkyong.com/webservices/jax-rs/download-xml-file-from-jax-rs-with-jaxb-resteasy/<br>
 *      9. rest接口实现必须加上Rest，例如XXXXXRestApi，XXXXXRestApiImpl<br>
 *      10. 测试：<br>
 *      http://127.0.0.1:20882/v1/health_package/select/1 <br>
 *      http://127.0.0.1:20882/v1/health_package/say_hello/glowd<br>
 *      http://127.0.0.1:20882/v1/health_package/update/1?package_id=8&module_id=9<br>
 *      http://127.0.0.1:20882/v1/health_package/list/1<br>
 *      http://127.0.0.1:20882/v1/health_package/insert?package_id=1&module_id=2<br>
 *      http://127.0.0.1:20882/v1/health_package/add (POST) (body:{"packageId":5,"moduleId":100})<br>
 * 
 * 
 * @author glowd
 *
 */
public interface XxxRestApiImpl {

}
