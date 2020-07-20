import { FacilityType } from './facility-type.enum';

export interface IFacility {
    id: string;
    name: string;
    area: number;
    floor: number;
    persons: number;
    price: number;
    type: FacilityType
}