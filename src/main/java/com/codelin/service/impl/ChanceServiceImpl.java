package com.codelin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.codelin.dao.ChanceDao;
import com.codelin.entity.Chance;
import com.codelin.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChanceServiceImpl implements ChanceService {

    @Autowired
    private ChanceDao chanceDao;

    @Override
    public List<Chance> findAll() {
        return chanceDao.findAll();
    }

    @Override
    public void addChance(Chance chance) {

        chanceDao.addChance(chance);
    }

    @Override
    public void deleteChance(int id) {
        chanceDao.deleteChance(id);
    }

    @Override
    public Chance findById(int id) {
        return chanceDao.findById(id);
    }

    @Override
    public void update(Chance chance) {
        chanceDao.update(chance);
    }
}
