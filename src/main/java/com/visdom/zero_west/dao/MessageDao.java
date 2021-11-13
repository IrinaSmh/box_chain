package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageDao extends CrudRepository<Message, Integer> {
}
