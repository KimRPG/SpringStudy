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

    public void sendSlackMessage(String name, String part, String now) {
        try {

            slackClient.send(webhookUrl, payload(p -> p
                    .text("🎉 *Happy Birthday, " + name + "!* 🎉")
                    .attachments(
                            List.of(generateSlackAttachment(part,name, "#36a64f", now))
                    )
            ));
        } catch (IOException slackError) {
            log.debug("Slack 통신과의 예외 발생");
        }
    }

    // attachment 생성 메서드
    private Attachment generateSlackAttachment(String part,String name, String color, String requestTime) {
        String message = String.format("오늘은 %s의 %s님의 특별한 날입니다! 🎉", part, name);

        return Attachment.builder()
                .color(color)  // 왼쪽 띠의 색
                .title(requestTime + " - 🎂 생일 축하 🎂")
                .text(message)
                .footer("생일 축하 메시지 | Slack Bot")
                .footerIcon("https://image.flaticon.com/icons/png/512/888/888879.png")
                .ts(String.valueOf(System.currentTimeMillis() / 1000))
                .imageUrl("https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExY2J4cDY4czAxaGFyb3p3YTA5bXFvZ3FoeXhvd2pod3FscmpxNmhjbCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/g5R9dok94mrIvplmZd/giphy.webp")
                .fields(List.of(
                        generateSlackField("생일 축하", name),
                        generateSlackField("축하 메시지",
                                "⋆⸜⊹₊ \uD835\uDC07\uD835\uDC1A\uD835\uDC29\uD835\uDC29\uD835\uDC32 \uD835\uDC01\uD835\uDC22\uD835\uDC2B\uD835\uDC2D\uD835\uDC21\uD835\uDC1D\uD835\uDC1A\uD835\uDC32 ¨̮⑅*⸝⋆\n" +
                                "( * ॑꒳ ॑*)ﾉ\"┌iiii┐ヾ(* ॑꒳ ॑* )")
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
