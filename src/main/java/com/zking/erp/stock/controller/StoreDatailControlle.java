package com.zking.erp.stock.controller;

import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreDatailControlle {

    @Autowired
    private IStoreDetailService storeDetailService;

    private StoredetailVo storedetailVo;

    public String queryStoreLikePage(){
        return null;
    }

}
