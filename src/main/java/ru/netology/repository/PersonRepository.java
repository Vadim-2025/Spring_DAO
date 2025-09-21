package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.entity.PersonEntity;
import ru.netology.entity.PersonProfile;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, PersonProfile> {
    List<PersonEntity> findByCityOfLiving(String city);

    List<PersonEntity> findByPersonProfileAgeLessThan(Integer age, Sort sort);

    List<PersonEntity> findByPersonProfileAgeLessThanOrderByPersonProfileAgeAsc(Integer age);

    Optional<List<PersonEntity>> findByPersonProfileNameAndPersonProfileSurname(String name, String surname);
}