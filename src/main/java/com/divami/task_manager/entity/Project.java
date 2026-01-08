package com.divami.task_manager.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;


@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
     //	to mark it as primary key
	 @Id 
	 @GeneratedValue(strategy = GenerationType.UUID)
	 @Column(name = "id", nullable = false) 
	 private UUID id;
	 
	 @Column(length = 1000,nullable = false) 
	 private String name;
	 
	  @Column(length = 1000) 
	  private String description;


}
