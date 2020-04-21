class Employee {
    constructor(name, id, dob, email, phone, position) {
        this.name = name; 
        this.id = id; 
        this.dob = dob;
        this.email =  email;
        this.phone = phone;
        this.position = position;
    }
    info() {
        alert("    Employee Infomation: " + "\n" +
            "Name: " + this.name + "\n" + 
            "ID number: " + this.id + "\n" + 
            "DOB: " + this.dob + "\n" + 
            "Email: " + this.email + "\n" + 
            "Phone: " + this.phone + "\n" + 
            "Position: " + this.position + "\n" );
    }
    salary() {
        let getPosition = this.checkPosition();
        alert("Employee Infomation: " + "\n" +
            "Name: " + this.name + "\n" + 
            "ID number: " + this.id + "\n" + 
            "DOB: " + this.dob + "\n" + 
            "Salry: " + getPosition + "$");
    }
    checkPosition() {
        switch(this.position) {
            case 'manager':
                return 500;
            case 'sale':
                return 300;
            case 'marketing':
                return 200;
        }
    }
}