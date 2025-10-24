package service;

import dto.PerformanceDTO;

import java.util.List;

public interface PerformanceService {
    PerformanceDTO createPerformanceGoal(PerformanceDTO dto);
    PerformanceDTO updatePerformanceGoal(Long id,PerformanceDTO dto);
    List<PerformanceDTO> getPerformanceByEmployee(Long employeeId);
    List<PerformanceDTO> getAllPerformanceGoals();
    void deletePerformanceGoal(Long id);
}
