package models;

public abstract class Service {
    private String id;
    private String typeName;
    private double area;
    private double price;
    private int maxPeople;
    private String rentType;
    public abstract void showInfo();
    public abstract String[] gatherInfo();
    public abstract Service splitInfo(String[] data);

    public Service() {}

    public Service(String id, String typeName, double area, double price, int maxPeople, String rentType) {
        this.id = id;
        this.typeName = typeName;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
