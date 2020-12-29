import {Injectable} from '@angular/core';
import {ICustomer} from '../../entities/ICustomer';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerList$!: Observable<ICustomer[]>;
  private ROOT_URL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {
  }

  getCustomerList(): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(`${this.ROOT_URL}/customers/`);
  }

  createCustomer(c: ICustomer): Observable<ICustomer> {
    return this.http.post<ICustomer>(`${this.ROOT_URL}/customers/`, c);
  }

  toggleFavorite(id: string): Observable<ICustomer> {
    return this.http.get<ICustomer>(`${this.ROOT_URL}/customers/${id}/favorite`);
  }


  deleteCustomer(id: string): Observable<boolean> {
    return this.http.delete<boolean>(`${this.ROOT_URL}/customers/${id}`);
  }

  findCustomer(id: string): Observable<ICustomer> {
    return this.http.get<ICustomer>(`${this.ROOT_URL}/customers/${id}`);
  }
}
