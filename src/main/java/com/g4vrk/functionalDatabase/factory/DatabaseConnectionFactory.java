package com.g4vrk.functionalDatabase.factory;

import com.g4vrk.functionalDatabase.DatabaseType;
import com.g4vrk.functionalDatabase.connection.DatabaseConnection;

public interface DatabaseConnectionFactory {
    DatabaseType getType();

    DatabaseConnection create(String poolName);
}
