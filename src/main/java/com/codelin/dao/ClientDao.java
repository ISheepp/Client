package com.codelin.dao;

import com.codelin.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> findAll();

    Client findById(int id);

    void add(Client client);

    void delete(int id);

    void update(Client client);

    //根据级别查询
    int find1();

    int find2();

    int find3();

    int find4();

}
