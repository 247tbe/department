package com.nhnacademy.department.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nhnacademy.department.model.Department;
import com.nhnacademy.department.service.DepartmentService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DepartmentRestController.class)
class DepartmentRestControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    DepartmentService departmentService;

    @Test
    @DisplayName("getDepartments() - Http Status : 200")
    void test1() throws Exception {
        given(departmentService.getDepartments())
            .willReturn(
                List.of(
                    new Department("L1001", "backend-1"),
                    new Department("L1002", "backend-2"),
                    new Department("L1003", "backend-3"),
                    new Department("L1004", "backend-4"),
                    new Department("L1005", "backend-5")
                )
            );

        // when .. then ..
        mvc.perform(get("/departments"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[2].id", equalTo("L1003")));
    }

    @Test
    @DisplayName("There are departmentIds - Http Status : 200")
    void test2() throws Exception {
        // given
        List<String> departmentIds = new ArrayList<>();
        departmentIds.add("L1001");
        departmentIds.add("L1002");

        // when .. then ..
        mvc.perform(get("/department-members?departmentIds=" + departmentIds.get(0) + ", " +
                departmentIds.get(1)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("No input departmentIds - Http Status : 400")
    void test3() throws Exception {
        mvc.perform(get("/department-members?departmentIds="))
            .andExpect(status().isBadRequest());
    }

}