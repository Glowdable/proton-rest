package cn.glowd.proton.core.extend.dubbo;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.protocol.rest.RestConstraintViolation;
import com.alibaba.dubbo.rpc.protocol.rest.ViolationReport;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import cn.glowd.proton.common.exception.BusinessException;
import cn.glowd.proton.rest.api.reponse.ResponseResult;

/**
 * 
 * 统一异常处理器，JAX-RS标准的ExceptionMapper，用来定制特定exception发生后应该返回的HTTP响应，以后会写到proton-core组件包中
 * 
 * @author glowd
 * @date 2018/03/22
 */
public class ExceptionMapperExtend implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionMapperExtend.class);

    protected Response handleConstraintViolationException(ConstraintViolationException cve) {
        ViolationReport report = new ViolationReport();
        for (ConstraintViolation<?> cv : cve.getConstraintViolations()) {
            report.addConstraintViolation(new RestConstraintViolation(cv.getPropertyPath().toString(), cv.getMessage(),
                cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString()));
        }

        ResponseResult<ViolationReport> reportResult = new ResponseResult<ViolationReport>().fail(1, report.toString());

        return Response.status(Response.Status.OK).entity(reportResult).type(ContentType.APPLICATION_JSON_UTF_8)
            .build();
    }

    @Override
    public Response toResponse(Exception e) {
        if (e.getCause() instanceof ConstraintViolationException) {
            return handleConstraintViolationException((ConstraintViolationException)e.getCause());
        }

        ResponseResult<ViolationReport> reportResult = new ResponseResult<ViolationReport>();

        /** 拦截 BusinessException */
        if (e instanceof BusinessException) {

            // 如果此异常在方法签名上已经声明了，就不会在ExceptionFilter中打日志，所以宁愿多打一个日志，也不少打
            LOGGER.error("BusinessException=>", e);
            BusinessException businessException = (BusinessException)e;
            reportResult.fail(businessException.getCode(), businessException.getMessage());
        } else {
            // 如果此异常不是运行时异常，，就不会在ExceptionFilter中打日志，所以宁愿多打一个日志，也不少打
            LOGGER.error("Internal server error=>", e);
            reportResult.fail(2, "Internal server error: " + e.getMessage());
        }

        return Response.status(Response.Status.OK).entity(reportResult).type(ContentType.APPLICATION_JSON_UTF_8)
            .build();
    }

}
