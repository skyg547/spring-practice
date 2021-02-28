package study.cli.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cli.vaildation.Person;
import study.cli.vaildation.PersonForm;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@Service
public class MyService {

    @Autowired
    private Validator validator;// 인스턴스 가져오기

    public void check(){
        PersonForm personForm = new PersonForm("fastcampus",200);// 생성
        Set<ConstraintViolation<PersonForm>> result =  validator.validate(personForm , PersonForm.class); //유효성 검사 실시

        if(result.isEmpty()){

            log.info("validate 서공 ");
        }else {
            log.error("validate 실패");
        }
    }
}
