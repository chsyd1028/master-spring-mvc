package com.csyd.masterspringmvc.po;

/**
 * Created by ChengShanyunduo
 * 2018/1/29
 */
public class Movie {
    private String reason;

    private Result result;

    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
