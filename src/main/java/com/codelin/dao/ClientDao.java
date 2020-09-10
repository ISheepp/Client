package com.codelin.dao;

import com.codelin.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> findAll();

    Client findById(int id);

    void add(Client client);

    void delete(int id);

    void update(Client client);

}
