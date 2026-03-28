package com.g4vrk.functionalDatabase.connection;

import java.sql.Connection;
import java.util.Optional;

public interface DatabaseConnection {
    Optional<Connection> connect();

    String getPoolName();
}
