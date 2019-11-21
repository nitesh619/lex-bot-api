package com.service;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.dao.IUserDao;
import com.request.BotTextRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotServiceImpl implements IBotService {

    @Autowired
    private IUserDao teamDao;


    @Override
    public String sendRequestToLex(BotTextRequest request) {
        AmazonLexRuntime lexClient = AmazonLexRuntimeClientBuilder.standard()
                .withRegion("us-east-1")
                .build();
        PostTextRequest textRequest = createRequest();
        textRequest.setInputText(request.getInputText());
        PostTextResult textResult = lexClient.postText(textRequest);
        return textResult.getMessage();
    }

    private PostTextRequest createRequest() {
        PostTextRequest textRequest = new PostTextRequest();
        textRequest.setBotName("LEXBOT");
        textRequest.setBotAlias("lexdoit");
        textRequest.setUserId("njain");
        return textRequest;
    }
}
