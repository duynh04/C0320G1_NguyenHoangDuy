package models;

public class Villa extends Service {
    private String roomStandard;
    private String facilities;
    private int storey;
    private double swimmingPoolArea;

    public Villa() {}

    public Villa(String id, String typeName, double area, double price, int maxPeople, String rentType, String roomStandard, String facilities, int storey, double swimmingPoolArea) {
        super(id, typeName, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.facilities = facilities;
        this.storey = storey;
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    @Override
    public void showInfo() {
        System.out.printf("Service Type: %s, Standard: %s star(s), Area: %.2f m2, Price: %.2f $, Max: %d person(s), Floor : %s storey(s)\n",
                super.getTypeName(),
                roomStandard,
                super.getArea(),
                super.getPrice(),
                super.getMaxPeople(),
                storey);
    }

    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 10;
        String[] data = new String[NUM_OF_FIELD];
        data[0] = super.getId();
        data[1] = super.getTypeName();
        data[2] = Double.toString(super.getArea());
        data[3] = Double.toString(super.getPrice());
        data[4] = Integer.toString(super.getMaxPeople());
        data[5] = super.getRentType();
        data[6] = getRoomStandard();
        data[7] = getFacilities();
        data[8] = Integer.toString(getStorey());
        data[9] = Double.toString(getSwimmingPoolArea());
        return data;
    }

    @Override
    public Villa splitInfo(String[] data) {
        Villa villa = new Villa();
        villa.setId(data[0]);
        villa.setTypeName(data[1]);
        villa.setArea(Double.parseDouble(data[2]));
        villa.setPrice(Double.parseDouble(data[3]));
        villa.setMaxPeople(Integer.parseInt(data[4]));
        villa.setRentType(data[5]);
        villa.setRoomStandard(data[6]);
        villa.setFacilities(data[7]);
        villa.setStorey(Integer.parseInt(data[8]));
        villa.setSwimmingPoolArea(Double.parseDouble(data[9]));
        return villa;
    }

//    @Override
//    public int compareTo(Service o) {
//        return super.getTypeName().compareTo(o.getTypeName());
//    }
}
