package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Garbage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GarbageDao extends CrudRepository<Garbage, Integer> {
    Optional<Garbage> findGarbageByName(String name);
}
