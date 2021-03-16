package com.spring.mapper;

import com.spring.DTO.*;
import com.spring.model.*;
import com.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MapperConfig extends ConfigurableMapper {
    protected void configure(MapperFactory factory) {
        factory.classMap(Store.class, StoreDTO.class)
                .byDefault()
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(Store store, StoreDTO storeDTO, MappingContext context) {
                        if (store.getUsers() != null) {
                            List<User> users = new ArrayList<>();
                            store.getUsers().forEach(user -> {
                                user.setStores(null);
                                users.add(user);
                            });
                            storeDTO.setUsers(mapperFacade.mapAsList(users, UserDTO.class));
                        }
                        if (store.getProducts() != null) {
                            storeDTO.setProducts(mapperFacade.mapAsList(store.getProducts(), ProductDTO.class));
                        }
                        super.mapAtoB(store, storeDTO, context);
                    }

                    @Override
                    public void mapBtoA(StoreDTO storeDTO, Store store, MappingContext context) {
                        if (storeDTO.getUsers() != null) {
                            store.setUsers(mapperFacade.mapAsList(storeDTO.getUsers(), User.class));
                        }
                        if (storeDTO.getProducts() != null) {
                            store.setProducts(mapperFacade.mapAsList(storeDTO.getProducts(), Product.class));
                        }
                        super.mapBtoA(storeDTO, store, context);
                    }
                })
                .register();

        factory.classMap(User.class, UserDTO.class)
                .field("subdivision.id", "subdivisionId")
                .byDefault()
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(User user, UserDTO userDTO, MappingContext context) {
                        if (userDTO.getStores() != null) {
                            List<StoreDTO> storeDTOS = new ArrayList<>();
                            userDTO.getStores().forEach(storeDTO -> {
                                storeDTO.setUsers(null);
                                storeDTOS.add(storeDTO);
                            });
                            user.setStores(mapperFacade.mapAsList(storeDTOS, Store.class));
                        }
                        super.mapAtoB(user, userDTO, context);
                    }

                    @Override
                    public void mapBtoA(UserDTO userDTO, User user, MappingContext context) {
                        userDTO.setStores(mapperFacade.mapAsList(user.getStores(), StoreDTO.class));
                        super.mapBtoA(userDTO, user, context);
                    }
                })
                .register();

        factory.classMap(Subdivision.class, SubdivisionDTO.class)
                .byDefault()
                .register();

        factory.classMap(Supplies.class, SuppliesDTO.class)
                .byDefault()
                .register();

//        factory.classMap(Status.class, StatusDTO.class)
//                .byDefault()
//                .register();

        factory.classMap(Product.class, ProductDTO.class)
                .field("categories.id", "categoriesId")
                .field("manufacturer.id", "manufacturerId")
                .field("user.id", "userId")
                .field("store.id", "storeId")
                .field("supplies.id", "suppliesId")
                .byDefault()
                .register();

        factory.classMap(PositionName.class, PositionNameDTO.class)
                .byDefault()
                .register();

        factory.classMap(Position.class, PositionDTO.class)
                .field("positionName.id", "positionNameId")
                .byDefault()
                .register();

        factory.classMap(Passport.class, PassportDTO.class)
                .byDefault()
                .register();

        factory.classMap(OrderHistory.class, OrderHistoryDTO.class)
                .field("user.id", "userId")
                .byDefault()
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(OrderHistory orderHistory, OrderHistoryDTO orderHistoryDTO, MappingContext context) {
                        if (orderHistory.getProductList() != null) {
                            orderHistory.getProductList().forEach(product -> {
                                product.setStore(null);
                                product.setSupplies(null);
                                product.setUser(null);
                                product.setOrderHistories(null);
                            });
                            if (orderHistoryDTO.getCustomer() != null) {
                                orderHistoryDTO.getCustomer().setOrderHistories(null);
                            }
                            orderHistoryDTO.setProductList(mapperFacade.mapAsList(orderHistory.getProductList(), ProductDTO.class));
                        }
                        if (orderHistory.getOrderProductInfos() != null) {
                            orderHistoryDTO.getOrderProductInfoDTOS().forEach(orderProductInfoDTO -> {
                                orderProductInfoDTO.setOrderHistoryId(orderHistory.getId());
                            });
                            orderHistoryDTO.setOrderProductInfoDTOS(mapperFacade.mapAsList(orderHistory.getOrderProductInfos(), OrderProductInfoDTO.class));
                        }
                        super.mapAtoB(orderHistory, orderHistoryDTO, context);
                    }

                    @Override
                    public void mapBtoA(OrderHistoryDTO orderHistoryDTO, OrderHistory orderHistory, MappingContext context) {
                        if (orderHistoryDTO.getProductList() != null) {
                            if (orderHistoryDTO.getUserId() != null) {
                                orderHistory.setUser(new User(orderHistoryDTO.getUserId()));
                            }
                            orderHistory.setDateOrder(LocalDate.now());
                            orderHistory.setProductList(mapperFacade.mapAsList(orderHistoryDTO.getProductList(), Product.class));


//                            List<OrderProductInfo> orderProductInfos = new ArrayList<>();
//                            orderHistoryDTO.getOrderProductInfoDTOS().forEach(orderProductInfoDTO -> {
//                                OrderProductInfo orderProductInfo = new OrderProductInfo();
//                                orderProductInfo.setProduct(mapperFacade.map(orderProductInfoDTO.getProduct(), Product.class));
//                                orderProductInfo.setAmount(orderProductInfoDTO.getAmount());
//                                orderProductInfo.setOrderHistory(orderHistory);
//                                orderProductInfos.add(orderProductInfo);
//
//                            });
//
//                            orderHistory.setOrderProductInfos(orderProductInfos);
                        }
                        super.mapBtoA(orderHistoryDTO, orderHistory, context);
                    }
                })
                .register();

        factory.classMap(Manufacturer.class, ManufacturerDTO.class)
                .byDefault()
                .register();

        factory.classMap(Customer.class, CustomerDTO.class)
                .byDefault()
