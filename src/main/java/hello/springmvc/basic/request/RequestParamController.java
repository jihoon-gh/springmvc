package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller

public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge){

        log.info("username={}, age={}",memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age){

        log.info("username={}, age={}",username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4( String username, int age){ //단순 타입만 RequestParam 생략 가능

        log.info("username={}, age={}",username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){ //단순 타입만 RequestParam 생략 가능
        //null 이랑 "" 이랑 다름. @NotEmpty. "      " 은 @NotBlank

        log.info("username={}, age={}",username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age){ //단순 타입만 RequestParam 생략 가능
        // defaultValue를 생성할 경우 "" 라는 빈 문자가 들어와도 defaultValue 값 가져옴
        log.info("username={}, age={}",username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}",paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        //@ModelAttribute 생략 가능. 근데 @RequestParam 도 생략 가능한데 어떻게 구분??
        //-> String, int, Integer 등 단순한 타입 -> @RequestParam 적용
        //그 외에는 @ModelAttribute 적용
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }

}
