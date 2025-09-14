package ru.netology.repository;

import ru.netology.entity.PersonEntity;

import java.util.List;

public interface PersonRepository {
    List<PersonEntity> getPersonsByCity(String city);

    void detachPerson(PersonEntity entity);

    PersonEntity addEntity(PersonEntity entity);

    public <T> void deleteObject(T t);
}
