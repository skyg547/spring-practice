package study.cli.vaildation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}
