package com.green.nowon.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {        //bean : mybatisConfig
    //DataSource : jpa 적용
    //SqlSessionFactory

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
        return ssfb.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(dataSource));
    }
}
