package com.codelin.service;

import com.codelin.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(int id);

    void add(Client client);

    void delete(int id);

    void update(Client client);

}
