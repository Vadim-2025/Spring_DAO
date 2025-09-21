package ru.netology.service;

import jakarta.persistence.PersistenceException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.entity.PersonEntity;
import ru.netology.exception.MyRepoException;
import ru.netology.mapper.Mapper;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        List<PersonEntity> entities = repository.findByCityOfLiving(city);
        System.out.println(entities);
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        return transformationObjects(entities);
    }

    public List<Person> getPersonsByAgeSortAsc(int age) {
        List<PersonEntity> entities = repository.findByPersonProfileAgeLessThan(age
                , Sort.by(Sort.Direction.ASC
                        , "PersonProfile.age"));
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        return transformationObjects(entities);
    }

    public List<Person> getPersonsByFullName(String name, String surname) {
        Optional<List<PersonEntity>> optional = repository
                .findByPersonProfileNameAndPersonProfileSurname(name, surname);
        if (optional.isPresent()) {
            List<PersonEntity> personEntityList = optional.get();
            if (!personEntityList.isEmpty()) {
                return transformationObjects(personEntityList);
            }
        }
        throw new MyRepoException("Пользователя с данным именем не найдено");
    }

    private List<Person> transformationObjects(List<PersonEntity> entities) {
        return entities.stream().map(mapper::fromPersonEntity).collect(Collectors.toList());
    }

    public Person addPerson(Person person) {
        try {
            PersonEntity entity = repository.save(mapper.toPersonEntity(person));
            return mapper.fromPersonEntity(entity);
        } catch (PersistenceException pe) {
            throw new MyRepoException("Не удалось подключить сущность");
        }
    }
}