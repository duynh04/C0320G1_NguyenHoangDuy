export interface IContract {
    id: string;
    customerCode: string;
    employeeCode: string;
    facilityCode: string;
    date: {
        start: string;
        end: string;
    };
    price: {
        deposit: number;
        total: number;
    }
}