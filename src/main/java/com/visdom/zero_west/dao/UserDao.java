package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<List<User>> findAllByRole_Id(Integer roleId);
    Optional<List<User>> findAllByRole_IdAndUpdateRatingDataGreaterThanOrderByXpDesc(Integer roleId, LocalDateTime minDateTime);
    Optional<List<User>> findAllByRole_IdOrderByXpDesc(Integer roleId);
}
