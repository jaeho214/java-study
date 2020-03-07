package designpattern.factoryMethod;
/*
 * 팩토리 메소드 패턴 : 객체 생성을 대신 수행해주는 공장 개념. 간접적으로 객체를 생성 후 반환해줌
 * 장점 : 생성할 클래스를 몰라도 팩토리 클래스가 객체 생성을 담당해줌
 *        동일한 형태로 프로그래밍이 가능해진다
 *        확장성 있는 전체 프로젝트 구성이 가능하다
 * 단점 : 객체가 늘어날 때마다 하위클래스 재정의로 불필요한 많은 클래스 생성 가능성
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = factory.getShape("Square");
        shape2.draw();

        Shape shape3 = factory.getShape("RECtangle");
        shape3.draw();

    }
}
