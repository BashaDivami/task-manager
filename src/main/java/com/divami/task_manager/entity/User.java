package com.divami.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseAudit {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(nullable = false, updatable = false)
   private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean active = true;


   
}
