package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.DTO.*;
import com.spring.repository.SubdivisionRepository;
import com.spring.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestApiController {
    private final UserService userService;
    private final ProductService productService;
    private final SuppliesService suppliesService;
    private final OrderHistoryService orderHistoryService;
    private final AddressService addressService;
    private final PositionService positionService;
    private final CategoriesService categoriesService;
    private final PositionNameService positionNameService;
    private final SubdivisionService subdivisionService;
    private final StoreService storeService;
    private final ManufacturerService manufacturerService;
    private final CustomerService customerService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/get/price/basket")
    public ResponseEntity<Float> getPriceBasket(@RequestParam List<String> products_id) {
        return ResponseEntity.ok(productService.getPriceProducts(products_id));
    }

    @PostMapping("/registrations")
    public UserDTO registrationUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return userService.update(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping(value = "/product/image", consumes = {"multipart/form-data"})
    public ProductDTO createProduct(String productDTO, @RequestParam("file_test") MultipartFile file) {
        ProductDTO product = null;
        try {
            product = new ObjectMapper().readValue(productDTO, ProductDTO.class);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setUrlPhoto(resultFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productService.save(product);
    }

    @PutMapping(value = "/product/image/{id}", consumes = {"multipart/form-data"})
    public ProductDTO updateProduct(@PathVariable("id") Long id, String productDTO, @RequestParam("file_test") MultipartFile file) {
        ProductDTO product = null;
        try {
            product = new ObjectMapper().readValue(productDTO, ProductDTO.class);
            product.setId(id);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setUrlPhoto(resultFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productService.update(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }


//    @PostMapping("/status")
//    public StatusDTO createService(@RequestBody @Valid StatusDTO statusDTO) {
//        return statusService.save(statusDTO);
//    }

    @PostMapping("/tables")
    public SuppliesDTO createTable(@RequestBody @Valid SuppliesDTO suppliesDTO) {
        return suppliesService.save(suppliesDTO);
    }

    @PostMapping("/categories")
    public CategoriesDTO createCategories(@RequestBody @Valid CategoriesDTO categoriesDTO) {
        return categoriesService.save(categoriesDTO);
    }

    @PostMapping("/manufacturers")
    public ManufacturerDTO createManufacturers(@RequestBody @Valid ManufacturerDTO manufacturerDTO) {
        return manufacturerService.save(manufacturerDTO);
    }

    @PostMapping("/order/history")
    public OrderHistoryDTO createOrderHistory(@RequestBody @Valid OrderHistoryDTO orderHistoryDTO) {
        return orderHistoryService.save(orderHistoryDTO);
    }

    @GetMapping("/order/history/{id}")
    public ResponseEntity<?> getOrderHistory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderHistoryService.getById(id));
    }

    @GetMapping("/order/history")
    public ResponseEntity<?> getOrderHistory() {
        return ResponseEntity.ok(orderHistoryService.findAll());
    }

    @PostMapping("/positions/names")
    public PositionNameDTO createPositionName(@RequestBody @Valid PositionNameDTO positionNameDTO) {
        return positionNameService.save(positionNameDTO);
    }

    @PostMapping("/subdivisions")
    public SubdivisionDTO createSubdivision(@RequestBody @Valid SubdivisionDTO subdivisionDTO) {
        return subdivisionService.save(subdivisionDTO);
    }

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PostMapping("/store")
    public StoreDTO createStore(@RequestBody @Valid StoreDTO storeDTO) {
        return storeService.save(storeDTO);
    }

    @PutMapping("/store/{id}")
    public StoreDTO updateStore(@PathVariable("id") Long id, @RequestBody StoreDTO storeDTO) {
        storeDTO.setId(id);
        return storeService.update(storeDTO);
    }

    @GetMapping("/store")
    public ResponseEntity<?> getStore() {
        return ResponseEntity.ok(storeService.findAll());
    }

    @GetMapping("/customer/order")
    public ResponseEntity<?> getAllOrder() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/customer/order")
    public CustomerDTO createOrder(@RequestBody @Valid CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PostMapping("/new/customer/order")
    public OrderHistoryDTO createOrderCustomer(@RequestBody @Valid OrderHistoryDTO orderHistoryDTO) {
        return orderHistoryService.save(orderHistoryDTO);
    }

    @GetMapping("/new/customer/order")
    public ResponseEntity<?> getAllOrderCustomer() {
        return ResponseEntity.ok(orderHistoryService.findAll());
    }

}
