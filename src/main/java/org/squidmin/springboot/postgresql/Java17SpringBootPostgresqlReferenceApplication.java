package org.squidmin.springboot.postgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.squidmin.springboot.postgresql.cli.UserCLI;

@SpringBootApplication
public class Java17SpringBootPostgresqlReferenceApplication implements CommandLineRunner {

    @Autowired
    private UserCLI userCLI;

    public static void main(String[] args) {
        SpringApplication.run(Java17SpringBootPostgresqlReferenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        Thread cliThread = new Thread(userCLI);
        cliThread.start();
        cliThread.join();
    }

}
