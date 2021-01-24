package study.cli;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration// 스프링 관련 빈이다, 빈 설정과 동시에
public class AppConfig {


    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    @Primary // 같은 타입  우선적 주입
    @Qualifier("b1")
    public B appBeanb1(){

        return  new B();

    }

    @Qualifier("b2")
    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    public B b2(){

        return  new B();

    }


}
