package com.spartaglobal.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeesTest {

    @Test
    public void testEquals_Symmetric() {
        Employees x = new Employees(123);  // equals and hashCode check name field value
        Employees y = new Employees(123);
        assertTrue(x.equals(y) && y.equals(x));
        assertTrue(x.hashCode() == y.hashCode());
    }


}