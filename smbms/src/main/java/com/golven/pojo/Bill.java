package com.golven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	private int bid;// 主键id
	private String billCode;// 账单编码
	private String productName;// 商品名称
	private String productDesc;// 商品描述
	private String productUnit;//单位
	private BigDecimal productCount;//商品数量
	private BigDecimal totalPrice;//总金额
	private int isPayment;//是否付款（1，未支付 2，已支付）
	private int providerId;//供应商Id
	private Date creationDate;//创建时间
	private int createdBy;//创建者userId
	private Date updateDate;//修改时间
	private int modifyBy;//修改者userId

	private String proName;//供应商名字

}
