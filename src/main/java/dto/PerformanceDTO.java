package dto;

import entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerformanceDTO {
    private Long id;
    private Long employeeId;
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
