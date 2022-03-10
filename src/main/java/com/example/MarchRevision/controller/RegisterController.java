package com.example.MarchRevision.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;

import com.example.MarchRevision.model.Registrations;
import com.example.MarchRevision.services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    private RegistrationService regSvc;

    @PostConstruct
    public void init() {
        System.out.println("Creating Controller");
    }

    @PostMapping(path = { "", "/" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postRegister(@RequestBody MultiValueMap<String, String> form, Model model) {

        String name = form.getFirst("name");
        String email = form.getFirst("email");
        String phone = form.getFirst("phone");

        final Registrations reg = new Registrations();
        reg.setEmail(email);
        reg.setName(name);
        reg.setPhone(phone);

        model.addAttribute("newReg", reg);

        regSvc.newRegistration(reg);
        return "registered";

    }

    @GetMapping(path={"","/"})
    public String getRegistration(Model model){
        Collection<Registrations> regs = regSvc.getAllRegistrations();
        model.addAttribute("regs",regs);
        
        return "register_list";
    }
    // GET /register/name/<a name>
    // if found, return record
    // if not, return error

}
