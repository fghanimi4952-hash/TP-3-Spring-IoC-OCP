package com.example;

import com.example.metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.assertEquals;

@Configuration
@ComponentScan(basePackages = {"com.example.dao", "com.example.metier", "com.example.config"})
class TestConfig {
}

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

    @Test
    public void propertyDriven_choisitDaoApi_440() {
        System.setProperty("dao.target", "daoApi");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("property-driven");
        ctx.register(TestConfig.class);
        ctx.refresh();

        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(440.0, m.calcul(), 1e-6);
        ctx.close();

        System.clearProperty("dao.target");
    }
}