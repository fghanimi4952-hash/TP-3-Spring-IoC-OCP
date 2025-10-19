package com.example.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("daoFile")  // NOTE: "daoFile" avec F majuscule
@Profile("file")
public class DaoFile implements IDao {
    @Override
    public double getValue(){
        System.out.println("[DAO] Utilisation de DaoFile");
        return 180.0;
    }
}