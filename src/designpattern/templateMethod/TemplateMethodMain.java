package designpattern.templateMethod;
/*
 * 템플릿 메소드 패턴 : 어떤 소스코드 상의 알고리즘에서 특정 환경 또는 상황에 맞게 확장 또는 변경해야할 경우 매우 유용한 패턴
 *                     추상클래스와 구현클래스로 작성할 수 있으며 메인이 되는(빈번하고 공통적으로 사용되는) 로직 부분은 추상클래스의 일반메소드로 선언해서 사용하고
 *                     구현별로 달라질 수 있는 로직들은 구현 클래스에서 오버라이딩해서 사용하는 방식
 *
 * 장점 : 코드 중복 감소
 *        하위 클래스의 역할을 줄이고 핵심 로직 관리가 용이
 *        객체 추가 및 확장이 용이
 * 단점 : 추상 메소드가 많아지면 클래스 관리가 복잡
 *        추상 클래스와 구현 클래스간의 복잡성이 증대
 */
public class TemplateMethodMain {

    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();

        System.out.println();
        System.out.println("===============");
        System.out.println();

        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
