package com.visdom.zero_west.dao;

import com.visdom.zero_west.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImageDao extends CrudRepository<Image, Integer> {
    Optional<List<Image>> findAllByMaxLevel(Integer maxLevel);
}
