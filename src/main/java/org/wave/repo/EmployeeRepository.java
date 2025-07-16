package org.wave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.wave.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT first_name, last_name, id, email, title, job_description FROM employee", nativeQuery = true)
    List<Object[]> findRawEmployees();
}