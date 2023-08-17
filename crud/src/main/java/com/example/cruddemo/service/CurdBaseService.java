package com.example.cruddemo.service;

import com.example.cruddemo.entity.ProInfoEntity;
import com.example.cruddemo.entity.ResultData;
import com.example.cruddemo.entity.SupBaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurdBaseService {

//    按照条件查询
    public List<SupBaseEntity> GetSupBaseRule(String set_rule);
    public List<ProInfoEntity> GetProInfoRule(String set_rule);
//    public List GetRule(String tab_name,String set_rule);
//    public List GetAll(String tab_name);
//    查全部
    public List<SupBaseEntity> GetSupBaseAll();
    public List<ProInfoEntity> GetProInfoAll();
//    删除
    public ResultData deleteData(String tab_name, String set_rule);
//更新
    public ResultData updateSupBase(String data);
    public ResultData updateProInfo(String data);
//新增
    public ResultData insertSupBase(String data);
    public ResultData insertProInfo(String data);
    public Integer GetApplyId();
}
