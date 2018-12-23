package com.zking.erp.stock.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.model.Inventory;
import com.zking.erp.stock.vo.InventoryVo;

import java.util.List;
import java.util.Map;

public interface IInventoryService {
    int insert(Inventory record);

    int insertSelective(Inventory record);

    /**
     * 查询所有
     * @param inventoryVo
     * @return
     */
    List<Map<String,Object>> queryInventoryPager(InventoryVo inventoryVo, PageBean pageBean);
}