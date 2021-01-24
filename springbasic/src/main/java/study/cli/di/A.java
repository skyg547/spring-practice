package study.cli.di;

public class A {
////    private boolean condittion;
//    // A와 B의 결합도가 높다
//    private B b;
//
//    public B getB() {
//        return b;
//    }
//
//    public void setB(B b) {
//        this.b = b;
//    }
//
//    public A(B b) {
//        this.b = b;
//    }
//
//
////    public A(boolean condoiton) {
////        condittion = condoiton;
////        this.b = new B(condittion);
////    } - 복잡도 증가가
//
//   public void print() {
//
//        System.out.println(b.calc());
//    }

    private B b = new B();

    public  void print(){

        b.print();
    }
}
