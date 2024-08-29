package org.example.slack_birthday;

import com.slack.api.Slack;
import com.slack.api.model.Attachment;
import com.slack.api.model.Field;
import com.slack.api.model.block.LayoutBlock;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.slack.api.webhook.WebhookPayloads.payload;

@Getter
@Slf4j
@RequiredArgsConstructor
@Component
public class SlackMessage {

    private final Slack slackClient = Slack.getInstance();

    @Value("${webhook-uri}")
    private String webhookUrl;
//
//    LayoutBlock layoutBlock = new LayoutBlock() {
//        @Override
//        public String getType() {
//            return null;
//        }
//
//        @Override
//        public String getBlockId() {
//            return null;
//        }
//    };

    public void sendSlackMessage(String name) {
        try {

            slackClient.send(webhookUrl, payload(p -> p
                    .text("🎉 *Happy Birthday, " + name + "!* 🎉")
                    .attachments(
                            List.of(generateSlackAttachment(name, "#36a64f"))
                    )
            ));
        } catch (IOException slackError) {
            log.debug("Slack 통신과의 예외 발생");
        }
    }

    // attachment 생성 메서드
    private Attachment generateSlackAttachment(String name, String color) {
        String requestTime = DateTimeFormatter.ofPattern("MM-dd").format(LocalDateTime.now());
        return Attachment.builder()
                .color(color)  // 왼쪽 띠의 색
                .title(requestTime + " - 🎂 생일 축하 🎂")
                .text("오늘은 " + name + "님의 특별한 날입니다! 🎉")
                .footer("생일 축하 메시지 | Slack Bot")
                .footerIcon("https://image.flaticon.com/icons/png/512/888/888879.png")
                .ts(String.valueOf(System.currentTimeMillis() / 1000))
                .imageUrl("https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExY2J4cDY4czAxaGFyb3p3YTA5bXFvZ3FoeXhvd2pod3FscmpxNmhjbCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/g5R9dok94mrIvplmZd/giphy.webp")
                .fields(List.of(
                        generateSlackField("생일 축하", name),
                        generateSlackField("축하 메시지", "오늘 하루도 멋지게 보내세요! 🎉")
                ))
                .build();
    }

    // Field 생성 메서드
    private Field generateSlackField(String title, String value) {
        return Field.builder()
                .title(title)
                .value(value)
                .valueShortEnough(true)
                .build();
    }
}
