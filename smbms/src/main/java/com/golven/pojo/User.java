package com.golven.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "smbms_user")
public class User {
	@TableId(type = IdType.AUTO)
	private int id;

	@TableField(value = "userCode")
	private String userCode;

	@TableField(value = "userName")
	private String userName;

	@TableField(value = "userPassword")
	private String userPassword;

	private int gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String phone;
	private String address;

	@TableField(value = "userType")
	private int userType;

	@TableField(value = "createdBy")
	private int createdBy;

	@TableField(value = "creationDate", fill = FieldFill.INSERT)
	private Date creationDate;

	@TableField(value = "modifyBy")
	private int modifyBy;

	@TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
	private Date modifyDate;
}
