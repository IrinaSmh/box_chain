package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelDao extends CrudRepository<Level, Integer> {
    Optional<Level> findFirstByMinXpLessThanOrderByMinXpDesc(Integer minXp);
}
