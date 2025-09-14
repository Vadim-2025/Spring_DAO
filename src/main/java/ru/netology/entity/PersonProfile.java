package ru.netology.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PersonProfile implements Serializable {

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 25)
    private String surname;

    private int age;
}