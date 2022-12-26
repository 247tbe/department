package com.nhnacademy.department.service;

import com.nhnacademy.department.model.Department;
import com.nhnacademy.department.repository.DepartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("departmentService")
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Department> getAllByDepartmentIds(List<String> departmentIds) {
        return departmentRepository.findAllByDepartmentIds(departmentIds);
    }
}
