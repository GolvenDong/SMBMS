package com.golven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider implements Serializable{
	private int id;//主鍵id
	private String proCode;//供应商编码
	private String proName;//供应商名字
	private String proDesc;//供应商描述
	private String proContact;//供应商联系人
	private String proPhone;//供应商联系电话
	private String proAddress;//地址
	private String proFax;//传真
	private int createdBy;//创建者（userId）
	private Date creationDate;//创建时间
	private int modifyBy;//更新者（userId）
	private Date modifyDate;//更新时间

}
