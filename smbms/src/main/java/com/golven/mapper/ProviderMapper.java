package com.golven.mapper;

import com.golven.pojo.Provider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProviderMapper {
    @Select("select * from smbms_provider" )
    public List<Provider> selectByPage();
    @Select("select * from smbms_provider where proName LIKE '%${proName}%'")
    public List<Provider> selectAbstract(@Param(value="proName") String proName);
    @Insert("insert into smbms_provider(proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,creationDate,modifyDate) values (#{proCode},#{proName}, #{proContact}, #{proPhone}, #{proAddress}, #{proFax}, " +
            "#{proDesc},#{creationDate},#{modifyDate})")
    int addProvider(Provider provider);
    @Select("select * from smbms_provider where id=#{id}")
    Provider selectProviderById(int id);
    @Update("update smbms_provider SET proCode=#{proCode},proContact=#{proContact}, proPhone=#{proPhone},proAddress=#{proAddress},proFax=#{proFax},proDesc=#{proDesc} where id=#{id}")
    Boolean updateById(Provider provider);
    @Delete("delete from smbms_provider where id=#{id}")
    Boolean deleteById(int id);
}
