package com.lhf.ticket.model;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseModel extends HashMap<String, Object> {
	@JsonIgnore
	private static final long serialVersionUID = -7448529552329387780L;

	private static final String STATUS = "status";
	private static final String RESULT = "result";
	private static final String ERROR = "error";
	private static final String MSG = "msg";

	/**
	 * ResponseModel默认构造器不对外开放使用
	 */
	private ResponseModel() {

	}

	/**
	 * 向前端返回对象或数组，状态码为200
	 * 
	 * @param result
	 *            要返回的对象或数组
	 */
	public ResponseModel(Object result) {
		super();
		put(STATUS, 200);
		put(RESULT, result);
	}

	/**
	 * 向前端返回对象或数组，状态码为200
	 * 
	 * @param status
	 *            状态码
	 * @param result
	 *            要返回的对象或数组
	 */
	public ResponseModel(HttpStatus status, Object result) {
		super();
		put(STATUS, status.value());
		put(RESULT, result);
	}

	/**
	 * 返回分页查询内容
	 * 
	 * @param status
	 *            状态码
	 * @param page
	 *            分页内容
	 */
	

	/**
	 * 返回错误信息
	 * 
	 * @param status
	 *            错误状态码
	 * @param error
	 *            错误信息
	 */
	public ResponseModel(HttpStatus status, String error) {
		super();
		put(STATUS, status.value());
		put(ERROR, error);
	}

	/**
	 * ResponseModel构建器
	 * 
	 * @date 2017-06-08
	 * @author wangll
	 */
	public static class Builder {
		private HttpStatus status = HttpStatus.OK;
		private Object result;
		private String error;
		private String msg;
		

		public Builder result(Object result) {
			this.result = result;
			return this;
		}

		public Builder status(HttpStatus status) {
			this.status = status;
			return this;
		}

		public Builder error(String error) {
			this.error = error;
			return this;
		}

		public Builder msg(String msg) {
			this.msg = msg;
			return this;
		}

		

		public ResponseModel build() {

			ResponseModel responseModel = new ResponseModel();
			responseModel.put(STATUS, this.status.value());

			if (this.result != null) {
				responseModel.put(RESULT, this.result);
			}

			

			if (StringUtils.isNotEmpty(this.error)) {
				responseModel.put(ERROR, this.error);
			}

			if (StringUtils.isNotEmpty(this.msg)) {
				responseModel.put(MSG, this.msg);
			}

			return responseModel;
		}
	}
}
