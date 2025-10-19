package com.example;

import com.example.metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.presentation.Presentation2;

import static org.junit.Assert.assertEquals;

public class OcpSelectionTest {

    @Test
    public void testAvecDao2() {
        System.setProperty("dao.target", "dao2");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Presentation2.class);
        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(300.0, m.calcul(), 1e-6);
        ctx.close();
    }

    @Test
    public void testAvecDao() {
        System.setProperty("dao.target", "dao");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Presentation2.class);
        IMetier m = ctx.getBean(IMetier.class);
        assertEquals(200.0, m.calcul(), 1e-6);
        ctx.close();
    }
}