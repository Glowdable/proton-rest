package cn.glowd.proton.common.enums;

import cn.glowd.proton.common.exception.ErrorCode;

/**
 * 
 * @author glowd
 * @date 2018/10/09
 */
public enum ErrorCodeEnum implements ErrorCode {

    SUCCESS(0, "success"), SYSTEM_ERROR(1, "系统繁忙，请稍后再试"), PARAM_ERROR(2, "请求参数错误");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
