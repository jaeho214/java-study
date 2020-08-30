package designpattern.builder;


public class Computer {

    private String HDD;
    private String RAM;
    private String graphicCard;
    private String CPU;

    private boolean isGraphicCardEnable;
    private boolean isBluetoothEnable;

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public boolean isGraphicCardEnable() {
        return isGraphicCardEnable;
    }

    public void setGraphicCardEnable(boolean graphicCardEnable) {
        isGraphicCardEnable = graphicCardEnable;
    }

    public boolean isBluetoothEnable() {
        return isBluetoothEnable;
    }

    public void setBluetoothEnable(boolean bluetoothEnable) {
        isBluetoothEnable = bluetoothEnable;
    }



    public Computer(Builder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.graphicCard = builder.graphicCard;
        this.CPU = builder.CPU;
        this.isGraphicCardEnable = builder.isGraphicCardEnable;
        this.isBluetoothEnable = builder.isBluetoothEnable;
    }

    public static class Builder{
        private String HDD;
        private String RAM;
        private String graphicCard;
        private String CPU;

        private boolean isGraphicCardEnable;
        private boolean isBluetoothEnable;

        public Builder(String HDD, String RAM){
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public Builder graphicCard(String graphicCard){
            this.graphicCard = graphicCard;
            return this;
        }

        public Builder CPU(String CPU){
            this.CPU = CPU;
            this.isGraphicCardEnable = true;
            return this;
        }

        public Builder bluetooth(boolean isBluetoothEnable){
            this.isBluetoothEnable = isBluetoothEnable;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }


    }
}
