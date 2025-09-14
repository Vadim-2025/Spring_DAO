package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.entity.PersonEntity;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<PersonEntity> getPersonsByCity(String city) {
        return em.createNamedQuery("Persons.findByCity", PersonEntity.class).setParameter("city", city).getResultList();
    }

    public List<PersonEntity> getPersonsByCityNativeQuery(String city) {
        String sql = "SELECT * FROM netology.persons WHERE city_of_living ~* '" + city + "'";
        return em.createNativeQuery(sql, PersonEntity.class).getResultList();
    }

    @Override
    public void detachPerson(PersonEntity entity) {

        em.detach(entity);
    }

    @Override
    @Transactional
    public PersonEntity addEntity(PersonEntity entity) {
        em.persist(entity);
        entity = em.merge(entity);
        return entity;
    }

    @Override
    public <T> void deleteObject(T t) {
        if (!em.contains(t)) {
            em.persist(t);
        }
        em.merge(t);
        em.remove(t);
    }
}