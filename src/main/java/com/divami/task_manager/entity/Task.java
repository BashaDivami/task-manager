package com.divami.task_manager.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task extends BaseAudit {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String summary;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false;
}


