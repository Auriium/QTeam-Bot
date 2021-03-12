package me.aurium.qteambot.interfaces;

public interface Module<T extends ModuleAPI> {

    void initializeListeners();
    T getAPI();

}
