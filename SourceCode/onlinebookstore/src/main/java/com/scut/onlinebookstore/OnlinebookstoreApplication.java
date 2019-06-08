package com.scut.onlinebookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FatCat
 */

@MapperScan("com.scut.onlinebookstore.dao")
@SpringBootApplication
public class OnlinebookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinebookstoreApplication.class, args);
    }

}
