package org.wave.service;

import org.springframework.stereotype.Service;
import org.wave.repo.AppConfigRepository;
import org.wave.repo.EmployeeRepository;
import org.wave.response.AppConfigResponseDTO;
import org.wave.response.EmployeeResponseDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class HomeService {
    private final EmployeeRepository employeeRepo;
    private final AppConfigRepository appConfigRepo;
    public HomeService(EmployeeRepository employeeRepo, AppConfigRepository appConfigRepo){
        this.employeeRepo= employeeRepo;
        this.appConfigRepo = appConfigRepo;
    }
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<EmployeeResponseDTO> employees = employeeRepo.findAll().stream().map(
                employee -> new EmployeeResponseDTO(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getTitle(),
                employee.getJobDescription()
        )).collect(Collectors.toList());
        return employees;
    }
    public List<AppConfigResponseDTO> getAllConfigs(){
        List<AppConfigResponseDTO> configs = appConfigRepo.findAll().stream().map(appConfig ->
                new AppConfigResponseDTO(appConfig.getKey(),appConfig.getValue())).collect(Collectors.toList());
        return configs;
    }
}
