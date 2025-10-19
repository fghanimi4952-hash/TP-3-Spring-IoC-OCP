package com.example.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao")
@Profile("prod")
public class DaoImpl implements IDao {
    @Override
    public double getValue(){
        System.out.println("[DAO] Utilisation de DaoImpl");
        return 100.0;
    }
}