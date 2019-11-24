package com.utils;

import com.github.seratch.jslack.Slack;

public interface SlackConfiugration {

    public String accessToken = "xoxb-838658968097-846832284325-j180k4SiSmge8aFTmljkDbjm";//"xoxp-838658968097-848793571190-846364378852-ddcafc83d38430c5b3e6e7be51ba0112";
    public String botAccesstoken = "xoxb-838658968097-846832284325-j180k4SiSmge8aFTmljkDbjm";
    public String signingSecret = "7181c2b639dcd75f429c12651ab1f299";
    public Slack slack = Slack.getInstance();
}
