package com.nhnacademy.department.controller;

import com.nhnacademy.department.exception.RequestParameterNotFoundException;
import com.nhnacademy.department.model.Department;
import com.nhnacademy.department.service.DepartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/department-members")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Department> getAllByDepartmentIds(
        @RequestParam("departmentIds") List<String> departmentIds) {
        if (departmentIds.isEmpty()) {
            throw new RequestParameterNotFoundException();
        }
        return departmentService.getAllByDepartmentIds(departmentIds);
    }

}
