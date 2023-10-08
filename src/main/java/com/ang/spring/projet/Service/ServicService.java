package com.ang.spring.projet.Service;

import com.ang.spring.projet.Models.Services;

import java.util.List;

public interface ServicService {
    Services saveService(Services service);
    Services getServiceById(Long id);
    List<Services> getAllServices();
    void deleteService(Long id);
}
