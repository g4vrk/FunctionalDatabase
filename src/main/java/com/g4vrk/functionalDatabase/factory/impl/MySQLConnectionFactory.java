package com.g4vrk.functionalDatabase.factory.impl;

import com.g4vrk.functionalDatabase.DatabaseType;
import com.g4vrk.functionalDatabase.config.DatabaseConfig;
import com.g4vrk.functionalDatabase.connection.DatabaseConnection;
import com.g4vrk.functionalDatabase.connection.impl.MySQLConnection;
import com.g4vrk.functionalDatabase.factory.DatabaseConnectionFactory;

public class MySQLConnectionFactory implements DatabaseConnectionFactory {

    private final DatabaseConfig config;

    public MySQLConnectionFactory(DatabaseConfig config) {
        this.config = config;
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.MYSQL;
    }

    @Override
    public DatabaseConnection create(String poolName) {
        return new MySQLConnection(
                poolName,
                config.host(),
                config.port(),
                config.database(),
                config.user(),
                config.password()
        );
    }
}

