package com.nhnacademy.department.service;

import com.nhnacademy.department.model.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    List<Department> getAllByDepartmentIds(List<String> departmentIds);
}
