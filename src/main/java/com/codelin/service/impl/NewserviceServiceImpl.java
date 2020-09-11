package com.codelin.service.impl;

import com.codelin.dao.NewserviceDao;
import com.codelin.entity.Newservice;
import com.codelin.service.NewserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-11 9:10
 */
@Service
@Transactional
public class NewserviceServiceImpl implements NewserviceService {

    @Autowired
    private NewserviceDao newserviceDao;

    @Override
    public void add(Newservice newservice) {
        newserviceDao.add(newservice);
    }

    @Override
    public List<Newservice> findAll() {
        return newserviceDao.findAll();
    }
}
