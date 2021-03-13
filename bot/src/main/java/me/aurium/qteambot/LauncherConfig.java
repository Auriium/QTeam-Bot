package me.aurium.qteambot;

import me.aurium.beetle.defaults.datacore.WebSourceConfig;

public interface LauncherConfig {

    //DISCORD
    String token();

    //STORAGE
    String databaseName();
    String databaseUser();
    String databaseHost();
    String databasePassword();
    int databasePort();

}
