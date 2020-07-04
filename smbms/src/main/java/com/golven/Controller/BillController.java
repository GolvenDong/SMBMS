package com.golven.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.golven.mapper.BillMapper;
import com.golven.pojo.Bill;
import com.golven.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("bill")
public class BillController {
    @Autowired
    private BillMapper billMapper;
    @RequestMapping("billList")
    public String toBillList(String productName,String proName,String isPayment,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "3") Integer pageSize,
                             Model model
                             ){
        model.addAttribute("productName",productName = productName==null?"":productName);
        model.addAttribute("proName",proName = proName==null?"":proName);
        model.addAttribute("isPayment",isPayment = isPayment==null?"":isPayment);
        PageHelper.startPage(pageNum,pageSize);

        System.out.println("productName:"+productName+"proName:"+proName+"isPayment"+isPayment);
        List<Bill> bills;
        if(productName==""&&proName==""&&isPayment==""){
            bills = billMapper.selectAllPage();
        }else {
            bills = billMapper.selectAbstract(productName,proName,isPayment);
        }
        PageInfo<Bill> billInfo = (PageInfo<Bill>) new PageInfo<>(bills);
        model.addAttribute("billInfo",billInfo);
        System.out.println(bills);
        return "billList";
    }
    //跳转到增加
    @RequestMapping("billAdd")
    public String billAdd(){
        return "billAdd";
    }
    //增加bill
    @RequestMapping("add")
    public String add(Bill bill){
        Date date = new Date();
        bill.setCreationDate(date);
        bill.setUpdateDate(date);
        Boolean add = billMapper.add(bill);
        return "redirect:/bill/billList";
    }
    //删除
    @RequestMapping("billDelete")
    public String billDelete(int bid){
        billMapper.deleteById(bid);
        return "redirect:/bill/billList";
    }
    //跳转到更新
    @RequestMapping("billUpdate")
    public String providerUpdate(int bid,Model model){
        Bill bill = billMapper.selectById(bid);
        model.addAttribute("bill",bill);
        return "billUpdate";
    }
    //更新
    @RequestMapping("updateBill")
    public String updateBill(Bill bill){
        Date date = new Date();
        bill.setUpdateDate(date);
        billMapper.updateBill(bill);
        return "redirect:/bill/billList";
    }
}
