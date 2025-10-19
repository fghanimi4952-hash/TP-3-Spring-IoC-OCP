package com.example.test;

import com.example.dao.IDao;
import com.example.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.dao", "com.example.metier"})
public class TestSimple {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Testez avec un profil à la fois
        ctx.getEnvironment().setActiveProfiles("file"); // Test DaoFile

        ctx.register(TestSimple.class);
        ctx.refresh();

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
        ctx.close();
    }
}