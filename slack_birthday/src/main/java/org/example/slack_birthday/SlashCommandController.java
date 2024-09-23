package org.example.slack_birthday;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SlashCommandController {
    private final SlackBot slackBot;

    @PostMapping("/slack/events")
    public void message(){
        slackBot.initSlackApp();
        System.out.println("hihi");
    }
}
