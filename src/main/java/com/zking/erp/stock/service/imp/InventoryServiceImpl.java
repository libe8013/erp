package com.zking.erp.stock.service.imp;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.mapper.InventoryMapper;
import com.zking.erp.stock.model.Inventory;
import com.zking.erp.stock.service.IInventoryService;
import com.zking.erp.stock.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public int insert(Inventory record) {
        return inventoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Inventory record) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryInventoryPager(InventoryVo inventoryVo, PageBean pageBean) {
        return inventoryMapper.queryInventoryPager(inventoryVo);
    }

    @Override
    public int updAudit(Inventory inventory) {
        return inventoryMapper.updAudit(inventory);
    }

    @Override
    public List<Map<String, Object>> queryInvWtypePager(InventoryVo inventoryVo, PageBean pageBean) {
        return inventoryMapper.queryInvWtypePager(inventoryVo);
    }

}
