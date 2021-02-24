package me.aurium.qteambot;

import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.core.datacore.DataCore;

public class QTeamBot {

    private final DataCore operatingDataCore;
    private final Beetle beetle;

    QTeamBot(Beetle beetle, DataCore dataCore) {
        this.beetle = beetle;
        this.operatingDataCore = dataCore;
    }

    public void debug() {
        beetle.getLogger().error("QTeamBot - Java online!");
    }

}
