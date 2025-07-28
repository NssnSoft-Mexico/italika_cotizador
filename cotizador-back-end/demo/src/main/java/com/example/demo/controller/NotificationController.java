package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Notifications;
import com.example.demo.service.NotificationsService;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "*")
public class NotificationController {
    @Autowired
    private NotificationsService notificationService;

    public NotificationController(NotificationsService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendTokenId")
    public ResponseEntity<?> sendTokenId(@RequestBody Notifications notifications) {
        if (notificationService.existsByTokenId(notifications.getTokenId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El token ya fue registrado.");
        }

        Notifications saved = notificationService.sendTokenId(notifications);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/getTokenId")
    public ResponseEntity<?> getTokenId() {
        return ResponseEntity.ok(notificationService.getTokenId());
    }
}