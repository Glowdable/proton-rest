package cn.glowd.proton.common.exception;

/**
 * 
 * @author glowd
 * @date 2018/10/09
 */
public interface ErrorCode {

    /**
     * err code
     * 
     * @return
     */
    int getCode();

    /**
     * err msg
     * 
     * @return
     */
    String getMessage();

}
