class Customer {
    constructor(name, addr, id, dob, email, rentDays, persons, customerType, serviceType, typeRoom, discount) {
        this.name = name; 
        this.addr = addr;
        this.id = id; 
        this.dob = dob;
        this.email =  email;
        this.rentDays = rentDays;
        this.persons = persons;
        this.customerType = customerType; 
        this.serviceType = serviceType;
        this.typeRoom = typeRoom;
        this.discount = discount;
    }
    info() {
        alert("    Customer Infomation: " + "\n" +
            "Name: " + this.name + "\n" + 
            "Address: " + this.addr + "\n" + 
            "ID number: " + this.id + "\n" + 
            "DOB: " + this.dob + "\n" + 
            "Email: " + this.email + "\n" + 
            "Rent days: " + this.rentDays + "\n" + 
            "Persons: " + this.persons + "\n" + 
            "Customer: " + this.customerType + "\n" + 
            "Service: " + this.serviceType + "\n" + 
            "Room: " + this.typeRoom + "\n" + 
            "Discount: " + this.discount + "\n" ); 
    }
    modify(info, value) {
        switch(info) {
            case 1: this.name = value; break;
            case 2: this.addr = value; break;
            case 3: this.id = value; break;
            case 4: this.dob = value; break;
            case 5: this.email = value; break;
            case 6: this.rentDays = value; break;
            case 7: this.persons = value; break;
            case 8: this.customerType = value; break;
            case 9: this.serviceType = value; break;
            case 10: this.typeRoom = value; break;
            case 11: this.discount = value; break;
        }
    }
    charge() {
        let servicePrice = this.checkTypeOfService(this.serviceType);
        let totalPrice = servicePrice * this.rentDays * (1 - (this.discount) / 100);
        alert("Customer Infomation: " + "\n" +
            "Name: " + this.name + "\n" + 
            "ID number: " + this.id + "\n" + 
            "DOB: " + this.dob + "\n" + 
            "Address: " + this.addr + "\n" + 
            "Payment: " + totalPrice + "$ total.");
    }
    checkTypeOfService(type) {
        switch(type) {
            case 'villa':
                return 500;
            case 'house':
                return 300;
            case 'room':
                return 100;
        }
    }
}