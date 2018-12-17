package com.zking.erp.stock.service.imp;

import com.zking.erp.base.util.BaseTestCase;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
//import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.vo.StoredetailVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class StoreDetailServiceImplTest extends BaseTestCase {

//    @Autowired
//    private IStoreDetailService storeDetailService;

    @Before
    public void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void queryStoreLike() {
//        StoredetailVo storedetailVo = new StoredetailVo();
//        Goods goods = new Goods();
//        Store store = new Store();
//        store.setName("二%");
//        storedetailVo.setGoods(goods);
//        storedetailVo.setStore(store);
//        List<Map<String, Object>> maps = storeDetailService.queryStoreLikePage(storedetailVo);
//        for (Map<String, Object> map : maps) {
//            System.out.println(map);
//        }
    }
}