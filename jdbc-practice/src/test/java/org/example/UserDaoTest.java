package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db.schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        UserDAO userDao = new UserDAO();
        userDao.create(new User("userId", "password", "name", "email"));
        User user = userDao.findByUserId("userId");
        assertThat(user).isEqualTo(new User("userId", "password", "name", "email"));
    }
}
