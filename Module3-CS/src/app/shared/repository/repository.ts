import { Observable } from 'rxjs';
import { Specification } from '../specification';

export interface CRUDRepository<T> {
    getAll: () => Observable<T[]>;
    findById: (_id: string) => Observable<T | null>;
    findByEmail?: (_email: string) => Observable<T | null>;
    findBySpec?: (specs: Specification) => Observable<T[] | null>;
    add?: (obj: T) => Observable<T>;
    update?: (obj: T) => Observable<T>;
    delete?: (_id: string) => Observable<T>;
}