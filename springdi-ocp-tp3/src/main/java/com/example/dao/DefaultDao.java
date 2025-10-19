package com.example.dao;

import org.springframework.stereotype.Component;

@Component("defaultDao")
// RETIREZ @Primary pour laisser les profils fonctionner
public class DefaultDao implements IDao {
    @Override
    public double getValue(){
        System.out.println("[DAO] Utilisation de DefaultDao (fallback)");
        return 50.0;
    }
}