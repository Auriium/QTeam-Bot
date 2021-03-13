package me.aurium.qteambot;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.defaults.GenericBeetleFactory;
import me.aurium.beetle.defaults.datacore.HikariCoreSourceFactory;
import me.aurium.beetle.defaults.datacore.WebSourceConfig;
import me.aurium.beetle.defaults.file.database.DBExtensionConstants;
import me.aurium.beetle.defaults.file.database.LocalSourceKey;
import me.aurium.beetle.defaults.file.database.LocalSourceOptions;
import me.aurium.beetle.defaults.utility.LauncherUtils;
import org.flywaydb.core.Flyway;
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
        //i literally do not care about blocking here. If we were preparing this bot for a much bigger use (which is why everything is
        //turned into "modules" ) i'd be passing this around as a future, but i'm lazy and doubt this bot will ever be used for much more than what it is currently.


        beetle.getLogger().debug("Launcher | Initializing DataCore Functionality!");

        WebSourceConfig webConf = new WebSourceConfig.Builder()
                .setDatabaseName(config.databaseName())
                .setDialect("mariadb")
                .setDatabaseUser(config.databaseUser())
                .setHostLocation(config.databaseHost())
                .setPassword(config.databasePassword())
                .setPluginName("QTeamBot")
                .setPort(config.databasePort())
                .build();

        CoreSource source = new HikariCoreSourceFactory(webConf,false).getCoreSource();
        DataCore dataCore = beetle.getDataCoreFactory().produceDatacore(source);

        beetle.getLogger().debug("Launcher | Initialized DataCore successfully! (?)");

        beetle.getLogger().debug("Launcher | Initializing Flyway!");

        Flyway flyway = Flyway.configure(Launcher.class.getClassLoader())
                .dataSource(source.getAdapter())
                .locations("classpath:sql-schema")
                .validateMigrationNaming(true).group(true)
                .load();

        beetle.getLogger().debug("Launcher | Initializing SpecificLauncher");

        new QTeamBotLauncher(beetle,dataCore,discordApi).launch();
    }

}