//                .customize(new CustomMapper<>() {
//                    @Override
//                    public void mapAtoB(Customer customer, CustomerDTO customerDTO, MappingContext context) {
//                        if (customer.getOrderHistories() != null) {
//                            List<Product> products = new ArrayList<>();
//                            customer.getOrderHistories().forEach(orderHistory -> {
//                                orderHistory.getProductList().forEach(product -> {
//                                    product.setUser(null);
//                                    product.setSupplies(null);
//                                    product.setOrderHistories(null);
//                                    product.setStore(null);
//                                    products.add(product);
//                                });
//                                orderHistory.setProductList(mapperFacade.mapAsList(products, Product.class));
//                                orderHistory.setCustomer(mapperFacade.map(customer, Customer.class));
//                                products.clear();
//                            });
////                            customerDTO.getOrderHistories().forEach(orderHistoryDTO -> {
////                                orderHistoryDTO.setCustomerId(customer.getId());
////                            });
//                            customerDTO.setOrderHistories(mapperFacade.mapAsList(customer.getOrderHistories(), OrderHistoryDTO.class));
//                        }
//                        super.mapAtoB(customer, customerDTO, context);
//                    }
//
//                    @Override
//                    public void mapBtoA(CustomerDTO customerDTO, Customer customer, MappingContext context) {
//                        if (customerDTO.getOrderHistories() != null) {
//                            String idCustomer = UUID.randomUUID().toString();
//                            customerDTO.getOrderHistories().forEach(orderHistoryDTO -> {
//                                orderHistoryDTO.setCustomerId(idCustomer);
//                            });
//                            customer.setOrderHistories(mapperFacade.mapAsList(customerDTO.getOrderHistories(), OrderHistory.class));
//                            for (OrderHistory orderHistory : customer.getOrderHistories()) {
//                                orderHistory.setCustomer(new Customer());
//                            }
//                        }
//                        super.mapBtoA(customerDTO, customer, context);
//                    }
//                })
                .register();

        factory.classMap(Categories.class, CategoriesDTO.class)
                .byDefault()
                .register();

        factory.classMap(Address.class, AddressDTO.class)
                .byDefault()
                .register();

        //    TODO хуйня какая-то
        factory.classMap(OrderProductInfo.class, OrderProductInfoDTO.class)
//                .field("product.id", "productId")
                .field("orderHistory.id", "orderHistoryId")
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(OrderProductInfo orderProductInfo, OrderProductInfoDTO orderProductInfoDTO, MappingContext context) {
                        super.mapAtoB(orderProductInfo, orderProductInfoDTO, context);
                    }

                    @Override
                    public void mapBtoA(OrderProductInfoDTO orderProductInfoDTO, OrderProductInfo orderProductInfo, MappingContext context) {
                        super.mapBtoA(orderProductInfoDTO, orderProductInfo, context);
                    }
                })
                .byDefault()
                .register();
    }



}
