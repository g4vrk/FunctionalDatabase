package com.g4vrk.functionalDatabase.connection.impl;

import com.g4vrk.functionalDatabase.connection.DatabaseConnection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class SQLiteConnection implements DatabaseConnection {

    private final HikariDataSource source;
    private final String poolName;

    public SQLiteConnection(String poolName, File baseFile) {
        this(poolName, baseFile, new HikariConfig());
    }

    public SQLiteConnection(String poolName, File baseFile, HikariConfig config) {
        this.poolName = poolName;
        String url = "jdbc:sqlite:" + baseFile.getAbsolutePath();

        config.setJdbcUrl(url);
        config.setPoolName(poolName);

        this.source = new HikariDataSource(config);
    }

    @Override
    public Optional<Connection> connect() {
        try {
            return Optional.of(source.getConnection());
        } catch (SQLException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public HikariDataSource getSource() {
        return this.source;
    }

    public String getPoolName() {
        return this.poolName;
    }
}
