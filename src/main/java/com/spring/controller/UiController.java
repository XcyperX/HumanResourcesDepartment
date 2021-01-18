package com.spring.controller;

import com.spring.model.User;
import com.spring.service.*;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;

@Controller
public class UiController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductService productService;
//
//
    @GetMapping("/registration")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        model.addAttribute("roles", myRoles);
        return "registration";
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
//
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("listProducts", productService.findAll());
        return "listProductsByGuest";
    }

    @GetMapping("/admin/products")
    public String listProductsByAdmin(Model model) {
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("listProducts", productService.findAll());
        return "listProductsByAdministrator";
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
