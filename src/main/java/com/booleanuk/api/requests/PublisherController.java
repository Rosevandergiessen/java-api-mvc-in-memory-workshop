package com.booleanuk.api.requests;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private PublisherRepository thePublishers;

    public PublisherController(){
        this.thePublishers = new PublisherRepository();
    }

    @GetMapping
    public ArrayList<Publisher> getAll(){
        return this.thePublishers.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable (name = "id") int id){
        Publisher publisher = this.thePublishers.getOne(id);
        if (publisher == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher){
        return this.thePublishers.create(publisher);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher p){
        Publisher publisher = this.thePublishers.update(id, p);
        if (publisher == null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Not found");
        }
        return publisher;
    }


    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id){
        Publisher publisher = this.thePublishers.delete(id);
        if (publisher == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return publisher;
    }

}
