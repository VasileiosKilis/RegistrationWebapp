package com.example.spring.registration.rest;

import com.example.spring.registration.repository.UserJpaRepository;
import com.example.spring.registration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    /**
     * GET request on /api/user that returns the list of users on the database.
     *
     * @return list of users
     */
    @GetMapping("/")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userJpaRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * Post request on /api/user that creates a user on the database.
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        userJpaRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /**
     * Accesses a user by id.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") final Long id) {
        User user = userJpaRepository.findById(id).get();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * This method updates a user information.
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("id") final Long id, @RequestBody User user) {

        User currentUser = userJpaRepository.findById(id).get();

        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        currentUser.setDate(user.getDate());
        currentUser.setGender(user.getGender());
        currentUser.setHomeAddress(user.getHomeAddress());
        currentUser.setId(user.getId());

        userJpaRepository.saveAndFlush(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    /**
     * This method deletes a user from the database.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") final Long id) {
        userJpaRepository.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}

