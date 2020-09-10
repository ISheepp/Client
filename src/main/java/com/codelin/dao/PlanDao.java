package com.codelin.dao;

import com.codelin.entity.Plan;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-10 15:03
 */
public interface PlanDao {

    //根据clientname查询
    List<Plan> findByClientName(String clientname);

}
