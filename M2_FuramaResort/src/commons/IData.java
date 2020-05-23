package commons;


import java.util.Comparator;

public interface IData {
    String[] gatherInfo();
    default IData splitInfo(String[] data) {
        return null;
    }
    default void showInfo() {}
}
