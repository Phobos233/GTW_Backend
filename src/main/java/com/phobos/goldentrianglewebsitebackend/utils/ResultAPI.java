package com.phobos.goldentrianglewebsitebackend.utils;

import lombok.Data;

@Data
public class ResultAPI {
    private Integer code;
    private String message;
    private Object data;

    public static ResultAPI success() {
        ResultAPI resultAPI = new ResultAPI();
        resultAPI.setCode(1);
        resultAPI.setMessage("success");
        return resultAPI;
    }
    public static ResultAPI success(String message) {
        ResultAPI resultAPI = success();
        resultAPI.setMessage(message);
        return resultAPI;
    }
    public static ResultAPI success(Object data) {
        ResultAPI resultAPI = success();
        resultAPI.setData(data);
        return resultAPI;
    }
    public static ResultAPI success(Object data, String message) {
        ResultAPI resultAPI = success(data);
        resultAPI.setMessage(message);
        return resultAPI;
    }
    public static ResultAPI error() {
        ResultAPI resultAPI = new ResultAPI();
        resultAPI.setCode(0);
        resultAPI.setMessage("error");
        return resultAPI;
    }
    public static ResultAPI error(String message) {
        ResultAPI resultAPI = error();
        resultAPI.setMessage(message);
        return resultAPI;
    }
    public static ResultAPI error(Integer code, String message) {
        ResultAPI resultAPI = error();
        resultAPI.setCode(code);
        resultAPI.setMessage(message);
        return resultAPI;
    }

}
