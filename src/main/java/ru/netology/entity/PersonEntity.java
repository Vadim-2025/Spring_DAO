package ru.netology.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons", schema = "public")

public class PersonEntity {

    @EmbeddedId
    private PersonProfile personProfile;

    @Column(name = "phone_number", nullable = false, length = 25)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false, length = 30)
    private String cityOfLiving;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PersonEntity that = (PersonEntity) o;
        return getPersonProfile() != null && Objects.equals(getPersonProfile(), that.getPersonProfile());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(personProfile);
    }

    public @NotBlank(message = "Поле /Номер телефона/ не может быть пустым") String getPhoneNumber() {

        return "";
    }

    public @NotBlank(message = "Поле /Город/ не может быть пустым") String getCityOfLiving() {
        return null;
    }
}