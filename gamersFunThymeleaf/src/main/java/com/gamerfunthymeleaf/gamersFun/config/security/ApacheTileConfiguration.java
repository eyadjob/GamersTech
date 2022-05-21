package com.gamerfunthymeleaf.gamersFun.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class ApacheTileConfiguration {
    @Bean
    public UrlBasedViewResolver tilesViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(TilesView.class);
        return urlBasedViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        String[] defs = {"/WEB-INF/tiles.xml"};
        tilesConfigurer.setDefinitions(defs);
        return tilesConfigurer;
    }
}
