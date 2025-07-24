package com.example.demo.repository;
import com.example.demo.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    boolean existsByTokenId(String nombre);
}
