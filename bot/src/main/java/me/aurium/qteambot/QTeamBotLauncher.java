package me.aurium.qteambot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.config.FileSourceConfigProducer;
import me.aurium.beetle.core.datacore.CoreSource;
import me.aurium.beetle.core.datacore.DataCore;
import me.aurium.beetle.core.datacore.FileCoreSourceFactory;
import me.aurium.beetle.core.datacore.FileSourceConfig;

public class QTeamBotLauncher {

    private final Beetle beetle;

    public QTeamBotLauncher(Beetle beetle) {
        this.beetle = beetle;
    }

    public QTeamBot launch() {
        beetle.getLogger().error("QTeamBot - Launcher Online! Beginning launch cycle!");

        FileSourceConfig config = beetle.getFileProvider().getDataHolder(new FileSourceConfigProducer("password","username"),"database.db");

        CoreSource source = new FileCoreSourceFactory.H2(config).getCoreSource();

        DataCore dataCore = beetle.getDatacoreFactory().produceDatacore(source);

        return new QTeamBot(beetle,dataCore);

    }


}
