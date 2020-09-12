package com.codelin.dao;

import com.codelin.entity.Newservice;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-11 9:03
 */
public interface NewserviceDao {

    void add(Newservice newservice);

    List<Newservice> findAll();

    void update(int id);

    void delete(int id);

    List<Newservice> findByStatus();

    void archive(int id);

    List<Newservice> done();

    //根据服务类型查询
    int find1();

    int find2();

    int find3();

    int find4();
}
