package com.miller.adrian.employeemgrserver.domain.employee;

import com.miller.adrian.employeemgrserver.domain.employee.models.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTest {


    @Test
    @DisplayName("Employee Lombak Constructor Test")
    public void employeeTest(){
        // Given
            Employee employee = new Employee("Test", "User", "Testuser@gmail.com");
            employee.setId(1L);
        // When
            String expected = "1 Test User Testuser@gmail.com";
            String actual = employee.toString();
        // then
            Assertions.assertEquals(expected, actual);
    }
}
