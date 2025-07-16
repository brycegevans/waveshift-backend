package org.wave.service;

import jakarta.persistence.Column;
import org.springframework.stereotype.Service;
import org.wave.model.Activity;
import org.wave.repo.ActivityRepository;
import org.wave.repo.AppConfigRepository;

import java.time.LocalDateTime;


@Service
public class ActivityService {
    private ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    public void sendActivity(String method, String endpoint, int statusCode,String ipAddress, String userAgent){
        Activity log = new Activity();
        log.setMethod(method);
        log.setEndpoint(endpoint);
        log.setStatusCode(statusCode);
        log.setIpAddress(ipAddress);
        log.setUserAgent(userAgent);
        log.setTimestamp(LocalDateTime.now());
        activityRepository.save(log);
    }
}
