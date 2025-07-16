package org.wave.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wave.response.AppConfigResponseDTO;
import org.wave.model.Employee;
import org.wave.response.EmployeeResponseDTO;
import org.wave.service.ActivityService;
import org.wave.service.HomeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hero")
public class HomeController {

    private HomeService homeService;
    private ActivityService activityService;
    public HomeController(HomeService homeService, ActivityService activityService){
        this.activityService = activityService;
        this.homeService = homeService;
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployees(HttpServletRequest request){
        List<EmployeeResponseDTO> responseList = homeService.getAllEmployees();
        activityService.sendActivity(
                request.getMethod(),
                request.getRequestURI(),
                200,
                request.getRemoteAddr(),
                request.getHeader("User-Agent")
        );
        return ResponseEntity.ok(responseList);
    }
    @GetMapping("/getConfiguration")
    public ResponseEntity<List<AppConfigResponseDTO>> getAppConfig(HttpServletRequest request){
       List<AppConfigResponseDTO> list = homeService.getAllConfigs();
        activityService.sendActivity(
                request.getMethod(),
                request.getRequestURI(),
                200,
                request.getRemoteAddr(),
                request.getHeader("User-Agent")
        );
        return ResponseEntity.ok(list);

    }

}
