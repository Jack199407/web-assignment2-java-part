package com.algonquin.webassignment2.demos.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 前后端交互返回结果
 *
 * @author qiupeng
 * @date 2020/12/15
 **/
@ToString
@NoArgsConstructor
public class RestResponse<T> implements Serializable {
    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    /**
     *
     */
    private static final long serialVersionUID = 605544666575940834L;
    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private T data;
    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private String source;

    private RestResponse(final int code, final T result, final String msg) {
        this.data = result;
        this.code = code;
        this.msg = msg;
    }


    public static <T> RestResponse<T> success(final T result, final String msg) {
        return new RestResponse<>(SUCCESS, result, msg);
    }



    public static <T> RestResponse<T> fail(final T result, final String msg) {
        return new RestResponse<>(FAIL, result, msg);
    }
}
