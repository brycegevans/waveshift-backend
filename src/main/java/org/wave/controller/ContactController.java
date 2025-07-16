package org.wave.controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wave.model.Message;
import org.wave.request.MessageRequestDTO;
import org.wave.service.ActivityService;
import org.wave.service.MessageService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contact")
public class ContactController {
    private MessageService messageService;
    private ActivityService activityService;
    public ContactController(MessageService messageService, ActivityService activityService){
        this.messageService = messageService;
        this.activityService = activityService;
    }
    @GetMapping("/hello")
    public ResponseEntity <Map<String, String>> hello(HttpServletRequest request) {
        Map<String,String> response = new HashMap<>();
        activityService.sendActivity(
                request.getMethod(),
                request.getRequestURI(),
                200,
                request.getRemoteAddr(),
                request.getHeader("User-Agent")
        );
        response.put("message","Hello");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/sendMessage")
    public ResponseEntity<Message> sendMessage(@RequestBody MessageRequestDTO mRequest, HttpServletRequest request){
        Message savedMessage = messageService.createMessage(mRequest);
        activityService.sendActivity(
                request.getMethod(),
                request.getRequestURI(),
                200,
                request.getRemoteAddr(),
                request.getHeader("User-Agent")
        );
        return ResponseEntity.ok(savedMessage);
    }
}