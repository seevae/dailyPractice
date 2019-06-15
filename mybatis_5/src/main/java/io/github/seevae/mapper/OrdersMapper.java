package io.github.seevae.mapper;/*
    name zhang;
    */

import io.github.seevae.po.Orders;
import io.github.seevae.po.OrdersExtend;

import java.util.List;

public interface OrdersMapper {

    //使用resultType
    public List<OrdersExtend> findUserWithOrder() throws Exception;
    //使用resultMap
    public List<OrdersExtend> findUserWithOrder2() throws  Exception;


    public List<OrdersExtend> findOrderOrderDetailRM() throws Exception;


    public List<OrdersExtend> findUserToItems() throws Exception;
}
