package com.spring.controller;

import com.spring.DTO.ProductDTO;
import com.spring.model.Product;
import com.spring.model.User;
import com.spring.report.PDFGenerator;
import com.spring.service.*;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UiController {
    private final UserService userService;
    private final AddressService addressService;
    private final PositionService positionService;
    private final CategoriesService categoriesService;
    private final ProductService productService;
    private final PositionNameService positionNameService;
    private final SubdivisionService subdivisionService;
    private final StoreService storeService;
    private final ManufacturerService manufacturerService;
    private final OrderHistoryService orderHistoryService;

    //
//
    @GetMapping("/registration")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        model.addAttribute("roles", myRoles);
        return "registration";
    }

    @GetMapping("/login")
    public String login(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
        model.addAttribute("roles", myRoles);
        model.addAttribute("user", userService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positionNames", positionNameService.findAll());
        return "login";
    }

    @GetMapping("/users")
    public String listUsers(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        model.addAttribute("roles", myRoles);
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    //
    @GetMapping("/users/edit/{id}")
    public String listUsers(@PathVariable("id") Long id, Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        model.addAttribute("roles", myRoles);
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

//    @GetMapping("/provider/table/product")
//    public String providerTableProduct(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("stores", storeService.findAllByUsersId(user.getId()));
//        model.addAttribute("categories", categoriesService.findAll());
//        model.addAttribute("manufacturer", manufacturerService.findAll());
//        model.addAttribute("products", productService.findAllByUserId(user.getId()));
//        model.addAttribute("countAllProduct", productService.countProductByUserId(user.getId()));
//        return "listProductsByProviderTable";
//    }

    @GetMapping("/provider/table/product")
    public String providerTableProductByParams(@AuthenticationPrincipal User user, Model model,
                                               @RequestParam(name = "store_id", defaultValue = "0") Long store_id,
                                               @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                               @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                               @RequestParam(name = "name", defaultValue = "") String nameProduct) {

        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByUsersId(user.getId()));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findByParams(null, user, store_id, manufacturer_id, categories_id, nameProduct));
        model.addAttribute("countAllProduct", productService.countProductByUserId(user.getId()));
        return "listProductsByProviderTable";
    }

    @GetMapping("/provider/card/product")
    public String providerCardProduct(@AuthenticationPrincipal User user, Model model,
                                      @RequestParam(name = "store_id", defaultValue = "0") Long store_id,
                                      @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                      @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                      @RequestParam(name = "name", defaultValue = "") String nameProduct) {
//        ProductDTO product = productService.getById(1L);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new ByteArrayInputStream(product.getImage()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String base64image = Base64.getEncoder().encodeToString(product.getImage());

//        List<ProductDTO> productDTOS = productService.findByParams(null, user, store_id, manufacturer_id, categories_id, nameProduct);
//        productDTOS = productService.convertImage(productDTOS);
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByUsersId(user.getId()));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());

        model.addAttribute("products", productService.findByParams(null, user, store_id, manufacturer_id, categories_id, nameProduct));
