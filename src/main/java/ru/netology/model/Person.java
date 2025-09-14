package ru.netology.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @NotBlank(message = "Поле /Имя/ не может быть пустым")
    private String name;

    @NotBlank(message = "Поле /Фамилия/ не может быть пустым")
    private String surname;

    @Min(value = 1)
    @Max(value = 130)
    private int age;

    @NotBlank(message = "Поле /Номер телефона/ не может быть пустым")
    private String phone_number;

    @NotBlank(message = "Поле /Город/ не может быть пустым")
    private String city_of_living;
}