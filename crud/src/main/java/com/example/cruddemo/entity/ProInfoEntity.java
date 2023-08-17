package com.example.cruddemo.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel("产品信息实体类")
public class ProInfoEntity<ProRole> {
    @ApiModelProperty("主键")
    private Integer pro_id;
    @ApiModelProperty("产品领域")
    private String pro_type;
    @ApiModelProperty("产品名称")
    private String pro_name;
    @ApiModelProperty("申请信息id")
    private Integer apply_id;
    @ApiModelProperty("创建者")
    private String creator;
//    @ApiModelProperty("创建时间 ")
//    private String create_time;
    @ApiModelProperty("更新者")
    private String updater;
//    @ApiModelProperty("更新时间")
//    private String update_time;
    @ApiModelProperty("供方名称")
    private String sup_name;
    @ApiModelProperty("供应商代码")
    private String suppiler_code;
//    List<ProRole> list_role;  //产品数据

}
