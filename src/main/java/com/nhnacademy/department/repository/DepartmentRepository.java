package com.nhnacademy.department.repository;

import com.nhnacademy.department.model.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query(value = "select e.id, e.name, d.name, d.id " +
        "from department d " +
        "inner join employee e " +
        "where d.id in :departmentIds " +
        "order by d.name, e.id asc ", nativeQuery = true)
    List<Department> findAllByDepartmentIds(List<String> departmentIds);
}
