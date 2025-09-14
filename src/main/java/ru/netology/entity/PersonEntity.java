package ru.netology.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons", schema = "netology")
@NamedQueries({
        @NamedQuery(name = "Persons.findByCity", query = "SELECT p FROM PersonEntity p WHERE p.city_of_living = :city")
})
public class PersonEntity {

    @EmbeddedId
    private PersonProfile personProfile;

    @Column(name = "phone", nullable = false, length = 25)
    private String phone_number;

    @Column(name = "city", nullable = false, length = 30)
    private String city_of_living;
}