package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.TypeOfGarbage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfGarbageDao extends CrudRepository<TypeOfGarbage, Integer> {
}
