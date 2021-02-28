package study.cli.vaildation;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Person person = new Person("", 200);
        PersonValidator validator = new PersonValidator();

        if (validator.supports(person.getClass())) {



        } else{

            log.error("invaild class ");
        }
    }
}
