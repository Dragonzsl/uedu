package xyz.myzsl.uedu.utils;

import java.io.Serializable;


public class ReturnResult implements Serializable{

    private int status;//成功为1，失败为-1
    private Object data;
    private String message="操作成功";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    /**
     * 返回成功状态
     * @param obj
     */
    public ReturnResult returnSuccess(Object obj){
        this.status=1;
        this.data=obj;
        return this;
    }
    /**
     * 返回默认成功状态
     */
    public ReturnResult returnSuccess(){
        this.status=1;
        return this;
    }
    /**
     * 返回失败状态
     * @param message
     */
    public ReturnResult returnFail(String message){
        this.status=-1;
        this.message=message;
        return this;
    }

    public ReturnResult(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ReturnResult(Object data) {
        this.status=1;
        this.data = data;
    }

    public ReturnResult(){

    }
}
