package com.project.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.stereotype.Indexed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.fitness.model.ActivityType;

import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="json")
    private Map<String ,Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    @CreationTimestamp
     private LocalDateTime createdAt;

     @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false,foreignKey=@ForeignKey(name="fk_activity_user"))
    @JsonIgnore
    private User user;

@OneToMany(mappedBy="activity", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<Recommendation> recommendations=new ArrayList<>();
}
