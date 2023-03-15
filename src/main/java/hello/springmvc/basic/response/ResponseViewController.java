package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView(){
        ModelAndView mv = new ModelAndView("response/hello")
                .addObject("data","hello!");

        return mv;
    }

    //@ResponseBody 가 있으면, http 메세지 바디에 반환값이 문자열로 들어감
    //없으면, 뷰 리졸버가 주어진 or 반환된 뷰의 논리 이름을 통해 실제 뷰의 물리 이름을 찾고, 그거 렌더링 함.
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    //void 반환하는 경우, 요청 url 을 뷰 경로로 찾아서 렌더링 함. 하지만 명시성이 떨어지니까 사용 많이 하지 말자.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }
}
