package com.service;

import com.request.BotTextRequest;

public interface IBotService {

    String sendRequestToLex(BotTextRequest request);
}
