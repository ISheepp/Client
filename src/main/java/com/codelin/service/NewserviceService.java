package com.codelin.service;

import com.codelin.entity.Newservice;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-11 9:10
 */
public interface NewserviceService {

    void add(Newservice newservice);

    List<Newservice> findAll();

    void update(int id);

    void delete(int id);

    List<Newservice> findByStatus();

    List<Newservice> done();

    void archive(int id);

    int find1();

    int find2();

    int find3();

    int find4();
}
