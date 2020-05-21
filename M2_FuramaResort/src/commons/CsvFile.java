package commons;
import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import models.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CsvFile {
    private static final String PATH = "src\\data\\";
    private static final String ROOM_CSV = "Room.csv";
    private static final String VILLA_CSV = "Villa.csv";
    private static final String HOUSE_CSV = "House.csv";
    private static final String[] VILLA_HEADER = {"Id", "Name Service", "Area", "Price", "Max People", "Type Rent", "Room Standard", "Facility", "Storey", "Pool Area"};
    private static final String[] HOUSE_HEADER = {"Id", "Name Service", "Area", "Price", "Max People", "Type Rent", "Room Standard", "Facility", "Storey"};
    private static final String[] ROOM_HEADER = {"Id", " Name Service", "Area", "Price", "Max People", "Type Rent", "Free Service"};
    public static void main(String[] args) {
        try {
            FileWriter wr = new FileWriter(PATH + "Test.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Service room = new Room("1", "room-vip", 20.5f, 1000, 2, "1", "Massage");
        Service house = new House("2", "House", 50f, 2000, 10, "2", "4", "Gym", 3);
        Service villa = new Villa("3", "VIlla", 80f, 5000, 20, "4", "5", "Gym-Swimming pool", 3, 50);
        CsvFile.write(villa);
        CsvFile.write(house);
        CsvFile.write(room);
    }
    // static block to create csv file
    static {
        if(createFile(VILLA_CSV))
            createHeader(VILLA_CSV, VILLA_HEADER);
        if(createFile(HOUSE_CSV))
            createHeader(HOUSE_CSV, HOUSE_HEADER);
        if(createFile(ROOM_CSV))
            createHeader(ROOM_CSV, ROOM_HEADER);
    }
    /**
     * create a csv file if it is not exist
     * @param name name of file.
     * @return true if file is created successfully.
     */
    private static boolean createFile(String name) {
        try {
            File obj = new File(PATH + name);
            return obj.createNewFile();
        } catch (IOException e) {
            System.out.println("Can not create csv file.");
        }
        return false;
    }

    /**
     * Create header csv file for the first time
     * @param fileName name of csv file
     * @param headerContent header content
     */
    private static void createHeader(String fileName, String[] headerContent) {
//        List<String[]> temp = new LinkedList<>();
//        temp.add(headerContent);
        write(fileName, headerContent);
    }

    /**
     *  write all line to csv file
     * @param fileName file name of csv
     * @param data a array of content written data.
     */
    private static void write(String fileName, String[] data) {
        try {
            FileWriter writer = new FileWriter(PATH + fileName, true);
            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeNext(data);
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("Error when write data into csv file");
        }
    }

    /**
     *  write many lines into csv file
     * @param fileName file name
     * @param data list data
     */
    public static void write(String fileName, List<String[]> data) {
        for (String[] dat: data ) {
            write(fileName,dat);
        }
    }

    /**
     * Write data into csv file
     * @param service written data
     */
    public static void write(Service service) {
//        List<String[]> originData = null;
        String[] newData = service.gatherInfo();
        String fileName = "";
        if(service instanceof Room) {
//            originData = readAllFile(ROOM_CSV);
            fileName = ROOM_CSV;
        } else if (service instanceof House) {
//            originData = readAllFile(HOUSE_CSV);
            fileName = HOUSE_CSV;
        } else if (service instanceof Villa) {
//            originData = readAllFile(VILLA_CSV);
            fileName = VILLA_CSV;
        }
//        if (originData != null) {
//            originData.add(newData);
            write(fileName, newData);
//        }
    }


    /**
     * read all csv file
     * @param fileName csv file
     * @return string[] of csv file
     */
    private static List<String[]> readAllFile(String fileName) {
        List<String[]> lst = null;
        try {
//            FileReader reader = new FileReader(PATH + fileName);
            CSVReader csvReader = new CSVReader(new FileReader(PATH + fileName));
            lst =  csvReader.readAll();
            if (lst == null) {
                System.out.println("this is null");
            }
        } catch (CsvException | IOException e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static List<Villa> read(Villa service) {
        String[] columns = {};
        String fileName = "";
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
//        if (service instanceof House) {
////            strategy.setType(House.class);
//            columns = HOUSE_HEADER;
//            fileName = HOUSE_CSV;
//        } else if (service instanceof Villa) {
//            strategy.setType(Villa.class);
            columns = VILLA_HEADER;
            fileName = VILLA_CSV;
//        } else if (service instanceof Room) {
////            strategy.setType(Room.class);
//            columns = ROOM_HEADER;
//            fileName = ROOM_CSV;
//        }
        strategy.setColumnMapping(columns);
        try {
            FileReader reader = new FileReader(PATH + fileName);
            CsvToBean<Villa> csvToBean = new CsvToBeanBuilder<Villa>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Villa> lst = csvToBean.parse();
            for (Villa dat : lst) {
                System.out.println(dat);
            }
            return lst;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

