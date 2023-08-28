package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("time")
    public String nowTim(Model model) {
//        Instant instant = new Date().toInstant();
//        System.out.println(instant);
//
//        LocalTime localTime = LocalTime.from(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        String formatted = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localTime);
//        System.out.println(formatted);
////        String formatNow = localTime.format(format);
////        System.out.printf("현재시간 %s",formatNow);
////        model.addAttribute("data", formatNow);
//        model.addAttribute("data", formatted);
        return "nowTime";
    }


}
