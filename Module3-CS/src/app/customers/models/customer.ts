import { CustomerType } from './customer-type.enum';

export interface ICustomer {
    id: string;
    name: string;
    birthday: Date;
    email: string;
    idCard: string;
    phone: string;
    type: CustomerType;
}
