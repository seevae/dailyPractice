package io.github.seevae.service;/*
    name zhang;
    */

import io.github.seevae.po.Items;
import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;

import java.util.List;

public interface ItemsService {
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;

    public Items selectByPrimaryKey(Integer id) throws Exception;

    public void updateByPrimaryKeyWithBLOBs(Integer id,Items items) throws Exception;
}
