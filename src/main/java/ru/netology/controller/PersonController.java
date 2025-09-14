package ru.netology.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.Person;
import ru.netology.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    List<Person> getPersonsByCity(@RequestParam(name = "city") @NotBlank(message = "Город не может быть пустым") String city) {
        return service.getPersonsByCity(city);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody @Validated Person person) {
        return service.addPerson(person);
    }
}
