package com.example.cruddemo.mapper;

import com.example.cruddemo.entity.ProInfoEntity;
import com.example.cruddemo.entity.SupBaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper

//mapper层
public interface CurdBaseDao {

//    查-按条件查询
//    public List<String> GetRule(@Param("tab_name")String tab_name,@Param("set_rule")String set_rule);
    List<SupBaseEntity> GetSupBaseRule(@Param("set_rule")String set_rule);
    List<ProInfoEntity> GetProInfoRule(@Param("set_rule")String set_rule);
//    查-全部
     List<SupBaseEntity> GetSupBaseAll();
     List<ProInfoEntity> GetProInfoAll();
//    public List<String> GetAll(@Param("tab_name")String tab_name);
//删除
    public void deleteData(String tab_name,String set_rule);
//更新
    public void updateSupBase(SupBaseEntity supBaseEntity);
    public void updateProInfo(ProInfoEntity proInfoEntity);
//    新增
    public void insertSupBase(SupBaseEntity supBaseEntity);
    public void insertProInfo(ProInfoEntity proInfoEntity);




    ////    增
//    //添加申请信息（对象实体、表名、数据）
//    public <RechargeVo> void insertData(@Param("rechargeVo") RechargeVo rechargeVo, @Param("tab_name") List tab_name, @Param("data")  List data);
////删
////改
//    public <RechargeVo> void updateData( @Param("tab_name") String tab_name);
////    传入实体类（sup pro）和表名

}
