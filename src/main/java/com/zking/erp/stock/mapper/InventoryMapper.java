package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.Inventory;

public interface InventoryMapper {
    int insert(Inventory record);

    int insertSelective(Inventory record);
}