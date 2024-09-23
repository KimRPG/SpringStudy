package org.example.slack_birthday;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class SlackBot {
    @Bean
    public App initSlackApp(){
        App app = new App();
        app.command("/hello",(req,ctx)->ctx.ack("Hi there!"));
        return app;
    }


}
