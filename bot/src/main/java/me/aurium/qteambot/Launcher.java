package me.aurium.qteambot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.generic.GenericBeetleFactory;

import java.io.File;

public class Launcher {



    public static void main(String[] args) {
        File launcherLocation = new File(Launcher.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        Beetle beetle = new GenericBeetleFactory(launcherLocation,true).build();

        QTeamBot bot = new QTeamBotLauncher(beetle).launch();
    }

}
