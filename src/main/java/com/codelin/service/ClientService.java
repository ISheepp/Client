package com.codelin.service;

import com.codelin.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(int id);

    void add(Client client);

    void delete(int id);

    void update(Client client);

    int find1();

    int find2();

    int find3();

    int find4();


}
