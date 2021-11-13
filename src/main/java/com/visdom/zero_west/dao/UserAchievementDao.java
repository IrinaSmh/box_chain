package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.UserAchievement;
import com.visdom.zero_west.model.UserAchievementKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAchievementDao extends CrudRepository<UserAchievement, UserAchievementKey> {
    Optional<List<UserAchievement>> findAllById_UserId(Long userId);
}
