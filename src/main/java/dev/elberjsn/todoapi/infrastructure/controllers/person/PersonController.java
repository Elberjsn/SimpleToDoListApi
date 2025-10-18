package dev.elberjsn.todoapi.infrastructure.controllers.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.controllers.person.dtos.PersonCreateRequest;
import dev.elberjsn.todoapi.infrastructure.controllers.person.dtos.PersonRequestDto;
import dev.elberjsn.todoapi.infrastructure.repositories.person.PersonRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.person.mapper.PersonEntityMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    final PersonRepositoryImpl personRepository;
    public PersonController(PersonRepositoryImpl personRepository1) {
        this.personRepository = personRepository1;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonRequestDto> createPerson(@RequestBody PersonCreateRequest newPerson) {
        Person p = personRepository.save(PersonEntityMapper.toDomainDTO(newPerson));
        if (p == null){
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build() ;
        }
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(PersonEntityMapper.toDTO(p));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonRequestDto> updatePerson(@RequestBody PersonCreateRequest newPerson,@PathVariable String id) {
        Long idPerson = Long.parseLong(id);
        personRepository.update(idPerson, PersonEntityMapper.toDomainDTO(newPerson));
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonRequestDto> deletePerson(@PathVariable String id) {
        Long idPerson = Long.parseLong(id);
        personRepository.delete(idPerson);
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<PersonRequestDto> findPersonById(@PathVariable String id) {
        Long idPerson = Long.parseLong(id);
        PersonRequestDto p = PersonEntityMapper.toDTO(personRepository.findById(idPerson).orElse(null));
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(p);
    }
    @GetMapping("/find/{email}")
    public ResponseEntity<PersonRequestDto> findPersonByEmail(@PathVariable String email) {
        PersonRequestDto p = PersonEntityMapper.toDTO(personRepository.findByEmail(email).orElse(null));
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(p);
    }

    @PostMapping("/login")
    public ResponseEntity<PersonRequestDto> loginPerson(@RequestBody String email, @RequestBody String password) {
        boolean login = personRepository.login(email, password);
        if (!login){
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_ACCEPTED).build();
    }



}
