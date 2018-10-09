package cn.glowd.proton.common.exception;

/**
 * 
 * @author glowd
 * @date 2018/10/09
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 165367809284687797L;

    private int code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * RPC业务异常
     * 
     * @param code 错误码
     * @param message 错误描述
     */
    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * RPC业务异常
     * 
     * @param code 错误码
     * @param message 错误描述
     * @param args 格式化参数
     */
    public BusinessException(int code, String message, Object... args) {
        this.code = code;
        this.message = String.format(message, args);
    }

    /**
     * 
     * @param code 错误码
     * @param message 错误描述
     * @param args 格式化参数
     */
    public BusinessException(ErrorCode errorCode, Object... args) {
        if (errorCode != null) {
            this.code = errorCode.getCode();
            this.message = String.format(errorCode.getMessage(), args);
        }
    }

    /**
     * 
     * @param errorCode
     */
    public BusinessException(ErrorCode errorCode) {
        if (errorCode != null) {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
        }
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
