package study.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Map;

//@Slf4j
//public class A implements ApplicationContextAware {
//
//    // 콘테스트 가져와서 사용하기
////    private ApplicationContext applicationContext;
////
////    void init(){
////      log.error(">> "+ applicationContext);
////
////    }
////
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        this.applicationContext = applicationContext;
////    }
//}

@Component
@Slf4j
public  class A {

    // 콘텍스트도 가능 aware 인터페이스 대신 가능.
    @Autowired
    private ApplicationContext context;

//    @Value("#{systemProperties}") Map properties;
    @Value("#{systemProperties['java.home']}") String properties;
//    @Value("${catlog.name}") String catalogName;
    @Resource(name = "appBeanb1")
    //@Primary 같은 타입이면 먼저 선택
    @Autowired(required = false)
    @Qualifier("b1")// 퀄리 파이 등록된 같은 타입의 이름으로 등록록
    private B b;

    @PostConstruct // 생성자가 만들어질때
    void init(){

        log.info("A Post construct"+b);

    }

    @PreDestroy
    void destroy(){
        log.info("A predestroy");

    }

    @Autowired
    public A(B b){
        this.b = b;

    }

    @Autowired
    public B getB() {
        return b;
    }

    @Autowired
    public void setB(B b) {
        this.b = b;
    }
}