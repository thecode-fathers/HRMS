package repository;

import entity.PerformanceGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<PerformanceGoal,Long> {

    List<PerformanceGoal> findByEmployeeId(long employeeId);
}
