package com.test.sibo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private int code;


    private String message;

   
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> Result.ResultBuiler<T> builder(){
        return new Result.ResultBuiler<T>();
    }

    public static class ResultBuiler<T>{
        private int code;
        private String message;
        private T data;

        public Result.ResultBuiler<T> code(int code){
            this.code = code;
            return this;
        }

        public Result.ResultBuiler<T> message(String message){
            this.message = message;
            return this;
        }

        public Result.ResultBuiler<T> data(T data){
            this.data = data;
            return this;
        }

        public Result<T> build(){
            return new Result<T>(this.code,this.message,this.data);
        }
    }
}
