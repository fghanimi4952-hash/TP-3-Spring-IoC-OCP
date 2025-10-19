package com.example.presentation;

import com.example.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Presentation2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // TESTEZ UN PROFIL À LA FOIS - décommentez une seule ligne
        ctx.getEnvironment().setActiveProfiles("file");   // Test DaoFile
        // ctx.getEnvironment().setActiveProfiles("dev");    // Test DaoImpl2
        // ctx.getEnvironment().setActiveProfiles("prod");   // Test DaoImpl
        // ctx.getEnvironment().setActiveProfiles("api");     // Test DaoApi

        ctx.scan("com.example"); // Scan tous les packages
        ctx.refresh();

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("=== RÉSULTAT FINAL ===");
        System.out.println("Résultat = " + metier.calcul());
        ctx.close();
    }
}