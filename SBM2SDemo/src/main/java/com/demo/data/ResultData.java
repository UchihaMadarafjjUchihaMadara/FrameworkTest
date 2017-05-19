package com.demo.data;

/**
 * @Description: 规范化接口数据的json封装类
 * 
 * @author DELL
 * 
 * @since 2017-04-26
 *
 */
public class ResultData {

	private int code;
    private String msg;
    private Object data;
    private long timestamp;


    public ResultData(int code, String msg, Object data, long timestamp){
        // TODO Auto-generated constructor stub
    	this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = timestamp;
    }


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
     
}
