package indi.kenneth.entity;

/**
 * @author kenneth
 * @Date: 2023/3/12
 */
public class Result<T> {

	private int code;
	private String message;
	private T data;

	public Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}


	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<>(200,"success",data);
		return result;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
