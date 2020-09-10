package com.codelin.dao;

import com.codelin.entity.Chance;

import java.util.List;

public interface ChanceDao {
    //查询所有
    List<Chance> findAll();

    //插入
    void addChance(Chance chance);

    //删除
    void deleteChance(int id);

    //根据id查询
    Chance findById(int id);

    //更新
    void update(Chance chance);
}
