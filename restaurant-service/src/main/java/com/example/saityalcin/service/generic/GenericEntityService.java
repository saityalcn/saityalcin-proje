package com.example.saityalcin.service.generic;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.solr.repository.SolrCrudRepository;

public abstract class GenericEntityService<E, R extends CrudRepository<E, Long>> {
    private final R repository;

    protected GenericEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E model) {
        return repository.save(model);
    }

    public Iterable<E> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
