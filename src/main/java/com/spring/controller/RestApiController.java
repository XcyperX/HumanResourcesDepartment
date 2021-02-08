package com.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.DTO.*;
import com.spring.service.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TablesService tablesService;
    @Autowired
    private OrderHistoryService orderHistoryService;
    //    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private AddressService addressService;
//    @Autowired
//    private PositionService positionService;
    @Autowired
    private CategoriesService categoriesService;
//    @Autowired
//    private AgreementDataService agreementDataService;
//    @Autowired
//    private PositionNameService positionNameService;

    @Value("${upload.path}")
    private String uploadPath;

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
            String resucltFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resucltFileName));
            product.setUrlPhoto(resucltFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productService.save(product);
    }


    @PostMapping("/status")
    public StatusDTO createService(@RequestBody @Valid StatusDTO statusDTO) {
        return statusService.save(statusDTO);
    }

    @PostMapping("/tables")
    public TablesDTO createTable(@RequestBody @Valid TablesDTO tablesDTO) {
        return tablesService.save(tablesDTO);
    }


    //    @PostMapping("/positions/names")
//    public PositionNameDTO createPositionName(@RequestBody @Valid PositionNameDTO positionNameDTO) {
//        return positionNameService.save(positionNameDTO);
//    }
//
    @PostMapping("/categories")
    public CategoriesDTO createCategories(@RequestBody @Valid CategoriesDTO categoriesDTO) {
        return categoriesService.save(categoriesDTO);
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
//
//    @PostMapping("/employees")
//    public ProductDTO createEmployee(@RequestBody @Valid ProductDTO productDTO) {
//        return employeeService.save(productDTO);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ProductDTO createEmployee(@PathVariable("id") Long id, @RequestBody @Valid ProductDTO productDTO) {
//        productDTO.setId(id);
//        return employeeService.update(productDTO);
//    }
//
//    @PutMapping("/employees/vacation/{id}")
//    public ProductDTO updateEmployeeVacation(@PathVariable("id") Long id, @RequestBody @Valid VacationDateDTO vacationDateDTO) {
//        return employeeService.updateVacationEmployeeById(id, vacationDateDTO);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public void deleteEmployee(@PathVariable("id") Long id) {
//        employeeService.delete(id);
//    }
//
//    @GetMapping("/get/employee/{id}")
//    public ResponseEntity<?> getRequestById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(employeeService.getById(id));
//    }
//
//    @PostMapping("/agreements")
//    public AgreementDataDTO createAgreement(@RequestBody @Valid AgreementDataDTO agreementDataDTO) {
//        return agreementDataService.save(agreementDataDTO);
//    }
//
//    @DeleteMapping("/employees/agreement/{id}")
//    public void deleteEmployeeAgreement(@PathVariable("id") Long id) {
//        employeeService.delete(id);
//    }
}
