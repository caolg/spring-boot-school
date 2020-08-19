package com.school;

import com.school.properties.OrderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {
         for (String s:args){
             System.out.println("ss==>"+s);
         }
        SpringApplication.run(Demo01Application.class, args);
    }

    @Component
    public class OrderPropertiesCommandLineRunner implements CommandLineRunner {
        private final Logger logger= LoggerFactory.getLogger(getClass());
        @Autowired
        private OrderProperties orderProperties;

        @Override
        public void run(String... args) throws Exception {

            logger.info("desc--->"+orderProperties.getDesc());
            logger.info("payTimeoutSeconds-->"+orderProperties.getPayTimeoutSeconds());

            logger.info("createFrequencySeconds-->"+orderProperties.getCreateFrequencySeconds());
        }
    }



    @Component
    public class ValueCommandLineRunner implements CommandLineRunner{

        private final Logger logger=LoggerFactory.getLogger(getClass());

        @Value("${order.pay-timeout-seconds}")
        private Integer payTimeoutSeconds;
        @Value("${order.create-frequency-seconds}")
        private String[] temp;

        @Override
        public void run(String... args) throws Exception {
            logger.info("value-->payTimeoutSeconds--->"+payTimeoutSeconds);
            logger.info("value-->cc===>"+ temp[0]);
        }
    }




}
