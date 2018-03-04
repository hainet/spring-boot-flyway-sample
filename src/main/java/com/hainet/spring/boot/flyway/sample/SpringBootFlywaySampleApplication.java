package com.hainet.spring.boot.flyway.sample;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

@SpringBootApplication
public class SpringBootFlywaySampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFlywaySampleApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // データソースが設定されたFlywayインスタンスが注入される。
    @Autowired
    private Flyway flyway;

    @Override
    public void run(final String... args) throws Exception {
        // マイグレーションSQLが実行された結果を確認する。
        for (final MigrationInfo info : flyway.info().all()) {
            System.out.println(
                    "=== Flyway info ===\n" +
                    "Version: " + info.getVersion().getVersion() + "\n" +
                    "Description: " + info.getDescription() + "\n" +
                    "Type: " + info.getType().name() + "\n" +
                    "Script: " + info.getScript() + "\n" +
                    "Checksum: " + info.getChecksum() + "\n" +
                    "Installed on: " + info.getInstalledOn() + "\n" +
                    "Execution time: " + info.getExecutionTime() + "\n" +
                    "State: " + info.getState().getDisplayName() + "\n"
            );
        }

        // V1.0.1__Insert_Person.sqlが実行され、適切にpersonにデータが挿入されていることを確認する。
        Assert.notEmpty(jdbcTemplate.queryForList("SELECT * FROM person"), "No rows in table person!");
    }
}
