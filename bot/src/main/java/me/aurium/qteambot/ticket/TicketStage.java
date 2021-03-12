package me.aurium.qteambot.ticket;

public enum TicketStage {

    INITIAL_QUESTIONS, //phase where the bot is asking the initial questions.
    AWAITING_DEV, //phase where questions are finished and the bot is waiting for a developer to claim the ticket
    DEV_QUESTIONS, //phase where a dev has claimed the ticket and is asking questions. When the developer has finished asking questions they resolve this phase
    AWAITING_FIRST_HALF, //phase where bot waits for first half of 50/50 payment


    AWAITING_REVIEW,

    FAILED,
    FINISHED,

}
