package models;

public class Room extends Service {
    private String freeService;

    public Room() {}

    public Room(String id, String typeName, double area, double price, int maxPeople, String rentType, String freeService) {
        super(id, typeName, area, price, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfo() {
        System.out.printf("Service Type: %s, Area: %.2f m2, Price: %.2f $, Max: %d person(s), Free service: %s\n",
                            super.getTypeName(),
                            super.getArea(),
                            super.getPrice(),
                            super.getMaxPeople(),
                            freeService);
    }

    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 7;
        String[] data = new String[NUM_OF_FIELD];
        data[0] = super.getId();
        data[1] = super.getTypeName();
        data[2] = Double.toString(super.getArea());
        data[3] = Double.toString(super.getPrice());
        data[4] = Integer.toString(super.getMaxPeople());
        data[5] = super.getRentType();
        data[6] = getFreeService();
        return data;
    }
    @Override
    public Room splitInfo(String[] data) {
        Room room = new Room();
        room.setId(data[0]);
        room.setTypeName(data[1]);
        room.setArea(Double.parseDouble(data[2]));
        room.setPrice(Double.parseDouble(data[3]));
        room.setMaxPeople(Integer.parseInt(data[4]));
        room.setRentType(data[5]);
        room.setFreeService(data[6]);
        return room;
    }
}
