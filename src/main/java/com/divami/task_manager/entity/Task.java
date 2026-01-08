package com.divami.task_manager.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String summary;

    @Column(columnDefinition = "text")
    private String description;

    @Builder.Default
    @Column(nullable = false)
    private Boolean is_completed = false;
}


