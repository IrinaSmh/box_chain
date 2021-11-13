package com.visdom.zero_west.service;

import com.visdom.zero_west.dao.GarbageDao;
import com.visdom.zero_west.dao.TypeOfGarbageDao;
import com.visdom.zero_west.dto.GarbageDto;
import com.visdom.zero_west.model.Garbage;
import com.visdom.zero_west.model.TypeOfGarbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GarbageService {
    private GarbageDao garbageDao;

    @Autowired
    public GarbageService(GarbageDao garbageDao) {
        this.garbageDao = garbageDao;
    }

    public List<Garbage> getAll() {
        List<Garbage> garbage = new ArrayList<>();
        garbageDao.findAll().forEach(garbage::add);
        return garbage;
    }

}
