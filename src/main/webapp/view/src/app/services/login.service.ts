import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from '../models/login';

@Injectable()
export class LoginService {

  constructor(public http: HttpClient) {

  }

  login(login: Login) {
    return this.http.post('http://localhost:8080/' + login.role + '/login', login);
  }

  logout() {
    sessionStorage.clear();
  }
}
