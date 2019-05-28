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

package club.minnced.bot.handle;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListener implements EventListener
{
    private static final Logger LOG = LoggerFactory.getLogger("Chat");

    @Override
    public void onEvent(GenericEvent event)
    {
        if (event instanceof MessageReceivedEvent)
            onMessage((MessageReceivedEvent) event);
    }

    // called by onEvent
    private void onMessage(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        LOG.info(String.format("%#10.10s %#10.10s < %.45s >", event.getChannel(), event.getAuthor(), event.getMessage()));
    }
}
