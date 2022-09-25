package com.ecart.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	
	
	private String responseCode;
	private Object data;
	private String resposneDesc;
	
	private List<Errors> errors;
	
	public void setResposneDesc(String resposneDesc) {
		this.resposneDesc = resposneDesc;
	}
	
	public String getResposneDesc() {
		return resposneDesc;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public List<Errors> getErrors() {
		return errors;
	}
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
	
	

}
