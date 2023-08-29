package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    // API방식
    @GetMapping("hello-string")
    @ResponseBody  // 거의 쓸 일 없음
    public String helloString(@RequestParam("name") String name) {
        return "heelo " + name;
    }


    /**
     * 반환타입이 객체인경우 json 방식으로 만들어서 반환 (기본정책)
     * JsonConveter 동작
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



//    @GetMapping("time")
//    public String nowTim(Model model) {
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
//        return "nowTime";
//    }


}
