package JspJstl.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birthday;
    private String address;
    private String urlImage;
    private static final List<Customer> list;
    public Customer() {
    }

    public Customer(String name, String birthday, String address, String urlImage) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.urlImage = urlImage;
    }

    static {
        list = new ArrayList<>();
        list.add(new Customer("Đặng Thanh Thảo","20-08-1983","Hà Nội","https://znews-photo.zadn.vn/w660/Uploaded/mdf_drkydd/2019_08_10/0.jpg"));
        list.add(new Customer("Nguyễn Minh Thư","21-08-1983","Bắc Giang","https://2.bp.blogspot.com/-fjf5yU5r1Jk/WE1VD1BBKpI/AAAAAAAAjgI/bXwGoigAPJYvScMPtzJtzbOJfoGQO2C_ACEw/s1600/15349541_533868826819201_3350340522319981193_n.jpg"));
        list.add(new Customer("Nguyễn Thị Quỳnh Trang","22-08-1983","Nam Định","https://1.bp.blogspot.com/-FHFovangASQ/W9ByiB8buUI/AAAAAAAADSc/03bYVGHJ_SMqIV03xuGRfAwRs5mVjApUQCEwYBhgL/s1600/Gai-xinh-mac-ao-dai-%2B%25281%2529.jpg"));
        list.add(new Customer("Trần Thị Ngọc Anh","17-08-1983","Hà Tây","https://thuthuatnhanh.com/wp-content/uploads/2019/11/anh-gai-xinh-kute-de-thuong-cap-3.jpg"));
        list.add(new Customer("Trần Thị Thu Thủy","19-08-1983","Hà Nội","https://hinhanhdephd.com/wp-content/uploads/2019/10/hinh-anh-hot-girl-nu-sinh-de-thuong-cute-2020-29.jpg"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    public static List<Customer> getList(){
        return list;
    }
}
