package study;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BeanScopeTest {


//    @Test
//    public void testIdentity(){
//
//        //동일성 (identity): 객체 주소 같다. - obj1 == obj2 ==obj3) == true
//        //동등성 (equals): 객체의 값이 같다.  - (obj.equals(obj2)) 체크
//        A a1 = new A();
//        A a2 = a1;
//        Assert. assertTrue(a1 == a2);
//
//    }

    @Test
    void testEquals(){
        A a1 = new A(10,"Hello world");
        A a2 = new A(10,"Hello world");
        A a3 = new A(5,"Hello world");

        Assertions.assertEquals(a1,a2);
        Assert.assertFalse(a1.equals(a3));

    }
}

@EqualsAndHashCode
@AllArgsConstructor
class A {

    private int a1;
    private String a2;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return a1 == a.a1 && Objects.equals(a2, a.a2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1, a2);
    }
}