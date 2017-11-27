import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Admin} from '../models/admin';

@Injectable()
export class AdminService {

  constructor(public http: HttpClient) {}

  getAdmin(id: Number) {
    return this.http.get('http://localhost:8080/admin/' + id);
  }
}
