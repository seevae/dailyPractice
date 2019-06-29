package io.github.seevae.service;/*
    name zhang;
    */

import io.github.seevae.mapper.ItemsCustomMapper;
import io.github.seevae.mapper.ItemsMapper;
import io.github.seevae.po.Items;
import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception {
        List<ItemsCustom> list = itemsCustomMapper.queryItemsByName(itemsVO);
        return list;
    }

    @Override
    public Items selectByPrimaryKey(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateByPrimaryKeyWithBLOBs(Integer id, Items items) throws Exception {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }

}
