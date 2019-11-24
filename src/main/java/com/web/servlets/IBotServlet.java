package com.web.servlets;

import com.github.seratch.jslack.app_backend.events.EventsDispatcher;
import com.github.seratch.jslack.app_backend.events.servlet.SlackEventsApiServlet;
import com.web.handlers.IBotMessageHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IBotServlet extends SlackEventsApiServlet {

    @Override
    protected void setupDispatcher(EventsDispatcher eventsDispatcher) {
        eventsDispatcher.register(new IBotMessageHandler());
    }

    @Override
    protected String getSlackSigningSecret() {
        return "7181c2b639dcd75f429c12651ab1f299";
    }
}
