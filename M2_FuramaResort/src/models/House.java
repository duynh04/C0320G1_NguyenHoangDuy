package models;

public class House extends Service {
    private String roomStandard;
    private String facilities;
    private int storey;

    public House() {}

    public House(String id, String typeName, double area, double price, int maxPeople, String rentType, String roomStandard, String facilities, int storey) {
        super(id, typeName, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.facilities = facilities;
        this.storey = storey;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    @Override
    public void showInfo() {
        System.out.printf("Service Type: %s\nStandard: %s star(s)\nArea: %.2f m2\nPrice: %.2f $\nMax: %d person(s)\nFloor : %s storey(s)",
                super.getTypeName(),
                roomStandard,
                super.getArea(),
                super.getPrice(),
                super.getMaxPeople(),
                storey);
    }

    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 9;
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
        return data;
    }
}
