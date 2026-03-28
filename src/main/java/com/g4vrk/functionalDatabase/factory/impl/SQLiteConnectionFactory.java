package com.g4vrk.functionalDatabase.factory.impl;

import com.g4vrk.functionalDatabase.DatabaseType;
import com.g4vrk.functionalDatabase.config.DatabaseConfig;
import com.g4vrk.functionalDatabase.connection.DatabaseConnection;
import com.g4vrk.functionalDatabase.connection.impl.SQLiteConnection;
import com.g4vrk.functionalDatabase.factory.DatabaseConnectionFactory;

public class SQLiteConnectionFactory implements DatabaseConnectionFactory {

    private final DatabaseConfig config;

    public SQLiteConnectionFactory(DatabaseConfig config) {
        this.config = config;
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.SQLITE;
    }

    @Override
    public DatabaseConnection create(String poolName) {
        return new SQLiteConnection(poolName, config.sqliteFile());
    }
}

