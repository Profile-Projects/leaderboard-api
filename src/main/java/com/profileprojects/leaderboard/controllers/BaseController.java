package com.profileprojects.leaderboard.controllers;

import com.profileprojects.leaderboard.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseController<S extends BaseService<R, E, ID>, E, ID extends Serializable, R extends JpaRepository<E, ID>> {

    @Autowired
    protected S service;

    @PostMapping
    public ResponseEntity<E> add(@RequestBody E e) {
        final E addedE =  service.add(e);
        return ResponseEntity.ok(addedE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> update(@RequestBody E e, @PathVariable("id") ID id) {
        final E updated = service.update(e, id);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> get(@PathVariable("id") ID id) {
        final Optional<E> eO = service.get(id);
        if (eO.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(eO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
