package com.spring.service.impl;

import com.spring.DTO.OrderHistoryDTO;
import com.spring.DTO.ProductDTO;
import com.spring.mapper.OrderHistoryMapper;
import com.spring.model.*;
import com.spring.repository.OrderHistoryRepository;
import com.spring.repository.ProductRepository;
import com.spring.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
        Double sum = 0D;
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

    @Override
    public void addProductsInStock(Long orderId, Long stockId, User user) {
        if (orderHistoryRepository.findById(orderId).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого заказа!");
        }
        OrderHistory orderHistory = orderHistoryRepository.findById(orderId).get();
        orderHistory.getOrderProductInfos().forEach(orderProductInfo -> {
            Product product = productRepository.findById(orderProductInfo.getProduct().getId()).get();
            Product test = new Product();
            test.setId(null);
            test.setImage(product.getImage());
            test.setStore(new Store(stockId));
            test.setPrice(product.getPrice());
            test.setAmount(orderProductInfo.getAmount());
            test.setOrderProductInfos(null);
            test.setCategories(product.getCategories());
            test.setDescription(product.getDescription());
            test.setManufacturer(product.getManufacturer());
            test.setName(product.getName());
            test.setSupplies(null);
            test.setUrlPhoto(product.getUrlPhoto());
            test.setUser(user);

            product.setAmount(product.getAmount() - orderProductInfo.getAmount());

            productRepository.save(test);
            productRepository.save(product);
        });
        orderHistoryRepository.deleteById(orderId);
    }
}
