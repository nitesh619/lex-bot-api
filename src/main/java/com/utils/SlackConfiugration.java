package com.utils;

import com.github.seratch.jslack.Slack;

public interface SlackConfiugration {

    String accessToken = "xoxb-838658968097-846832284325-TA8j6mnV0ISnCcTq9kSAH0eD";
    //"xoxb-838658968097-846832284325-j180k4SiSmge8aFTmljkDbjm";//"xoxp-838658968097-848793571190-846364378852-ddcafc83d38430c5b3e6e7be51ba0112";
    String botAccesstoken = "xoxb-838658968097-846832284325-TA8j6mnV0ISnCcTq9kSAH0eD";
    String signingSecret = "7181c2b639dcd75f429c12651ab1f299";
    Slack slack = Slack.getInstance();
}
