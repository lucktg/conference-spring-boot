package com.luck.conference.controller;

import com.luck.conference.model.Speaker;
import com.luck.conference.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository repository;

    @GetMapping
    public List<Speaker> list() {
        return repository.findAll();
    }

    @GetMapping(value= "/{id}")
    public Speaker get(@PathVariable long id) {
        return repository.getById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker) {
        return repository.saveAndFlush(speaker);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable long id, @RequestBody Speaker speaker) {
        Speaker speakerOld = repository.getById(id);
        BeanUtils.copyProperties(speaker, speakerOld, "speaker_id");
        return repository.saveAndFlush(speakerOld);
    }

}
