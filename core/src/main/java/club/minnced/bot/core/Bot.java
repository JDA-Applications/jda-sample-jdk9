/*
 *     Copyright 2016 - 2017 Florian Spieß
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package club.minnced.bot.core;

import club.minnced.bot.handle.MessageListener;
import club.minnced.bot.handle.ReadyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Bot
{
    public static void main(String[] args)
        throws LoginException, IOException
    {
        new Bot().init();
    }

    public void init()
        throws LoginException, IOException
    {
        Properties tokens = loadConfig("/tokens.properties");
        new JDABuilder(AccountType.BOT)
                .setToken(tokens.getProperty("bot"))
                .addEventListeners(new ReadyListener(), new MessageListener())
                .build();
    }

    private Properties loadConfig(String name)
        throws IOException
    {
        InputStream in = getClass().getModule().getResourceAsStream(name);
        Properties props = new Properties();
        props.load(in);
        return props;
    }
}
