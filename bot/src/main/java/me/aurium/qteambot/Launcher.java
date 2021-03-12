package me.aurium.qteambot;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.defaults.GenericBeetleFactory;
import me.aurium.beetle.defaults.datacore.HikariCoreSourceFactory;
import me.aurium.beetle.defaults.file.database.DBExtensionConstants;
import me.aurium.beetle.defaults.file.database.LocalSourceKey;
import me.aurium.beetle.defaults.file.database.LocalSourceOptions;
import me.aurium.beetle.defaults.utility.LauncherUtils;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.nio.file.Path;

/**
 * Class that gathers the dependencies and provides them to a QTeamBot instance.
 */
public class Launcher {

    public final static String APPLICATION_NAME = "QTeamBot";

    public static void main(String[] args) {
        Path absolutePath = LauncherUtils.getLauncherFileFolder(Launcher.class);
        Beetle beetle = new GenericBeetleFactory(APPLICATION_NAME,absolutePath,true).build();

        beetle.getLogger().debug("Launcher | Beetle initialized successfully! " +
                "Path: " + absolutePath.toString() + " " +
                "Debug Enabled: " + beetle.isDebug());

        beetle.getLogger().debug("Launcher | Initializing LauncherConfig and other configurations!");

        //TODO some shit with Gears blah blah blah

        LauncherConfig config = null; //simulate config being loaded

        beetle.getLogger().debug("Launcher | Initializing JavaCord");

        DiscordApi discordApi = new DiscordApiBuilder().setToken(config.token()).login().join(); //ew (listed as the correct way to get an API instance)

        beetle.getLogger().debug("Launcher | Initializing DataCore Functionality!");

        DataCore dataCore;

        if (config.useLocalStorage()) {
            switch (config.storageType()) {
                case H2:
                    beetle.getFileProvider().registerNewFileProducer(
                            new LocalSourceKey("database"),
                            new LocalSourceOptions("sa","", DBExtensionConstants.H2));
                case SQLITE:
                    /// FIXME: 3/12/21 add sqlite shit when im not tired
                    beetle.getFileProvider().registerNewFileProducer(
                            new LocalSourceKey("database"),
                            new LocalSourceOptions("sa","", DBExtensionConstants.H2));
            }

            CoreSource coreSource = beetle.getFileProvider().getProducer(new LocalSourceKey("database")).produce();
            dataCore = beetle.getDataCoreFactory().produceDatacore(coreSource);
        } else {
            CoreSource coreSource = new HikariCoreSourceFactory(config.webSourceConfig(), false).getCoreSource();

            dataCore = beetle.getDataCoreFactory().produceDatacore(coreSource);
        }

        beetle.getLogger().debug("Launcher | Initialized DataCore successfully! (?)");

        beetle.getLogger().debug("Launcher | Initializing SpecificLauncher");

        new QTeamBotLauncher(beetle,dataCore,discordApi).launch();
    }

}
