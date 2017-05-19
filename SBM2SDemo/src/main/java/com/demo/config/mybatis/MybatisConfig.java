package com.demo.config.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * @Description: mybatis的配置类
 * 
 * @author DELL
 * 
 * @since 2017-04-26
 *
 */
@Configuration
public class MybatisConfig {

	/**
	 * 
	 * @Title: getDataSource   
	 * @Description: 数据源的配置  
	 * 
	 * @param:       
	 * @return: DataSource      
	 * @throws:
	 * 
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.sbm2s")
	public DataSource getDataSource() {
		return new DruidDataSource();
	}

	
	/**
	 * 
	 * @Title: sqlSessionFactory   
	 * @Description: mybatis的sqlSessionFactory配置
	 * 
	 * @param: dataSource
	 * @return: SqlSessionFactory      
	 * @throws Exception
	 * 
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.pojo");
		
		return sqlSessionFactoryBean.getObject();
	}

	
	
	/**
	 * 
	 * @Title: mapperScannerConfigurer   
	 * @Description: mapper接口扫描包
	 * 
	 * @param:       
	 * @return: MapperScannerConfigurer      
	 * @throws
	 * 
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		
		mapperScannerConfigurer.setBasePackage("com.demo.mapper");
		
		return mapperScannerConfigurer;
	}

	
	
	/**
	 * 
	 * @Title: transactionManager   
	 * @Description: 配置事务管理器
	 * 
	 * @param: dataSource
	 * @return: DataSourceTransactionManager    
	 * @throws: Exception      
	 *   
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource)throws Exception {
		
		return new DataSourceTransactionManager(dataSource);
	}
}
