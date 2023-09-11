package com.lychee.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lychee.enums.AppHttpCodeEnum;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public ResponseResult() {
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code,String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult errorResult(Integer code,String msg) {
        ResponseResult responseResult = new ResponseResult();
        return responseResult.error(code,msg);
    }

    public static ResponseResult okResult() {
        ResponseResult responseResult = new ResponseResult();
        return responseResult;
    }

    public static ResponseResult okResult(int code,String msg){
        ResponseResult responseResult = new ResponseResult();
        return responseResult.ok(code,null,msg);
    }

    public static ResponseResult okResult(Object data){
        ResponseResult responseResult = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS,AppHttpCodeEnum.SUCCESS.getMsg());
        if (data != null) {
            responseResult.setData(data);
        }
        return responseResult;
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getMsg());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums,String msg){
        return setAppHttpCodeEnum(enums,msg);
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums,String msg){
        return okResult(enums.getCode(),msg);
    }

    public ResponseResult<?> error(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code,T data){
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code,T data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(T data){
        this.data = data;
        return this;
    }

    public Integer getCoded() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
