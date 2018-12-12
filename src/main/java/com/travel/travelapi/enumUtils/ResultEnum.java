package com.travel.travelapi.enumUtils;

public enum ResultEnum {
    SUCCESS_CODE(1000,"成功"),
    ERROR_CODE(1001,"失败");

    private String msg;
    private int code;

    private ResultEnum(int code,String msg)
    {
        this.code=code;
        this.msg=msg;
    }

    public String getMsg()
    {
        return this.msg;
    }
    public int getCode() {
        return this.code;
    }

}
