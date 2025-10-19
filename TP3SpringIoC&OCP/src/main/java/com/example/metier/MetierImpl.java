package com.example.metier;

import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {

    @Autowired
    private IDao dao;

    @Override
    public double calcul() {
        System.out.println("[TRACE] DAO utilisé = " + dao.getClass().getSimpleName());
        return dao.getValue() * 2;
    }
}