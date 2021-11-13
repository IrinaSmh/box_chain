package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Achievement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementDao extends CrudRepository<Achievement, Long> {
    Optional<List<Achievement>> findAllByTypeOfAchievement_Id(Long id);
}
