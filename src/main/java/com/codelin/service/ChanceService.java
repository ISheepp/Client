package com.codelin.service;

import com.codelin.entity.Chance;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ChanceService {

    List<Chance> findAll();

    void addChance(Chance chance);
}
