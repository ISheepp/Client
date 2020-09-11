package com.codelin.service.impl;


import com.codelin.dao.ClientDao;
import com.codelin.entity.Client;
import com.codelin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientDao.findById(id);
    }

    @Override
    public void add(Client client) {
        clientDao.add(client);
    }

    @Override
    public void delete(int id) {
        clientDao.delete(id);
    }

    @Override
    public void update(Client client) {
        clientDao.update(client);
    }

    @Override
    public int find1() {
        return clientDao.find1();
    }

    @Override
    public int find2() {
        return clientDao.find2();
    }

    @Override
    public int find3() {
        return clientDao.find3();
    }

    @Override
    public int find4() {
        return clientDao.find4();
    }
}
