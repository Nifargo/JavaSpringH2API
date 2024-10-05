package org.example.apitests.baseSpec.controller;

import org.example.model.Car;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import java.util.List;

public class UserData {

    public static Stream<Arguments> userData() {
        return Stream.of(
                Arguments.of(
                        "John Doe",
                        "john.doe@example.com",
                        List.of(new Car("Model S", "Tesla")) // Список об'єктів Car
                ),
                Arguments.of(
                        "Jane Smith",
                        "jane.smith@example.com",
                        List.of(new Car("Civic", "Honda"))
                ),
                Arguments.of(
                        "Alice Johnson",
                        "alice.johnson@example.com",
                        List.of(new Car("Corolla", "Toyota"))
                )
        );
    }
}
