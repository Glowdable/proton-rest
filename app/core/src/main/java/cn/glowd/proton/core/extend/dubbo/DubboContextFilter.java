package cn.glowd.proton.core.extend.dubbo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

/***
 * @author glowd
 * @date 2018/05/25
 */
public class DubboContextFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboContextFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        // 如果是以dubbo rest的方式调用，那么request为null
        log(invocation);
        return invoker.invoke(invocation);
    }

    /***
     * 通用日志打印，每一个请求都会打日志
     * 
     * @param invocation
     * @param headModel
     */
    private void log(Invocation invocation) {
        LOGGER.info("{},{},{}", invocation.getMethodName(), Arrays.toString(invocation.getArguments()),
            RpcContext.getContext().getRemoteAddress());
    }
}