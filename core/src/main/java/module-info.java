module club.minnced.bot.core {
    requires JDA;
    requires slf4j.api;
    requires logback.classic;
    requires club.minnced.bot.handle;

    exports club.minnced.bot.core;
    opens club.minnced.bot.core;
}