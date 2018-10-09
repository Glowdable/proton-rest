/**
 * @author glowd
 * @date 2018/04/09
 */
package cn.glowd.proton.rest.api.reponse;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 0为成功，非0为失败。可以自定义code，代表不同的错误码 */
    private Integer code;
    /** 当code为非0时，获取错误信息。当code为0时，msg一般为”success”。如果有需要也可以另外作规定 */
    private String msg;
    /** 当code为0时，获取结果，全部以json方式表示。当code为非0时，data没有数据 */
    private T data;

    public ResponseResult() {

    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /***
     * 请求成功，code=0，msg="success"
     * 
     * @return
     */
    public ResponseResult<T> ok() {
        this.code = 0;
        this.msg = "success";
        return this;
    }

    /**
     * 请求失败，code不能为0，错误信息msg
     * 
     * @return
     */
    public ResponseResult<T> fail(Integer code, String msg) {
        if (code != 0) {
            this.code = code;
        }
        this.msg = msg;
        return this;
    }

    /**
     * 当code为非0时，获取错误信息。当code为0时，msg一般为”success”。如果有需要也可以另外作规定</br>
     * <p>
     * 自定义时需要设置此值，一般不要使用
     * 
     * @return
     */
    public ResponseResult<T> msg() {
        this.code = 0;
        this.msg = "success";
        return this;
    }

    /**
     * 当code为0时，获取结果，全部以json方式表示。当code为非0时，data没有数据
     * 
     * @param data
     * @return
     */
    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}