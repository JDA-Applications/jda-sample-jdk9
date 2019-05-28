module club.minnced.bot.core {
    requires net.dv8tion.jda;
    requires slf4j.api;
    requires logback.classic;
    requires club.minnced.bot.handle;

    exports club.minnced.bot.core;
    opens club.minnced.bot.core;
}