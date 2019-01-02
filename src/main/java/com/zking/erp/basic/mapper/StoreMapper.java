package com.zking.erp.basic.mapper;

import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.basic.vo.StoreVo;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> queryStoreLikePager(Store store);

    Map<String,Object> queryGoodsStore(StoreVo storeVo);

    List<Map<String,Object>> queryStoreGoodsSupplier(StoreVo storeVo);

    List<Map<String,Object>> queryStoreGoodsUUID(StoreDetail goods);

    /**
     * 查询仓库里有得商品
     * @return
     */
    List<Goods> queryStoreDetailGoods();

    /**
     * 查询仓库里对应的商品
     * @param goodsuuid
     * @return
     */
    List<Store> queryStoreGoods(String goodsuuid);
}