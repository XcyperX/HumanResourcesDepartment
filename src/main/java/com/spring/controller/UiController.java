package com.spring.controller;

import com.spring.model.User;
import com.spring.report.PDFGenerator;
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
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private SubdivisionService subdivisionService;
//    @Autowired
//    private StatusService statusService;
    @Autowired
    private PositionNameService positionNameService;


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

    @GetMapping("/users/edit/{id}")
    public String listUsers(@PathVariable("id") Long id, Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
        model.addAttribute("roles", myRoles);
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) throws TemplateModelException {
        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("positionsNames", positionNameService.findAll());
        return "listEmployeesByAll";
    }

//    @GetMapping("/employees/{id}")
//    public String editEmployee(@PathVariable("id") Long id, Model model) throws TemplateModelException {
//        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
//        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
//        model.addAttribute("employees", employeeService.getById(id));
//        model.addAttribute("subdivisions", subdivisionService.findAll());
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("genders", gender);
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        return "employeesEdit";
//    }

    @GetMapping("/employees/subdivisions")
    public String listEmployeesBySubdivision(Model model) throws TemplateModelException {
        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positionsNames", positionNameService.findAll());
        return "listEmployeesBySubdivision";
    }

    @GetMapping("/employees/position")
    public String listEmployeesByPosition(Model model) throws TemplateModelException {
        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("genders", gender);
        model.addAttribute("positionsNames", positionNameService.findAll());
        return "listEmployeesByPosition";
    }

    @GetMapping("/vacation")
    public String listEmployeesByVacation(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("subdivisions", subdivisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("positionsNames", positionNameService.findAll());
        return "listEmployeesByVacation";
    }

//    @GetMapping("/employees/vacation/{id}")
//    public String editEmployeeVacation(@PathVariable("id") Long id, Model model) throws TemplateModelException {
//        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
//        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
//        model.addAttribute("employees", employeeService.getById(id));
//        model.addAttribute("subdivisions", subdivisionService.findAll());
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("genders", gender);
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        return "employeesEditByVacation";
//    }

    @GetMapping(value = "/pdf/request", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> chequeRequestReport(@AuthenticationPrincipal User user){
        PDFGenerator pdfGenerator = new PDFGenerator();
        ByteArrayInputStream bis = pdfGenerator.PDFReport(employeeService.findAll(), user, positionNameService.findAll(), subdivisionService.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Отчет.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
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
}
