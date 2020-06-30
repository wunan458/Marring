package cn.marring.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * application configuration
 *
 * @author Wn 2020-06-06
 */
@CrossOrigin
@SpringBootApplication
@EntityScan("cn.marring.dao.entity")
@MapperScan("cn.marring.dao.mapper")
public class MarringWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(MarringWebApplication.class, args);

    }
}
