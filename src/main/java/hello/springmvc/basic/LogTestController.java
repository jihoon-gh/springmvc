package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //로거의 장점 : 로그를 상황에 맞게 조절할 수 있음.
@RestController
public class LogTestController {


    @GetMapping("/log-test")
    public String logTest(){
        String name = "Spring";

//        log.trace("trace log = "+ name); 이런 방식으로 쓸 경우, 연산이 일어남 -> 쓰지 않을 로그에 자원 사용
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.warn("warn log = {}", name);
        log.info("info log = {}", name);
        log.error("info error = {}", name);

        return "ok";
    }
}
