package com.controller;

import com.request.BotTextRequest;
import com.response.BotResponse;
import com.response.ServiceResponse;
import com.service.IBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/bot")
public class BotController {

    @Autowired
    IBotService botService;

    @RequestMapping(value = "/text", produces = "application/JSON", method = RequestMethod.POST)
    public ServiceResponse<BotResponse> createTeam(@RequestBody BotTextRequest request) {
        BotResponse res = new BotResponse();

        String lexResponse = botService.forwardMessageToLex(request);
        res.setResponseText(lexResponse);
        ServiceResponse<BotResponse> response = new ServiceResponse<>();
        response.setResponse(res);
        return response;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void creatTeam() {
        System.out.println("received");
    }
}
