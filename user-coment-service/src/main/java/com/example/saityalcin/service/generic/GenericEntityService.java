package com.example.saityalcin.service.generic;


import com.example.saityalcin.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {
    private final R repository;

    protected GenericEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E model) {
        return repository.save(model);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(Long id) {
        Optional<E> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
