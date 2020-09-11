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

}
