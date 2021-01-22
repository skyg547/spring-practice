package com.bit2020.mysite;

public class JsonResult {

	private String result; // sucess 아니면  fail
	private Object data; // if sucess 성공하면 데이터 세팅
	private String message; // if fail set message
	
	
	
	private JsonResult () {
		
		
	}
	
	public static JsonResult sucess(Object data) {
		JsonResult jsonResult = new JsonResult();
		
		jsonResult.result = "success";
		jsonResult.data = data;
		
		return jsonResult;
		
	}
	
	public static JsonResult fail(String fail) {
		JsonResult jsonResult = new JsonResult();
		
		jsonResult.result = "fail";
		jsonResult.message = fail;
		
		return jsonResult;
		
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
