package com.example.config;

import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Map;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    @Autowired
    private Map<String, IDao> daoBeans;

    @Value("${dao.target:dao}")
    private String target;

    @Bean(name = "dao")
    @Primary
    public IDao selectedDao() {
        System.out.println("[CONFIG] Recherche du DAO: " + target);

        IDao selected = daoBeans.get(target);
        if (selected == null) {
            throw new IllegalArgumentException("Implémentation inconnue: " + target + " (dao|dao2|daoFile|daoApi)");
        }

        System.out.println("[CONFIG] DAO sélectionné: " + selected.getClass().getSimpleName());
        return selected;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}