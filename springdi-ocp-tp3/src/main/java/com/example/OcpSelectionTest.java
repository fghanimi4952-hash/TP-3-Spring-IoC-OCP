package com.example;

import com.example.metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class OcpSelectionTest {

    @Test
    public void devProfile_choisitDao_300() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(300.0, m.calcul(), 1e-6);
        ctx.close();
    }

    @Test
    public void prodProfile_choisitDao_200() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(200.0, m.calcul(), 1e-6);
        ctx.close();
    }

    @Test
    public void fileProfile_choisitDao_360() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("file");
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(360.0, m.calcul(), 1e-6);
        ctx.close();
    }

    @Test
    public void apiProfile_choisitDao_440() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("api");
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(440.0, m.calcul(), 1e-6);
        ctx.close();
    }

    // Test sans profil (doit utiliser DefaultDao)
    @Test
    public void noProfile_usesDefaultDao_100() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // Pas de profil activé
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(100.0, m.calcul(), 1e-6); // 50.0 * 2 = 100.0
        ctx.close();
    }
}