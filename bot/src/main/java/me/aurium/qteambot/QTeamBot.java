package me.aurium.qteambot;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.api.datacore.DataCore;
import org.javacord.api.DiscordApi;

import java.sql.SQLException;

public class QTeamBot {

    private final DataCore operatingDataCore;
    private final Beetle beetle;
    private final DiscordApi api;

    QTeamBot(Beetle beetle, DataCore dataCore, DiscordApi discordApi) {
        this.beetle = beetle;
        this.operatingDataCore = dataCore;
        this.api = discordApi;
    }

    public void debug() {


        beetle.getLogger().error("Java online! Executing test: beetle taskrunner!");

        beetle.getLogger().error("Test 1: runTaskSync");
        beetle.getTasker().getRunner().runRunnableSync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        beetle.getLogger().error("Test 2: runTaskAsync");
        beetle.getTasker().getRunner().runRunnableAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        beetle.getLogger().error("Test 3: runTaskSync");
        beetle.getTasker().getRunner().runRunnableSync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        beetle.getLogger().error("Test 4: runTaskAsync");
        beetle.getTasker().getRunner().runRunnableAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        beetle.getLogger().error("Test 5: supplyAsync");
        beetle.getTasker().getRunner().supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName());

            return 3;
        });

        beetle.getLogger().error("Tests completed! Moving to next taskset: beetle datacore!");

        beetle.getLogger().error("Test 1: throw an exception!");

        operatingDataCore.runConsumer(transact -> {

            throw new SQLException("SQL had a stroke! Catch!");

        });

        beetle.getLogger().error("Tests completed!");

    }

}
