package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic") //URL 호출이 오면 메서드가 실행됨, 두 개 넣을 수 있음 (OR 조건이 됨)
    public String helloBasic(){

        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }



    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=value")
    public String mappingHeader(@PathVariable String userId){
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping(value = "/mapping-consumes", consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }
}
