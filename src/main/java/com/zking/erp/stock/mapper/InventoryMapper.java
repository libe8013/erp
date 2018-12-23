package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.Inventory;
import com.zking.erp.stock.vo.InventoryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryMapper {
    int insert(Inventory record);

    int insertSelective(Inventory record);

    /**
     * 查询所有
     * @param inventoryVo
     * @return
     */
    List<Map<String,Object>> queryInventoryPager(InventoryVo inventoryVo);
}