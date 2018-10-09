package cn.glowd.proton.test.base;

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
public class SampleTest {
    public static void main(String[] args) {

    }
}
