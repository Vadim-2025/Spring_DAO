package ru.netology.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotBlank(message = "Поле /Имя/ не может быть пустым")
    private String name;

    @NotBlank(message = "Поле /Фамилия/ не может быть пустым")
    private String surname;

    @Min(value = 1)
    @Max(value = 130)
    private int age;

    @NotBlank(message = "Поле /Номер телефона/ не может быть пустым")
    private String phoneNumber;

    @NotBlank(message = "Поле /Город/ не может быть пустым")
    private String cityOfLiving;

    public @NotBlank(message = "Поле /Имя/ не может быть пустым") String getName() {
        return this.name;
    }

    public @NotBlank(message = "Поле /Фамилия/ не может быть пустым") String getSurname() {
        return this.surname;
    }

    public @Min(value = 1) @Max(value = 130) int getAge() {
        return this.age;
    }

    public @NotBlank(message = "Поле /Номер телефона/ не может быть пустым") String getPhoneNumber() {
        return this.phoneNumber;
    }

    public @NotBlank(message = "Поле /Город/ не может быть пустым") String getCityOfLiving() {
        return this.cityOfLiving;
    }

    public void setName(@NotBlank(message = "Поле /Имя/ не может быть пустым") String name) {
        this.name = name;
    }

    public void setSurname(@NotBlank(message = "Поле /Фамилия/ не может быть пустым") String surname) {
        this.surname = surname;
    }

    public void setAge(@Min(value = 1) @Max(value = 130) int age) {
        this.age = age;
    }

    public void setPhoneNumber(@NotBlank(message = "Поле /Номер телефона/ не может быть пустым") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(@NotBlank(message = "Поле /Город/ не может быть пустым") String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        if (this.getAge() != other.getAge()) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$cityOfLiving = this.getCityOfLiving();
        final Object other$cityOfLiving = other.getCityOfLiving();
        if (this$cityOfLiving == null ? other$cityOfLiving != null : !this$cityOfLiving.equals(other$cityOfLiving))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        result = result * PRIME + this.getAge();
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $cityOfLiving = this.getCityOfLiving();
        result = result * PRIME + ($cityOfLiving == null ? 43 : $cityOfLiving.hashCode());
        return result;
    }

    public String toString() {
        return "Person(name=" + this.getName() + ", surname=" + this.getSurname() + ", age=" + this.getAge() + ", phoneNumber=" + this.getPhoneNumber() + ", cityOfLiving=" + this.getCityOfLiving() + ")";
    }
}