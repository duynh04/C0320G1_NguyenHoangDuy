package commons;


import java.util.Comparator;

public interface IData {
    String[] gatherInfo();
    IData splitInfo(String[] data);
    void showInfo();
}
