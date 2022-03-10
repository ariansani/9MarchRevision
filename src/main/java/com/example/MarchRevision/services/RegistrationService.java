package com.example.MarchRevision.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.MarchRevision.model.Registrations;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private Map<String, Registrations> regs = new HashMap<>();
    
    public RegistrationService(){

        //insert some fake data
        Registrations r = new Registrations();
        r.setEmail("arian@a.com");
        r.setName("arian");
        r.setPhone("12345");
        newRegistration(r);

        Registrations r2 = new Registrations();
        r2.setEmail("lala@lala.com");
        r2.setName("lala");
        r2.setPhone("1241254");
        newRegistration(r2);
    }

    public void newRegistration(final Registrations reg){
        regs.put(reg.getName(),reg);
    }

    public Collection<Registrations> getAllRegistrations(){
        return regs.values();
    } 

    public Collection<String> getAllRegisteredNames(){
        return regs.keySet();
    }

    public Registrations getUserByName(String name){
        //Issue here!!
        return regs.get(name);
    }

}
