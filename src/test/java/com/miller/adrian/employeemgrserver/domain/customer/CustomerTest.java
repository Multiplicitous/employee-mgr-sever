package com.miller.adrian.employeemgrserver.domain.customer;

import com.miller.adrian.employeemgrserver.domain.customer.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CustomerTest {
    @Test
    public void ConstructorTest() {
        // given
        Customer customer = new Customer("Test", "User", "abs@mail");
        customer.setId(1L);
        // when
        String expected = "Customer{id=1, firstName='Test', lastName='User', email='abs@mail'}";
        String actual = customer.toString();
        // then
        Assertions.assertEquals(expected, actual);
    }
}
