package com.ang.spring.projet.Controller;

import com.ang.spring.projet.Models.Services;
import com.ang.spring.projet.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getAllServices")
    public List<Services> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public Services getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @PostMapping("/adds")
    public Services addService(@RequestBody Services service) {
        return serviceService.saveService(service);
    }

    @PutMapping("/update")
    public Services updateService(@RequestBody Services service) {
        return serviceService.saveService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}