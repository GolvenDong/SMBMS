package com.golven.mapper;

import com.golven.pojo.Bill;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    @Select("select bid,billCode,productName,proName,totalPrice,isPayment,updateDate from smbms_bill b,smbms_provider p where b.providerId=p.id and p.proName LIKE '%${proName}%' and b.productName like '%${productName}%' and b.isPayment like '%${isPayment}%'")
    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "billCode",property = "billCode"),
            @Result(column = "productName",property = "productName"),
            @Result(column = "proName",property = "proName"),
            @Result(column = "totalPrice",property = "totalPrice"),
            @Result(column = "isPayment",property = "isPayment"),
            @Result(column = "updateDate",property = "updateDate"),
    })
    List<Bill> selectAbstract(@Param("productName") String productName, @Param("proName") String proName, @Param("isPayment") String isPayment);

    @Select("select bid,billCode,productName,proName,totalPrice,isPayment,updateDate from smbms_bill b,smbms_provider p where b.providerId=p.id")
//    @ResultMap("BillMap")
    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "billCode",property = "billCode"),
            @Result(column = "productName",property = "productName"),
            @Result(column = "proName",property = "proName"),
            @Result(column = "totalPrice",property = "totalPrice"),
            @Result(column = "isPayment",property = "isPayment"),
            @Result(column = "updateDate",property = "updateDate"),
    })
    List<Bill> selectAllPage();
    @Insert("insert into smbms_bill values (0, #{billCode}, #{productName}, #{productDesc}, #{productUnit}, #{productCount}, #{totalPrice}, #{isPayment}, #{providerId}, #{creationDate}, #{createdBy}, #{updateDate}, #{modifyBy})")
    Boolean add(Bill bill);
    @Delete("delete from smbms_bill where bid = #{bid}")
    Boolean deleteById(int bid);
    @Select("select * from smbms_bill where bid = #{bid}")
    Bill selectById(int bid);
    @Update("update smbms_bill SET productName=#{productName}, productUnit=#{productUnit},productCount=#{productCount},totalPrice=#{totalPrice},productDesc=#{productDesc},isPayment=#{isPayment},updateDate=#{updateDate} where bid=#{bid}")
    Boolean updateBill(Bill bill);
}


