package com.spring.service.impl;

import com.spring.DTO.OrderHistoryDTO;
import com.spring.mapper.OrderHistoryMapper;
import com.spring.repository.OrderHistoryRepository;
import com.spring.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<OrderHistoryDTO> findAll() {
        return orderHistoryMapper.toDtos(orderHistoryRepository.findAll());
    }

    @Override
    public OrderHistoryDTO getById(Long id) {
        if (orderHistoryRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого заказа!");
        }
        return orderHistoryMapper.toDto(orderHistoryRepository.findById(id).get());
    }

    @Override
    public OrderHistoryDTO save(OrderHistoryDTO orderHistoryDTO) {
        return orderHistoryMapper.toDto(orderHistoryRepository.save(orderHistoryMapper.toEntity(orderHistoryDTO)));
    }

    @Override
    public OrderHistoryDTO update(OrderHistoryDTO orderHistoryDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
