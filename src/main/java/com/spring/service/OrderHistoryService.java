package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.OrderHistoryDTO;
import com.spring.base.CRUDService;
import com.spring.model.User;

import java.util.List;

public interface OrderHistoryService extends CRUDService<OrderHistoryDTO, Long> {
    List<OrderHistoryDTO> getListByCustomer();
    List<OrderHistoryDTO> getListByProvider();
    void addProductsInStock(Long orderId, Long stockId, User user);
//    List<OrderHistoryDTO> findAll();
}
