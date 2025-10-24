package serviceImpl;

import dto.PerformanceDTO;
import entity.Employee;
import entity.PerformanceGoal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;
import repository.PerformanceRepository;
import service.PerformanceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public PerformanceDTO createPerformanceGoal(PerformanceDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        PerformanceGoal goal = PerformanceGoal.builder()
                .employee(employee)
                .kpiName(dto.getKpiName())
                .description(dto.getDescription())
                .targetValue(dto.getTargetValue())
                .achievedValue(dto.getAchievedValue())
                .status(dto.getStatus())
                .assignedDate(dto.getAssignedDate())
                .deadline(dto.getDeadline())
                .remarks(dto.getRemarks())
                .build();

        PerformanceGoal savedGoal = performanceRepository.save(goal);
      return mapToDto(savedGoal);
    }

    @Override
    public PerformanceDTO updatePerformanceGoal(Long id, PerformanceDTO dto) {
      PerformanceGoal goal = performanceRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("Performance goals not found"));
      if(dto.getKpiName() !=null) goal.setKpiName(dto.getKpiName());
      if(dto.getDescription() != null) goal.setDescription(dto.getDescription());
      if(dto.getAchievedValue() !=null) goal.setAchievedValue(dto.getAchievedValue());
      if(dto.getTargetValue() != null) goal.setTargetValue(dto.getTargetValue());
      if(dto.getStatus() != null) goal.setStatus(dto.getStatus());
      if(dto.getAssignedDate() !=null) goal.setAssignedDate(dto.getAssignedDate());
      if(dto.getDeadline() !=null) goal.setDeadline(dto.getDeadline());
      if(dto.getRemarks() !=null) goal.setRemarks(dto.getRemarks());
      PerformanceGoal updatedGoal = performanceRepository.save(goal);
      return mapToDto(updatedGoal);
    }

    @Override
    public List<PerformanceDTO> getPerformanceByEmployee(Long employeeId) {
        List<PerformanceGoal> goals = performanceRepository.findByEmployeeId(employeeId);
        return goals.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PerformanceDTO> getAllPerformanceGoals() {
        List<PerformanceGoal> goals = performanceRepository.findAll();
        return goals.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    @Override
    public void deletePerformanceGoal(Long id) {
        PerformanceGoal goal = performanceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Performance goal not found"));
        performanceRepository.delete(goal);

    }

    private PerformanceDTO mapToDto(PerformanceGoal goal){
        return PerformanceDTO.builder()
                .id(goal.getId())
                .employee(goal.getEmployee())
                .employeeId(goal.getEmployee().getId())
                .kpiName(goal.getKpiName())
                .description(goal.getDescription())
                .achievedValue(goal.getAchievedValue())
                .targetValue(goal.getTargetValue())
                .status(goal.getStatus())
                .assignedDate(goal.getAssignedDate())
                .deadline(goal.getDeadline())
                .remarks(goal.getRemarks())
                .build();

    }
}



