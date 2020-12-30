//package com.spring.controller;
//
//import com.spring.webcontent.model.User;
//import com.spring.webcontent.report.PDFGenerator;
//import com.spring.webcontent.service.RequestService;
//import com.spring.webcontent.service.UserService;
//import freemarker.ext.beans.BeansWrapper;
//import freemarker.template.TemplateHashModel;
//import freemarker.template.TemplateModelException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.io.ByteArrayInputStream;
//
//@Controller
//public class UiController {
//    @Autowired
//    private RequestService requestService;
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/registration")
//    public String registration(Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.webcontent.model.Role");
//        model.addAttribute("roles", myRoles);
//        return "registration";
//    }
//
//    @GetMapping("/technical/requests")
//    public String requestTechnical(Model model) throws TemplateModelException {
//        TemplateHashModel status = BeansWrapper.getDefaultInstance().getEnumModels();
//        status = (TemplateHashModel) status.get("com.spring.webcontent.model.Status");
//        TemplateHashModel types = BeansWrapper.getDefaultInstance().getEnumModels();
//        types = (TemplateHashModel) types.get("com.spring.webcontent.model.Types");
//        model.addAttribute("requests", requestService.findAll());
//        model.addAttribute("status", status);
//        model.addAttribute("types", types);
//        return "listRequestByTechnical";
//    }
//
//    @GetMapping("/manager/requests")
//    public String requestManager(Model model) {
////        TemplateHashModel status = BeansWrapper.getDefaultInstance().getEnumModels();
////        status = (TemplateHashModel) status.get("com.spring.webcontent.model.Status");
////        TemplateHashModel types = BeansWrapper.getDefaultInstance().getEnumModels();
////        types = (TemplateHashModel) types.get("com.spring.webcontent.model.Types");
//        model.addAttribute("requests", requestService.getRequestsByManager());
////        model.addAttribute("status", status);
////        model.addAttribute("types", types);
//        return "listRequestByManager";
//    }
//
//    @GetMapping("/admin/requests")
//    public String requestAdmin(Model model) {
//        model.addAttribute("requests", requestService.findAll());
//        return "listRequestByAdmin";
//    }
//
//    @GetMapping("/make/request")
//    public String createRequest(Model model) throws TemplateModelException {
//        TemplateHashModel types = BeansWrapper.getDefaultInstance().getEnumModels();
//        types = (TemplateHashModel) types.get("com.spring.webcontent.model.Types");
//        model.addAttribute("types", types);
//        return "createRequest";
//    }
//
//    @GetMapping("/users")
//    public String listUsers(Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.webcontent.model.Role");
//        model.addAttribute("roles", myRoles);
//        model.addAttribute("users", userService.findAll());
//        return "usersList";
//    }
//
//    @GetMapping("/users/edit/{id}")
//    public String listUsers(@PathVariable("id") Long id, Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.webcontent.model.Role");
//        model.addAttribute("roles", myRoles);
//        model.addAttribute("user", userService.getById(id));
//        return "editUser";
//    }
//
//    @GetMapping(value = "/pdf/request/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> chequeRequestReport(@PathVariable("id") Long id, @AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.chequePDFReport(requestService.getById(id), user, userService.getById(requestService.getById(id).getUserId()));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Чек " + id + ".pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/pdf/request/profit", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> profitReport(@AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.profitPDFReport(requestService.getRequestsByManager(), user);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Общий доход.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//}
