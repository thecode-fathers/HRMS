package controller;

import dto.PerformanceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PerformanceService;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping("/add")
    public ResponseEntity<PerformanceDTO> addPerformance(@RequestBody PerformanceDTO dto) {
        return ResponseEntity.ok(performanceService.createPerformanceGoal(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerformanceDTO> update(@PathVariable Long id, @RequestBody PerformanceDTO dto) {
        return ResponseEntity.ok(performanceService.updatePerformanceGoal(id, dto));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PerformanceDTO>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(performanceService.getPerformanceByEmployee(employeeId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PerformanceDTO>> getAll() {
        return ResponseEntity.ok(performanceService.getAllPerformanceGoals());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        performanceService.deletePerformanceGoal(id);
        return ResponseEntity.noContent().build();
    }
}
