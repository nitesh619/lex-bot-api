package com.web.handlers;

import com.dao.IUserDao;
import com.entity.User;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.api.model.event.MessageEvent;
import com.github.seratch.jslack.app_backend.events.handler.MessageHandler;
import com.github.seratch.jslack.app_backend.events.payload.MessagePayload;
import com.request.BotTextRequest;
import com.service.BotServiceImpl;
import com.service.IBotService;
import com.utils.SlackConfiugration;
import java.io.IOException;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@NoArgsConstructor
@Service
public class BotMessageHandler extends MessageHandler implements SlackConfiugration {

    private IBotService botService = new BotServiceImpl();

    @Autowired
    private IUserDao userDao;

    @Override
    public void handle(MessagePayload messagePayload) {
        log.info("messagePayload - {}", messagePayload.toString());
        if (slack == null) {
            log.debug("seems like the slack instance hasnt been initialized");
        }
        MessageEvent event = messagePayload.getEvent();
        try {
            if (event.getUser() != null || !event.getSubtype().equalsIgnoreCase("bot_message")) {
                String userInputText = event.getText();
                String lexResponseText = botService
                        .forwardMessageToLex(new BotTextRequest(userInputText, event.getUser()));
                botReplyToSlack(lexResponseText, event.getChannel());
//                saveEntity(event, userInputText, lexResponseText);
            } else {
                log.debug("seems like this was the bot message event, so ignore processing...");
            }
        } catch (IOException ioe) {
            log.error("IOException while processing appMentionPayload - \n{}");
        } catch (SlackApiException sae) {
            log.error("SlackApiException while processing appMentionPayload - \n{}");
        }
    }

    private void saveEntity(final MessageEvent event, final String userInputText,
            final String lexResponseText) {
        User user = new User();
        user.setReplyText(userInputText);
        user.setRequestText(lexResponseText);
        user.setUserName(event.getUsername());
        userDao.save(user);
    }

    private void botReplyToSlack(final String replyText, final String channel)
            throws IOException, SlackApiException {
        ChatPostMessageResponse chatPostMessageResponse = slack.methods().chatPostMessage(
                ChatPostMessageRequest.builder()
                        .token(accessToken)
                        .channel(channel)
                        .text(Optional.ofNullable(replyText).orElse("").isEmpty()
                                ? "It doesn't look like anything to me!"
                                : replyText)
                        .build()
        );
    }
}
