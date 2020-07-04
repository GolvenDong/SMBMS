package com.golven.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.golven.mapper.ProviderMapper;
import com.golven.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
@RequestMapping("provider")
@Controller
public class ProviderController {
    @Autowired
    private ProviderMapper providerMapper;
    @RequestMapping("providerList")
    public String show(Model model,
                       @RequestParam(defaultValue = "") String proName,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize){
        //1.分页
        PageHelper.startPage(pageNo,pageSize);
        model.addAttribute("proName",proName);
        List<Provider> providers;
        //2.查询
        if(proName==""){
            providers = providerMapper.selectByPage();
        } else {
            providers = providerMapper.selectAbstract(proName);
        }
        System.out.println(providers);
        //3.封装pageInfo
        PageInfo<Provider> providerInfo = (PageInfo<Provider>) new PageInfo<>(providers);
        //4.存model
        model.addAttribute("providerInfo",providerInfo);
        System.out.println("providerInfo:"+providerInfo);
        return "providerList";
        //5.跳转showHouse.html
//        return "admin/house/showHouse";
    }
    //跳转到providerAdd.html
    @RequestMapping("providerAdd")
    public String toAdd(){
        return "providerAdd";
    }
    //新增供应商
    @RequestMapping("addProvider")
    public String addProvider(Provider provider){
        Date dt=new Date();
        provider.setModifyDate(dt);
        provider.setCreationDate(dt);
        int i = providerMapper.addProvider(provider);
        //重定向
        return "redirect:/provider/providerList";
    }
    @RequestMapping("providerUpdate")
    public String providerUpdate(int id, Model model){
        System.out.println("id"+id);
        Provider provider = providerMapper.selectProviderById(id);
        model.addAttribute("provider",provider);
        System.out.println("1111model"+model);
        return "providerUpdate";
    }
    @RequestMapping("upadte")
    public String upadte(Provider provider){
        Boolean i = providerMapper.updateById(provider);
        return "redirect:/provider/providerList";
    }
    @RequestMapping("providerDelete")
    public String providerDelete(int id){
        providerMapper.deleteById(id);
        return "redirect:/provider/providerList";
    }
}
