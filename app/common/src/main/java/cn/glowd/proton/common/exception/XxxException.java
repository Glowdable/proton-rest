package cn.glowd.proton.common.exception;

/**
 * 
 * @author glowd
 *
 */
public class XxxException extends RuntimeException {

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** 错误码 */
	private final int errorCode;

	/** 错误详细描述 */
	private String detailMessage;

	/**
	 * 含错误信息的构造函数,使用时需要特别注意此方法构造出来的异常结果码为默认的系统异常结果码
	 *
	 * @param errorMsg
	 */
	public XxxException(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

}
