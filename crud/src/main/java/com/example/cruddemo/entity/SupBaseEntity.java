package com.example.cruddemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel("供应商基础信息实体类")
public class SupBaseEntity<SupRole> {

        @ApiModelProperty("主键")
        private Integer apply_id;
        @ApiModelProperty("申请编号")
        private String apply_code;
        @ApiModelProperty("申请单位")
        private String sup_name;
        @ApiModelProperty("申请人")
        private String sup_person;
        @ApiModelProperty("申请的项目名称")
        private String apply_pro;
        @ApiModelProperty("供应商id")
        private String suppiler_id;
        @ApiModelProperty("创建者")
        private String creator;
//        @ApiModelProperty("创建时间 ")
//        private String create_time;
        @ApiModelProperty("更新者")
        private String updater;
//        @ApiModelProperty("更新时间")
//        private String update_time;
        @ApiModelProperty("预计差旅费")
        private String gus_money;
        @ApiModelProperty("拟开发供应商名称")
        private String gus_suppiler_name;
        @ApiModelProperty("供应商代码")
        private String suppiler_code;
//        List<SupRole> list_role;  //供应商合集

}
