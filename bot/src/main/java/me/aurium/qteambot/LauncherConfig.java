package me.aurium.qteambot;

import me.aurium.beetle.defaults.datacore.WebSourceConfig;

public interface LauncherConfig {

    //DISCORD
    String token();

    //STORAGE
    StorageType storageType();
    WebSourceConfig webSourceConfig();
    boolean useLocalStorage();

}
