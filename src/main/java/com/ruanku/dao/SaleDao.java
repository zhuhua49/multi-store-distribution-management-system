package com.ruanku.dao;

import com.ruanku.domain.Member;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDao {


    //店铺销售额查询所有
    @Select("select * from sale")
    public List<Sale> FindAll();

    // 根据和id多条件查询金额范围查询账单
    @Select("select * from sale where storeId=#{storeId} and income between #{MinMoney} and #{MaxMoney}")
    public List<Sale> Query(@Param("storeId") Integer storeId,@Param("MinMoney") Integer MinMoney, @Param("MaxMoney") Integer MaxMoney);

    // 如果id为空时查询金额范围查询账户账单
    @Select("select * from sale where income between #{MinMoney} and #{MaxMoney}")
    public List<Sale> Queryc(@Param("MinMoney") Integer MinMoney, @Param("MaxMoney") Integer MaxMoney);

    //多店铺销售额对比-从小到大
    @Select("select * from (select * from sale where income between #{MinMoney} and #{MaxMoney} and sTime between #{StartDate} and #{EndDate})as a ORDER BY income ASC")
    public List<Sale> ContrastMinToMax(@Param("MinMoney")Integer MinMoney, @Param("MaxMoney") Integer MaxMoney,@Param("StartDate") String StartDate, @Param("EndDate") String EndDate);

    //多店铺销售额对比-从大到小
    @Select("select * from (select * from sale where income between #{MinMoney} and #{MaxMoney} and sTime between #{StartDate} and #{EndDate})as a ORDER BY income DESC")
    public List<Sale> ContrastMaxToMin(@Param("MinMoney")Integer MinMoney, @Param("MaxMoney") Integer MaxMoney,@Param("StartDate") String StartDate, @Param("EndDate") String EndDate);

    // 添加销售额信息
    @Insert("insert into sale (sTime,income,storeId,orders,remarks) values (#{sTime},#{income},#{storeId},#{orders},#{remarks})")
    public void Add(Sale sale);

    //生成柱状图
    @Select("select * from (select * from sale where sTime between #{StartDate} and #{EndDate} and storeId=#{storeId})as a ORDER BY sTime ASC")
    public List<Sale> DateView(@Param("StartDate") String StartDate, @Param("EndDate") String EndDate,@Param("storeId") Integer storeId);

}