//        model.addAttribute("test", base64image);
        model.addAttribute("countAllProduct", productService.countProductByUserId(user.getId()));
        return "listProductsByProviderCard";
    }

    //
    @GetMapping("/admin/providers/products")
    public String adminTableProductsProviders(@AuthenticationPrincipal User user, Model model,
                                              @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                              @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                              @RequestParam(name = "provider_id", defaultValue = "") Long providers_id,
                                              @RequestParam(name = "name", defaultValue = "") String nameProduct) {
        model.addAttribute("user", user);
        model.addAttribute("providers", userService.findAllProvider());
        model.addAttribute("stores", storeService.findAllByIsProvide(true));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findByParams(productService.findAllProductsProviders(), new User(providers_id), 0L, manufacturer_id, categories_id, nameProduct));
        model.addAttribute("countAllProduct", productService.countProductsProviders());
        return "listProductsProvidersByAdministratorTable";
    }

    @GetMapping("/admin/table/products")
    public String adminTableProducts(@AuthenticationPrincipal User user, Model model,
                                     @RequestParam(name = "store_id", defaultValue = "0") Long store_id,
                                     @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                     @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                     @RequestParam(name = "name", defaultValue = "") String nameProduct) {
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByIsProvide(false));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findByParams(productService.findAllProductsCompany(), null, store_id, manufacturer_id, categories_id, nameProduct));
        model.addAttribute("countAllProduct", productService.countProductsCompany());
        return "listProductsByAdministratorTable";
    }

    @GetMapping("/admin/employees")
    public String adminTableEmployees(@AuthenticationPrincipal User user, Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByIsProvide(false));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("countAllProduct", productService.count());
        model.addAttribute("countAllUsers", productService.count());
        model.addAttribute("roles", myRoles);
        model.addAttribute("countAllUsers", userService.findAllEmployee().size());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positionNames", positionNameService.findAll());
        model.addAttribute("employees", userService.findAllEmployee());
        return "listEmployeesByAdministratorTable";
    }

    @GetMapping("/admin/customers")
    public String adminTableCustomer(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("employees", userService.findAllCustomer());
        model.addAttribute("countCustomer", userService.findAllCustomer().size());
        return "listCustomerByAdministratorTable";
    }

    @GetMapping("/admin/order/histories")
    public String adminTableOrders(@AuthenticationPrincipal User user, Model model) throws TemplateModelException {
        TemplateHashModel statuses = BeansWrapper.getDefaultInstance().getEnumModels();
        statuses = (TemplateHashModel) statuses.get("com.spring.model.Status");
        model.addAttribute("user", user);
        model.addAttribute("users", userService.findAllCustomer());
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("statuses", statuses);
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("orderHistories", orderHistoryService.getListByCustomer());
        model.addAttribute("countOrder", orderHistoryService.getListByCustomer().size());
        return "listOrderHistoryByAdministratorTable";
    }

    @GetMapping("/admin/products/deliveries")
    public String adminTableDeliveries(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "listDeliveriesByAdministratorTable";
    }

    @GetMapping("/admin/products/deliveries/order")
    public String adminTableDeliveriesOrder(@AuthenticationPrincipal User user, Model model) throws TemplateModelException {
        TemplateHashModel statuses = BeansWrapper.getDefaultInstance().getEnumModels();
        statuses = (TemplateHashModel) statuses.get("com.spring.model.Status");
        model.addAttribute("user", user);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stores", storeService.findAllByIsProvide(false));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("statuses", statuses);
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("orderHistories", orderHistoryService.getListByProvider());
        model.addAttribute("countOrder", orderHistoryService.getListByProvider().size());
        return "listProductsProvidersOrderByAdministratorTable";
    }

    @GetMapping("/products")
    public String allTableProducts(@AuthenticationPrincipal User user, Model model,
                                   @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                   @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                   @RequestParam(name = "name", defaultValue = "") String nameProduct) {

        model.addAttribute("user", user);
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findByParams(productService.findAllProductsCompany(), null, 0L, manufacturer_id, categories_id, nameProduct));
        model.addAttribute("countAllProduct", productService.countProductsCompany());
        return "listProductsByAllUser";
    }

    @GetMapping("/products/basket")
    public String allProductsInBasket(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        return "listProductsByCustomerBasket";
    }

//    TODO часть продавца
    @GetMapping("/seller/table/products")
    public String sellerTableProducts(@AuthenticationPrincipal User user, Model model,
                                     @RequestParam(name = "store_id", defaultValue = "0") Long store_id,
                                     @RequestParam(name = "manufacturer_id", defaultValue = "0") Long manufacturer_id,
                                     @RequestParam(name = "categories_id", defaultValue = "0") Long categories_id,
                                     @RequestParam(name = "name", defaultValue = "") String nameProduct) {
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByIsProvide(false));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findByParams(productService.findAllProductsCompany(), null, store_id, manufacturer_id, categories_id, nameProduct));
        model.addAttribute("countAllProduct", productService.countProductsCompany());
        return "listProductsBySellerTable";
    }

    @GetMapping(value = "/pdf/request/sales", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> reportSales(@AuthenticationPrincipal User user){
        PDFGenerator pdfGenerator = new PDFGenerator();
        ByteArrayInputStream bis = pdfGenerator.PDFReportSales(orderHistoryService.getListByCustomer(), user, storeService.findAll(),
                manufacturerService.findAll(), categoriesService.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Отчет.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
//
    @GetMapping(value = "/pdf/request/users", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> profitReport(@AuthenticationPrincipal User user){
        PDFGenerator pdfGenerator = new PDFGenerator();
        ByteArrayInputStream bis = pdfGenerator.PDFReport(user, userService.findAllEmployee(), positionNameService.findAll(), subdivisionService.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Отчет по сотрудникам.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
