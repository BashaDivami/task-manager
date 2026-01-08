package com.divami.task_manager.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   private String password;
   private Boolean is_active = true;
   @Column(name = "created_at")
   private LocalDateTime createdAt;
   public Long getId() {
       return id;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getEmail() {
       return email;
   }
   public void setEmail(String email) {
       this.email = email;
   }
   public Boolean getActive() {
       return is_active;
   }
   public void setActive(Boolean active) {
       this.is_active = active;
   }
   public String getPassword() {
       return password;
   }
   public void setPassword(String password) {
       this.password = password;
   }
   public LocalDateTime getCreatedAt() {
       return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
       this.createdAt = createdAt;
   }
}

