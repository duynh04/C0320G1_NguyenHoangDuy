package commons;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import models.*;

import java.io.*;
import java.util.*;

public class CsvFile {
    private static final String PATH = "src\\data\\";
    private static final String CUSTOMER_CSV = "Customer.csv";
    private static final String ROOM_CSV = "Room.csv";
    private static final String VILLA_CSV = "Villa.csv";
    private static final String HOUSE_CSV = "House.csv";
    private static final String BOOKING_CSV = "Booking.csv";
    private static final String EMPLOYEE_CSV = "Employee.csv";
    private static final String[] VILLA_HEADER = {"Id", "Name Service", "Area", "Price", "Max People", "Type Rent", "Room Standard", "Facility", "Storey", "Pool Area"};
    private static final String[] HOUSE_HEADER = {"Id", "Name Service", "Area", "Price", "Max People", "Type Rent", "Room Standard", "Facility", "Storey"};
    private static final String[] ROOM_HEADER = {"Id", " Name Service", "Area", "Price", "Max People", "Type Rent", "Free Service"};
    private static final String[] CUSTOMER_HEADER = {"Id", "Customer Name", "Id Card", "Birthday", "Gender", "Phone Number", "Email", "Type Customer", "Address"};
    private static final String[] EMPLOYEE_HEADER = {"Id", "Employee Name", "Age", "Address"};
//    private static final String[] BOOKING_HEADER = {"Id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address", "idService", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent",};
    private static final String[] BOOKING_HEADER = {"Id", "CustomerId", "ServiceId"};


    // static block to create csv file
    static {
        if(createFile(VILLA_CSV))
            createHeader(VILLA_CSV, VILLA_HEADER);
        if(createFile(HOUSE_CSV))
            createHeader(HOUSE_CSV, HOUSE_HEADER);
        if(createFile(ROOM_CSV))
            createHeader(ROOM_CSV, ROOM_HEADER);
        if(createFile(CUSTOMER_CSV))
            createHeader(CUSTOMER_CSV, CUSTOMER_HEADER);
        if(createFile(BOOKING_CSV))
            createHeader(BOOKING_CSV, BOOKING_HEADER);
        if(createFile(EMPLOYEE_CSV))
            createHeader(EMPLOYEE_CSV, EMPLOYEE_HEADER);
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
    public static <T extends IData> void write(T service) {
        LinkedList<String[]> originData;
        String[] newData = service.gatherInfo();
        String fileName = "";
        String uniqueCode = "";
        if(service instanceof Room) {
            fileName = ROOM_CSV;
            uniqueCode = "RO";
        } else if (service instanceof House) {
            fileName = HOUSE_CSV;
            uniqueCode = "HO";
        } else if (service instanceof Villa) {
            fileName = VILLA_CSV;
            uniqueCode = "VL";
        } else if(service instanceof Customer) {
            fileName = CUSTOMER_CSV;
            uniqueCode = "CUS";
        } else if(service instanceof Booking) {
            fileName = BOOKING_CSV;
            uniqueCode = "BO";
        } else if(service instanceof Employee) {
            fileName = EMPLOYEE_CSV;
            uniqueCode = "EM";
        }
        // set ID
        originData = (LinkedList<String[]>)readAllFile(fileName);
        if (originData.size() == 0) {
            newData[0] = uniqueCode + "1";
        } else {
            String getID = originData.get(originData.size() - 1)[0].replaceAll("\\D+", "");
            newData[0] = uniqueCode + (Integer.parseInt(getID) + 1);

        }
            write(fileName, newData);
    }

    /**
     * read all csv file
     * @param fileName csv file
     * @return string[] of csv file
     */
    private static List<String[]> readAllFile(String fileName) {
        List<String[]> lst = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH + fileName));
            lst =  csvReader.readAll();
            lst.remove(0);
        } catch (CsvException | IOException e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    @SuppressWarnings("unchecked")
    public static <T extends IData> Collection<T> read(T service, boolean duplicate) {
        List<String[]> list = null;
        Collection<T> info;
        if (!duplicate)
            info = new TreeSet<>();
        else
            info = new ArrayList<>();
        if (service instanceof Room) {
            list = readAllFile(ROOM_CSV);
        } else if (service instanceof House) {
            list = readAllFile(HOUSE_CSV);
        } else if (service instanceof Villa) {
            list = readAllFile(VILLA_CSV);
        } else if(service instanceof Customer) {
            list = readAllFile(CUSTOMER_CSV);
        } else if(service instanceof Employee) {
            list = readAllFile(EMPLOYEE_CSV);
        }
        // transfer string to
        if(list != null) {
            for (String[] data : list) {
                if(data != null) {
                    info.add((T) service.splitInfo(data));
                }
            }
        }
        return info;
    }
}

