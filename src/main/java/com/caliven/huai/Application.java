package com.caliven.huai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author caliven
 * @since 2020-01-21
 */
@SpringBootApplication
@MapperScan("com.company.project.mapper")
public class Application implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     * 项目启动后运行方法，用于初始化一些东西
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // do something
    }
}
