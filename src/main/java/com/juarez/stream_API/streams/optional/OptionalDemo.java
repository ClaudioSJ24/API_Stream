package com.juarez.stream_API.streams.optional;

import java.security.SecureRandom;
import java.util.Optional;

public class OptionalDemo {

    record Employee(
            String name,
            String email
    ){}

    record Email(
            String address
    ){}

    static Optional<Email> findEmail(Employee employee){

        if (employee.email() == null || employee.email().isBlank() ) {

            return Optional.empty();
        }

        return Optional.of(new Email(employee.email()));
    }

    public static void main(String[] args) {
        Optional<Employee> employeeOpt =
                Optional.of(new Employee("John", "john@example.com"));



    }


}
