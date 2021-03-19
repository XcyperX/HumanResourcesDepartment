package com.spring.service.impl;

import com.spring.DTO.OrderHistoryDTO;
import com.spring.DTO.ProductDTO;
import com.spring.mapper.OrderHistoryMapper;
import com.spring.model.OrderHistory;
import com.spring.model.Product;
import com.spring.model.Role;
import com.spring.repository.OrderHistoryRepository;
import com.spring.repository.ProductRepository;
import com.spring.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final MapperFacade mapperFacade;
    private final OrderHistoryRepository orderHistoryRepository;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;

    @Override
    public List<OrderHistoryDTO> findAll() {
        return mapperFacade.mapAsList(orderHistoryRepository.findAll(), OrderHistoryDTO.class);
    }

    @Override
    public OrderHistoryDTO getById(Long id) {
        if (orderHistoryRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого заказа!");
        }
        return mapperFacade.map(orderHistoryRepository.findById(id), OrderHistoryDTO.class);
    }

    @Override
    public OrderHistoryDTO save(OrderHistoryDTO orderHistoryDTO) {
        Float sum = 0F;
//        List<ProductDTO> products = orderHistoryDTO.getProductList();
//        products.forEach(productDTO -> {
//            ProductDTO productLegacy = productService.getById(productDTO.getId());
//            productLegacy.setAmount(productLegacy.getAmount() - 1);
//            if (productLegacy.getAmount() < 0) {
//                throw new RuntimeException("Ошибка, товар закончился!");
//            }
//            productRepository.save(mapperFacade.map(productLegacy, Product.class));
//        });
        for (int i = 0; i < orderHistoryDTO.getOrderProductInfoDTOS().size(); i++) {
            sum += orderHistoryDTO.getOrderProductInfoDTOS().get(i).getAmount() * productService.getById(orderHistoryDTO.getOrderProductInfoDTOS().get(i).getProduct().getId()).getPrice();
        }
        orderHistoryDTO.setPrice(sum);
        OrderHistory orderHistory = orderHistoryRepository.save(mapperFacade.map(orderHistoryDTO, OrderHistory.class));
        return mapperFacade.map(orderHistory, OrderHistoryDTO.class);
    }

    @Override
    public OrderHistoryDTO update(OrderHistoryDTO orderHistoryDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (orderHistoryRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого заказа!");
        }
        orderHistoryRepository.deleteById(id);
    }

    @Override
    public List<OrderHistoryDTO> getListByCustomer() {
//        List<OrderHistory> orderHistory = mapperFacade.mapAsList(orderHistoryRepository.findAllByCustomerNotNullOrUserRole(Role.CUSTOMER), OrderHistory.class);
        return mapperFacade.mapAsList(orderHistoryRepository.findAllByCustomerNotNullOrUserRole(Role.CUSTOMER), OrderHistoryDTO.class);
    }

    @Override
    public List<OrderHistoryDTO> getListByProvider() {
        List<OrderHistory> orderHistories = new ArrayList<>();
        orderHistories.addAll(orderHistoryRepository.findAllByUserRole(Role.ADMIN));
        orderHistories.addAll(orderHistoryRepository.findAllByUserRole(Role.STOREKEEPER));
//        List<OrderHistory> orderHistory = mapperFacade.mapAsList(orderHistories, OrderHistory.class);
        return mapperFacade.mapAsList(orderHistories, OrderHistoryDTO.class);
    }
}
