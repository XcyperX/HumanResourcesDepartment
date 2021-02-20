package com.spring.mapper;

import com.spring.DTO.*;
import com.spring.model.*;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
//                            storeDTO.setUsers(mapperFacade.mapAsList(store.getUsers(), UserDTO.class));
                        }
                        if (store.getProducts() != null) {
                            storeDTO.setProducts(mapperFacade.mapAsList(store.getProducts(), ProductDTO.class));
                        }
//                        store.setProducts(mapperFacade.mapAsList(storeDTO.getProducts(), Product.class));
//                        List<UserDTO> userDTOS = new ArrayList<>();
//                        storeDTO.getUsers().forEach(userDTO -> {
//                            userDTO.setStores(null);
//                            userDTOS.add(userDTO);
//                        });
//                        store.setUsers(mapperFacade.mapAsList(storeDTO.getUsers(), User.class));
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
//                        storeDTO.setProducts(mapperFacade.mapAsList(storeDTO.getProducts(), ProductDTO.class));
//                        storeDTO.setUsers(mapperFacade.mapAsList(storeDTO.getUsers(), UserDTO.class));
//                        if (!store.getUsers().isEmpty()) {
//                            List<User> users = new ArrayList<>();
//                            store.getUsers().forEach(user -> {
//                                user.setStores(null);
//                                users.add(user);
//                            });
//                            storeDTO.setUsers(mapperFacade.mapAsList(users, UserDTO.class));
//                        }
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
//                        List<Store> stores = new ArrayList<>();
//                        if (user.getStores() != null) {
//                            user.getStores().forEach(store -> {
//                                store.setUsers(null);
//                                stores.add(store);
//                            });
//                        }
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

        factory.classMap(Status.class, StatusDTO.class)
                .byDefault()
                .register();

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
                .field("customer.id", "customerId")
                .field("user.id", "userId")
                .field("status.id", "statusId")
                .byDefault()
                .register();

        factory.classMap(Manufacturer.class, ManufacturerDTO.class)
                .byDefault()
                .register();

        factory.classMap(Customer.class, CustomerDTO.class)
                .byDefault()
                .register();

        factory.classMap(Categories.class, CategoriesDTO.class)
                .byDefault()
                .register();

        factory.classMap(Address.class, AddressDTO.class)
                .byDefault()
                .register();
    }
}
