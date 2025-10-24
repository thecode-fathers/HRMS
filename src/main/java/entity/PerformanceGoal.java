package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Employee employee;
    private String kpiName;
    private String description;
    private Double targetValue;
    private Double achievedValue;
    private String status;
    private LocalDate assignedDate;
    private LocalDate deadline;
    private String remarks;
}
