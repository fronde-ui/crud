package com.example.cruddemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cruddemo.entity.ProInfoEntity;
import com.example.cruddemo.entity.ResultData;
import com.example.cruddemo.mapper.CurdBaseDao;
import com.example.cruddemo.service.CurdBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cruddemo.entity.SupBaseEntity;

import java.util.List;

@Service

public class CurdBaseServiceImpl implements CurdBaseService {
    @Autowired
    private CurdBaseDao curdBaseDao;


    //    增加
//    public <RechargeVo> ResultData insertData(@Param("rechargeVo") RechargeVo rechargeVo, @Param("tab_name") String tab_name){
//        try{
////            处理实体类
////            Tabentity tabentity=
//
////把string转为entity
////            SupBaseEntity  supBaseEntity= JSON.parseObject(data,SupBaseEntity.class);
////            curdBaseDao.insertData(supBaseEntity);
//            return ResultData.ResultDataSuccessSelf("添加"+tab_name+"数据成功", null);
//        }catch(Exception e){
//            e.printStackTrace();
//            return ResultData.ResultDataFaultSelf("添加"+tab_name+"数据失败为" + e.getMessage(), null);
//        }
//    };
//    查询sup
    public List<SupBaseEntity> GetSupBaseAll() {
        List<SupBaseEntity> list = curdBaseDao.GetSupBaseAll();
        return list;
    }
    //        查询pro
    public List<ProInfoEntity> GetProInfoAll() {
        List<ProInfoEntity> list = curdBaseDao.GetProInfoAll();
        return list;
    }

    ;
//        public List GetAll(String tab_name){
//            List list = curdBaseDao.GetAll(tab_name);
//            return list;
//        };
//        按照条件查询
    public List<SupBaseEntity> GetSupBaseRule(String set_rule){
        List<SupBaseEntity> list = curdBaseDao.GetSupBaseRule(set_rule);
        return list;
    };
    public List<ProInfoEntity> GetProInfoRule(String set_rule){
        List<ProInfoEntity> list = curdBaseDao.GetProInfoRule(set_rule);
        return list;
    };
//    删除
    public ResultData deleteData(String tab_name, String set_rule){
        try {

            curdBaseDao.deleteData(tab_name,set_rule);
            return ResultData.ResultDataSuccessSelf("删除数据成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("删除失败,失败信息为" + e.getMessage(), null);
        }
    };
//更新
    public ResultData updateSupBase(String data){
        try {
            SupBaseEntity supBaseEntity = JSON.parseObject(data,SupBaseEntity.class);
            System.out.println("service"+supBaseEntity);
            curdBaseDao.updateSupBase(supBaseEntity);
            return ResultData.ResultDataSuccessSelf("修改成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("修改失败,失败信息为" + e.getMessage(), null);
        }
    };

    public ResultData updateProInfo(String data){
        try {
            ProInfoEntity proInfoEntity = JSON.parseObject(data,ProInfoEntity.class);
            System.out.println("service"+proInfoEntity);
            curdBaseDao.updateProInfo(proInfoEntity);
            return ResultData.ResultDataSuccessSelf("修改成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("修改失败,失败信息为" + e.getMessage(), null);
        }
    };
//    新增
    public ResultData insertSupBase(String data){
        try {
            SupBaseEntity supBaseEntity = JSON.parseObject(data,SupBaseEntity.class);
            System.out.println("service"+supBaseEntity);
            curdBaseDao.insertSupBase(supBaseEntity);
            return ResultData.ResultDataSuccessSelf("新增成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("新增失败,失败信息为" + e.getMessage(), null);
        }
    };
    public ResultData insertProInfo(String data){
        try {
            ProInfoEntity proInfoEntity = JSON.parseObject(data,ProInfoEntity.class);
            System.out.println("service"+proInfoEntity);
            curdBaseDao.insertProInfo(proInfoEntity);
            return ResultData.ResultDataSuccessSelf("新增成功", data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.ResultDataFaultSelf("新增失败,失败信息为" + e.getMessage(), null);
        }
    };
//    获取最新的apply_id
    public Integer  GetApplyId(){
        List<SupBaseEntity> list=curdBaseDao.GetSupBaseRule("apply_id = (SELECT max(apply_id) FROM sup_base)");
        String supbase=list.get(0).toString();
        System.out.println("list:"+supbase+list.get(0).getApply_id().getClass());
        return list.get(0).getApply_id();
    }
}
