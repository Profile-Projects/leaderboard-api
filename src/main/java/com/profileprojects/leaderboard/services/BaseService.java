package com.profileprojects.leaderboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseService <R extends JpaRepository<E, ID>, E, ID extends Serializable> {

    @Autowired
    R repo;

    public E add(final E e) {
        return repo.saveAndFlush(e);
    }

    public Optional<E> get(final ID id) {
        return repo.findById(id);
    }

    public E update(final E e, final ID id) {
        if (get(id).isEmpty()) return null;
        return repo.save(e);
    }

    public void delete(final ID id) {
        repo.deleteById(id);
    }
}
