package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Integer> {
}
