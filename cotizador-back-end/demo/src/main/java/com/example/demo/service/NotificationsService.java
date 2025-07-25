package com.example.demo.service;

import com.example.demo.model.Notifications;
import com.example.demo.repository.NotificationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public Notifications sendTokenId(Notifications notifications) {
        return notificationsRepository.save(notifications);
    }

    public boolean existsByTokenId(String tokenId) {
        return notificationsRepository.existsByTokenId(tokenId);
    }
}