package org.squidmin.springboot.postgresql.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.squidmin.springboot.postgresql.model.User;
import org.squidmin.springboot.postgresql.service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@Slf4j
public class UserCLI implements Runnable {

    private final UserService userService;

    public UserCLI(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("Enter user name (or type 'exit' to quit):");

                String name = reader.readLine();
                log.info("Received input: {}", name);

                if (name == null) {
                    log.info("Input stream closed. Exiting.");
                    break;
                }

                if (name.trim().isEmpty()) {
                    log.warn("Empty input received. Prompting again...");
                    continue;
                }

                if ("exit".equalsIgnoreCase(name)) {
                    break;
                }

                User user = userService.saveUser(name);
                log.info("User saved: {}", user.toString());
                log.info("All users: {}", userService.getAllUsers().toString());
            }
        } catch (Exception e) {
            log.debug("Exception occurred: ", e);
        } finally {
            log.info("Exiting application...");
        }
    }

}
