package com.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotTextRequest extends BaseRequest {

    String inputText;
    String userId;
}
