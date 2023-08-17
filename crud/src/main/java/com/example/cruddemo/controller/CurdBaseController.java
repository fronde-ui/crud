package com.example.cruddemo.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.cruddemo.entity.ProInfoEntity;
import com.example.cruddemo.entity.ResultData;
import com.example.cruddemo.entity.SupBaseEntity;
import com.example.cruddemo.service.CurdBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController//将当前类加载成控制器
@RequestMapping("/curdBase")
@Api(value = "curdBase")
public class CurdBaseController {
    //    @Resource
    @Autowired(required = false)
    private CurdBaseService curdBaseService;

    //查看全部记录
    @RequestMapping(value = {"/getAll"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "查看全部字段")
    @ResponseBody
    public List getAll(String tab_name) {
        List list = new ArrayList();
        list.add("error");
        if (tab_name.equals("sup_base")) {
            list = curdBaseService.GetSupBaseAll();
        } else if (tab_name.equals("pro_info")) {
            list = curdBaseService.GetProInfoAll();
        }
        return list;
    }

    ;

    //    按照条件查询
    @RequestMapping(value = {"/getRule"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "按照条件查询")
    @ResponseBody
    public List getDatRole(String tab_name, String set_rule) {
        List list = new ArrayList();
        list.add("error");
        if (tab_name.equals("sup_base")) {
            System.out.println("set_rule" + set_rule);
            list = curdBaseService.GetSupBaseRule(set_rule);
        } else if (tab_name.equals("pro_info")) {
                list = curdBaseService.GetProInfoRule(set_rule);
        }
        return list;
    }


    //    根据条件删除
    @RequestMapping(value = {"/del"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "删除")
    @ResponseBody
    public ResultData deleteData(String tab_name, String set_rule) {
        try {
            if (tab_name.equals("sup_base")) {
                try {
                    curdBaseService.deleteData(tab_name, set_rule);
                    curdBaseService.deleteData("pro_info", set_rule);
                    return ResultData.ResultDataSuccessSelf("删除申请相关数据成功", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultData.ResultDataFaultSelf("删除失败,失败信息为" + e.getMessage(), null);
                }
            } else if (tab_name.equals("pro_info")) {
                try {
                    curdBaseService.deleteData(tab_name, set_rule);
                    return ResultData.ResultDataSuccessSelf("删除产品数据成功", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultData.ResultDataFaultSelf("删除失败,失败信息为" + e.getMessage(), null);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("删除失败,失败信息为" + e.getMessage(), null);
        }

    }

    ;

    //    更新
    @RequestMapping(value = {"/update"}, method = {RequestMethod.POST})
    @ApiOperation(value = "更新")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tab_name", value = "表名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "data", value = "json字符串,包含实体类", required = true, dataType = "String")})
    public ResultData update(@RequestBody String data) {
        try {
            System.out.println("su" + data);
            JSONObject jsonObject = JSON.parseObject(data);
            System.out.println("uid" + jsonObject);
            if (jsonObject.containsKey("pro_id")) {
//                说明是产品表
                curdBaseService.updateProInfo(data);
                return ResultData.ResultDataSuccessSelf("更新pro_info表成功", data);

            } else {
                curdBaseService.updateSupBase(data);
                return ResultData.ResultDataSuccessSelf("更新sup_base成功", data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("更新失败，失败信息为" + e.getMessage(), null);
        }
    }

    ;

    //新增
    @RequestMapping(value = {"/insert"}, method = {RequestMethod.POST})
    @ApiOperation(value = "新增")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "json字符串,包含实体类", required = true, dataType = "String")})
    public ResultData insert(@RequestBody String data) {
        try {
//            批量增加//循环插入
            JSONArray dataJson = JSON.parseArray(data) ;
            System.out.println("su" + dataJson.getClass()+dataJson.size());
            for(int i = 0; i < dataJson.size(); i++){
                JSONObject iJson = dataJson.getJSONObject(i);
                System.out.println("json"+iJson);
                if (iJson.containsKey("apply_id") & !iJson.containsKey("pro_id")) {
                    //只有申请表数据
                    curdBaseService.insertSupBase(dataJson.get(i).toString());
                } else if (iJson.containsKey("pro_id") & !iJson.containsKey("apply_pro")) {
//                只有产品表数据
//                判断是否 有一样的产品领域和产品名称数据
//               按照 产品领域和产品名称查询，如果查询的结果不为空，则重复数据，为空，则增加数据
                    try{
                        if(iJson.getString("apply_id")!=""){
                            Integer apply_val=curdBaseService.GetApplyId();
                            iJson.put("apply_id",apply_val);
                            String set_rule="pro_type="+JSON.toJSONString(iJson.get("pro_type"))+"and pro_name="+JSON.toJSONString(iJson.get("pro_name"));
                            List list = curdBaseService.GetProInfoRule(set_rule);
                            System.out.println("list:"+list);
                            if(list.size()==0){
                                curdBaseService.insertProInfo(iJson.toString());
                            }else{
                                return ResultData.ResultDataSuccessSelf("不可重复增加相同的产品领域和产品名称数据！", null);
                            }
                        }else{
                            String set_rule="pro_type="+JSON.toJSONString(iJson.get("pro_type"))+"and pro_name="+JSON.toJSONString(iJson.get("pro_name"));
                            List list = curdBaseService.GetProInfoRule(set_rule);
                            System.out.println("list:"+list);
                            if(list.size()==0){
                                curdBaseService.insertProInfo(iJson.toString());
                            }else{
                                return ResultData.ResultDataSuccessSelf("不可重复增加相同的产品领域和产品名称数据！", null);
                            }
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                        return ResultData.ResultDataFaultSelf("新增失败，失败信息为" + e.getMessage(), null);
                    }
                } else {
                    return null;
                }
            }
            return ResultData.ResultDataSuccessSelf("新增表成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("新增失败，失败信息为" + e.getMessage(), null);
        }
    };


}

