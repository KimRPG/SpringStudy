package org.example.slack_birthday;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class BirthdaySchedule {
    private final SlackMessage slackMessage;
    //@Scheduled(cron = "* * * * * *", zone = "Asia/Seoul") 시간대를 설정 한다. 미설정 시 로컬 시간대가 적용된다.
    //@Scheduled(cron = "* * * * * *") (초(0-59), 분(0-59), 시간(0-23), 일(1-31), 월(1-12), 요일(1-7, 1:일, 7:토))
    @Scheduled(cron = "30 * * * * *")
    public void schedule() {
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));
        System.out.println(now);
        slackMessage.sendSlackMessage("김현승");
        System.out.println("zzzzz");
    }
}
