package com.xieze.springcloud.entity;

import com.xieze.springcloud.consts.ErrorCode;
import com.xieze.springcloud.consts.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * 通用返回对象，所有http接口都必须返回此对象
 *
 * @author Tortoise
 * @since 2019-04-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Response<T> implements Serializable {

    public static final Integer SUCCESS_CODE = 200;
    private static final long serialVersionUID = 1L;
    /**
     * 响应代码
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * md5值
     */
    private String md5;

    /**
     * 成功
     *
     * @param <T> 返回数据类型
     * @return DataResponse
     */
    public static <T> Response<T> success() {
        return new Response<>(SUCCESS_CODE, "操作成功", null,null);
    }

    /**
     * 成功
     *
     * @param <T> 返回数据类型
     * @return DataResponse
     */
    public static <T> Response<T> success(int status, String msg) {
        return new Response<>(status, msg, null,null);
    }

    /**
     * 成功
     *
     * @param <T> 返回数据类型
     * @return DataResponse
     */
    public static <T> Response<T> success(int status, String msg, T t) {
        return new Response<>(status, msg, t,null);
    }


    /**
     * 成功
     *
     * @param data 消息
     * @param <T>  返回数据类型
     * @return DataResponse
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(SUCCESS_CODE, "操作成功", data,null);
    }

    /**
     * 成功
     *
     * @param msg  消息
     * @param data 数据
     * @param <T>  返回数据类型
     * @return Response
     */
    public static <T> Response<T> success(String msg, T data) {
        return new Response<>(SUCCESS_CODE, msg, data,null);
    }

    /**
     * 失败
     *
     * @param errorCode ErrorCode
     * @return Response
     */
    public static <T> Response<T> failed(ErrorCode errorCode) {
        return new Response<>(errorCode.getValue(), errorCode.getDesc(), null,null);
    }

    /**
     * 失败
     *
     * @param errorInfo 错误信息
     * @return Response
     */
    public static <T> Response<T> failed(ErrorInfo errorInfo) {
        return new Response<>(errorInfo.getCode(), errorInfo.getMsg(), null,null);
    }

    /**
     * 失败
     *
     * @param errorCode ErrorCode
     * @param <T>       返回数据类型
     * @return Response
     */
    public static <T> Response<T> failed(ErrorCode errorCode, T data) {
        return new Response<>(errorCode.getValue(), errorCode.getDesc(), data,null);
    }

    /**
     * 失败
     *
     * @param status 数据
     * @param msg  消息
     * @return Response
     */
    public static <T> Response<T> failed(int status, String msg) {
        return new Response<>(status, msg, null,null);
    }

    /**
     * 失败
     *
     * @param msg 消息
     * @return Response
     */
    public static <T> Response<T> failed(String msg) {
        return new Response<>(ErrorCode.SYSTEM_ERROR.getValue(), msg, null,null);
    }

    /**
     * 失败
     *
     * @param status 数据
     * @param msg  消息
     * @param <T>  返回数据类型
     * @return Response
     */
    public static <T> Response<T> failed(int status, String msg, T data) {
        return new Response<>(status, msg, data,null);
    }

    /**
     * 创建返回对象
     *
     * @param status 代码
     * @param msg  消息
     * @param data 数据
     * @param <T>  数据类型
     * @return Response
     */
    public static <T> Response<T> response(int status, String msg, T data) {
        return new Response<>(status, msg, data,null);
    }

    /**
     * 判断响应结果是否成功
     *
     * @return 结果
     */
    public boolean isSuccess() {
        if (Objects.isNull(status)) {
            return false;
        }

        return Objects.equals(SUCCESS_CODE, status);
    }

}
