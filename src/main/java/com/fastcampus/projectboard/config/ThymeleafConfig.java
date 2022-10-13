package com.fastcampus.projectboard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(
            SpringResourceTemplateResolver defaultTemplateResolver,
            Thymeleaf3Properties thymeleaf3Properties
    ) {
        //나는 왜 안돼... 이게 안먹혀서 항상 true 처리시킴... 강의 진행은 나가야하니.. 휴
        // defaultTemplateResolver.setUseDecoupledLogic(thymeleaf3Properties.isDecoupledLogic());
        defaultTemplateResolver.setUseDecoupledLogic(true);

        return defaultTemplateResolver;
    }


    @RequiredArgsConstructor
    @Getter
    @ConstructorBinding
    @ConfigurationProperties("spring.thymeleaf3")
    public static class Thymeleaf3Properties {
        /**
         * Use Thymeleaf 3 Decoupled Logic
         */
        private final boolean decoupledLogic;

    }
}
