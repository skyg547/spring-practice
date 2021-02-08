package study.cli;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@ComponentScan(basePackageClasses = AppConfig.class)
//@ComponentScan(basePackages = "study.cli")// 컴포넌트를 스캔을 한다 패키지에서
@Configuration// 스프링 관련 빈이다, 빈 설정과 동시에
@PropertySource("classpath:application.properties") //설정에서 정한 값 가지고 오기
public class AppConfig {


    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    @Primary // 같은 타입  우선적 주입
    @Qualifier("b")
    public B appBeanb1(){

        return  new B();

    }

    @Qualifier("b2")
    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    public B b2(){

        return  new B();

    }


}
