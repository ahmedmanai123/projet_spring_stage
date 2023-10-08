package com.ang.spring.projet.Service;

import com.ang.spring.projet.Models.Services;
import com.ang.spring.projet.Repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceService implements ServicService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Services getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Services saveService(Services service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
