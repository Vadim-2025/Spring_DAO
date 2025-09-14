package ru.netology.service;

import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Service;
import ru.netology.entity.PersonEntity;
import ru.netology.exception.MyRepoException;
import ru.netology.mapper.Mapper;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final Mapper mapper;

    public PersonService(PersonRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Person> getPersonsByCity(String city) {
        List<PersonEntity> entities = repository.getPersonsByCity(city);
        System.out.println(entities);
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        entities.forEach(repository::detachPerson);
        return entities.stream().map(mapper::fromPersonEntity).collect(Collectors.toList());
    }

    public Person addPerson(Person person) {
        try {
            PersonEntity entity = repository.addEntity(mapper.toPersonEntity(person));
            repository.detachPerson(entity);
            return mapper.fromPersonEntity(entity);
        } catch (PersistenceException pe) {
            throw new MyRepoException("Не удалось подключить сущность");
        }
    }
}