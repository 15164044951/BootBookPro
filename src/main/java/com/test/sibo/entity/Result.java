package com.test.sibo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements Serializable {

    private int code;


    private String message;

   
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result() {
    }

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result.ResultBuiler builder(){
        return new Result.ResultBuiler();
    }

    public static class ResultBuiler{
        private int code;
        private String message;
        private Object data;

        public Result.ResultBuiler code(int code){
            this.code = code;
            return this;
        }

        public Result.ResultBuiler message(String message){
            this.message = message;
            return this;
        }

        public Result.ResultBuiler data(Object data){
            this.data = data;
            return this;
        }

        public Result build(){
            return new Result(this.code,this.message,this.data);
        }
    }
}
