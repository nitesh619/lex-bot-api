package com.service;

import com.request.BotTextRequest;

public interface IBotService {

    String forwardMessageToLex(BotTextRequest request);
}
