package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotEmpty(message = "Nume cannot be empty or null")
    private String nume;

    @Min(value = 1, message = "Age cannot be negative")
    @Max(value = 150, message = "You indicated too old an age")
    private int age;

}
