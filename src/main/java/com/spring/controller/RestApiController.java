package com.spring.controller;

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

    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody @Valid ProductDTO productDTO) throws IOException {
        if (productDTO.getUrlPhoto() != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            List<String> list = Arrays.asList(productDTO.getUrlPhoto().replace("\\", "/").split("/"));
            File is = productDTO.getImagePhoto();
            File os = new File(uploadPath + "/" + uuidFile + list.get(list.size() - 1));
            try {
                FileCopyUtils.copy(is, os);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(path);
//            File fileStock = new File(path);
//
//            File fileResult = new File(uploadPath + "/" + uuidFile + list.get(list.size() - 1));
//            try {
//                FileCopyUtils.copy(fileStock, fileResult);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            productDTO.setUrlPhoto(uuidFile + list.get(list.size() - 1));
            System.out.println("Все гуд");
        }
        return productService.save(productDTO);
    }

    @PostMapping("/test/file")
    public void createFile(@RequestParam("url_photo") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
        }
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
