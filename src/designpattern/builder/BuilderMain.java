package designpattern.builder;

public class BuilderMain {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("500GB", "2GB")
                .bluetooth(true)
                .CPU("i5")
                .graphicCard("GTX")
                .build();

        System.out.println(computer.getCPU());
        System.out.println(computer.getGraphicCard());
        System.out.println(computer.isGraphicCardEnable());
    }
}
