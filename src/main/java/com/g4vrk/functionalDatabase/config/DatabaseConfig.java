package com.g4vrk.functionalDatabase.config;

import com.g4vrk.functionalDatabase.DatabaseType;

import java.io.File;

public record DatabaseConfig(
        DatabaseType type,
        String host,
        int port,
        String database,
        String user,
        String password,
        File sqliteFile
) {}

