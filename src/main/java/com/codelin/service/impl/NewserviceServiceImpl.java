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

    @Override
    public void update(int id) {
        newserviceDao.update(id);
    }

    @Override
    public void delete(int id) {
        newserviceDao.delete(id);
    }

    @Override
    public List<Newservice> findByStatus() {
        return newserviceDao.findByStatus();
    }

    @Override
    public void archive(int id) {
        newserviceDao.archive(id);
    }

    @Override
    public List<Newservice> done() {
        return newserviceDao.done();
    }

    @Override
    public int find1() {
        return newserviceDao.find1();
    }

    @Override
    public int find2() {
        return newserviceDao.find2();
    }

    @Override
    public int find3() {
        return newserviceDao.find3();
    }

    @Override
    public int find4() {
        return newserviceDao.find4();
    }
}
