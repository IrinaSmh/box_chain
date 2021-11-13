package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.TypeOfAchievement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfAchievementDao extends CrudRepository<TypeOfAchievement, Integer> {
}
