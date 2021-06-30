package com.luck.conference.controller;

import com.luck.conference.model.Session;
import com.luck.conference.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository repository;

    @GetMapping
    public List<Session> list() {
        return repository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Session get(@PathVariable long id) {
        return repository.getById(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return repository.saveAndFlush(session);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable long id, @RequestBody Session session) {
        Session sessionOld = repository.getById(id);
        BeanUtils.copyProperties(session, sessionOld, "session_id");
        return repository.saveAndFlush(sessionOld);
    }
}
