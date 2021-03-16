package com.spring.mapper;

import com.spring.DTO.OrderHistoryDTO;
import com.spring.base.MapperService;
import com.spring.model.OrderHistory;
import com.spring.model.Manufacturer;
import com.spring.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderHistoryMapper implements MapperService<OrderHistory, OrderHistoryDTO> {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public OrderHistory toEntity(OrderHistoryDTO dto) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(dto.getId());
        orderHistory.setDateOrder(dto.getDateOrder());
        orderHistory.setProductList(productMapper.toEntities(dto.getProductList()));
        orderHistory.setPrice(dto.getPrice());
        return orderHistory;
    }

    @Override
    public OrderHistoryDTO toDto(OrderHistory entity) {
        OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO();
        orderHistoryDTO.setId(entity.getId());
        orderHistoryDTO.setDateOrder(entity.getDateOrder());
        orderHistoryDTO.setProductList(productMapper.toDtos(entity.getProductList()));
        orderHistoryDTO.setPrice(entity.getPrice());
        return orderHistoryDTO;
    }

    @Override
    public List<OrderHistory> toEntities(List<OrderHistoryDTO> dto) {
        List<OrderHistory> orderHistories = new ArrayList<>();
        dto.forEach(orderHistoryDTO -> orderHistories.add(toEntity(orderHistoryDTO)));
        return orderHistories;
    }

    @Override
    public List<OrderHistoryDTO> toDtos(List<OrderHistory> entity) {
        List<OrderHistoryDTO> orderHistoryDTOS = new ArrayList<>();
        entity.forEach(orderHistory -> orderHistoryDTOS.add(toDto(orderHistory)));
        return orderHistoryDTOS;
    }
}
