package com.example.cruddemo.entity;

import com.example.cruddemo.common.CommonConstant;

/**
 * 公众返回结果实体类(json的格式)
 *
 * @author cc
 */
public class ResultData {

    private String msg; // 返回信息
    private Integer status; // 状态
    private Object data;


    public ResultData(String msg, Integer status, Object data) {
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

    public ResultData(String msg, Integer status, Object data, Integer count) {
        this.msg = msg;
        this.data = data;
        this.status = status;
    }




    /**
     * 访问成功
     *
     * @param data
     * @return
     */
    public static ResultData ResultDataSuccess(Object data) {
        return new ResultData("访问数据接口成功", CommonConstant.success_status, data);
    }

    /**
     * 自定义访问成功
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResultData ResultDataSuccessSelf(String msg, Object data) {
        return new ResultData(msg, CommonConstant.success_status, data);
    }

    /**
     * 访问失败自定义
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResultData ResultDataFaultSelf(String msg, Object data) {
        return new ResultData(msg, CommonConstant.fault_status, data);
    }

    /**
     * 访问失败固定
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResultData ResultDataFaultGd(String msg, Object data) {
        return new ResultData("访问数据失败，失败信息为" + msg, CommonConstant.fault_status, data);
    }


    ;


    ;

    public String getMsg() {
        return msg;
    }

    ;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
