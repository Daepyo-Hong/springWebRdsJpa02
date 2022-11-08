package com.green.nowon.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {        //bean : mybatisConfig
    //DataSource : jpa 적용
    //SqlSessionFactory
    @Autowired
    ApplicationContext ac;
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration myMybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        ssfb.setConfiguration(myMybatisConfig());

        String locationPattern = "classpath:mapper/**/*-mapper.xml";

        Resource[] mapperLocations =
                new PathMatchingResourcePatternResolver().getResources(locationPattern);

        //Resource[] mapperLocations = ac.getResources(locationPattern);
        ssfb.setMapperLocations(mapperLocations);

        return ssfb.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(dataSource));
    }
}
