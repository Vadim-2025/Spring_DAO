package ru.netology.mapper;

import org.springframework.stereotype.Component;
import ru.netology.entity.PersonEntity;
import ru.netology.entity.PersonProfile;
import ru.netology.model.Person;

@Component
public class Mapper {
    public Person fromPersonEntity(PersonEntity entity) {

        return Person.builder().name(entity.getPersonProfile().getName())
                .surname(entity.getPersonProfile().getSurname())
                .age(entity.getPersonProfile().getAge())
                .phoneNumber(entity.getPhoneNumber())
                .cityOfLiving(entity.getCityOfLiving())
                .build();
    }

    public PersonEntity toPersonEntity(Person person) {

        return PersonEntity.builder().personProfile(PersonProfile.builder().name(person.getName())
                        .surname(person.getSurname())
                        .age(person.getAge())
                        .build())
                .phoneNumber(person.getPhoneNumber())
                .cityOfLiving(person.getCityOfLiving())
                .build();
    }
}