package com.g4vrk.functionalDatabase.config;

import com.g4vrk.functionalDatabase.DatabaseType;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;

public class DatabaseConfigLoader {
    public static DatabaseConfig load(ConfigurationSection section, File sqliteFile) {
        return new DatabaseConfig(
                DatabaseType.valueOf(section.getString("type", "SQLITE").toUpperCase()),
                section.getString("mysql.host"),
                section.getInt("mysql.port"),
                section.getString("mysql.database"),
                section.getString("mysql.user"),
                section.getString("mysql.password"),
                sqliteFile
        );
    }
}
