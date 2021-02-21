package com.spring.controller;

import com.spring.model.User;
import com.spring.service.*;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/provider/table/product")
    public String providerTableProduct(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByUsersId(user.getId()));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAllByUserId(user.getId()));
        model.addAttribute("countAllProduct", productService.countProductByUserId(user.getId()));
        return "listProductsByProviderTable";
    }

    @GetMapping("/provider/card/product")
    public String providerCardProduct(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByUsersId(user.getId()));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAllByUserId(user.getId()));
        model.addAttribute("countAllProduct", productService.countProductByUserId(user.getId()));
        return "listProductsByProviderCard";
    }
//
    @GetMapping("/admin/providers/products")
    public String adminTableProductsProviders(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("providers", userService.findAllProvider());
        model.addAttribute("stores", storeService.findAllByIsProvide(true));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAllProductsProviders());
        model.addAttribute("countAllProduct", productService.countProductsProviders());
        return "listProductsProvidersByAdministratorTable";
    }

    @GetMapping("/admin/table/products")
    public String adminTableProducts(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("stores", storeService.findAllByIsProvide(false));
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAllProductsCompany());
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
        model.addAttribute("countAllUsers", userService.countUsers());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positionNames", positionNameService.findAll());
        model.addAttribute("employees", userService.findAllEmployee());
        return "listEmployeesByAdministratorTable";
    }

    @GetMapping("/products")
    public String allTableProducts(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("products", productService.findAllProductsCompany());
        model.addAttribute("countAllProduct", productService.countProductsCompany());
        return "listProductsByAllUser";
    }
//
//    @GetMapping("/employees/agreement")
//    public String listEmployeesByAgreement(Model model) throws TemplateModelException {
//        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
//        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
//        TemplateHashModel payments = BeansWrapper.getDefaultInstance().getEnumModels();
//        payments = (TemplateHashModel) payments.get("com.spring.model.Payment");
//        model.addAttribute("employees", employeeService.findAll());
//        model.addAttribute("subdivisions", categoriesService.findAll());
//        model.addAttribute("genders", gender);
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        model.addAttribute("agreementData", agreementDataService.findAll());
//        model.addAttribute("payments", payments);
//        return "listEmployeesByAgreement";
//    }
//
//    @GetMapping("/vacation")
//    public String listEmployeesByVacation(Model model) {
//        model.addAttribute("employees", employeeService.findAll());
//        model.addAttribute("subdivisions", categoriesService.findAll());
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        return "listEmployeesByVacation";
//    }
//
//    @GetMapping(value = "/pdf/request", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> chequeRequestReport(@AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.PDFReport(employeeService.findAll(), user, positionNameService.findAll(), categoriesService.findAll());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Отчет.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/pdf/request/agreement", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> profitReport(@AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.PDFReportAgreement(employeeService.findAll(), user, agreementDataService.findAll(), categoriesService.findAll());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Договор подряда.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
}
