import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Login} from '../components/login/login.component';

@Injectable()
export class LoginService {

  constructor(public http: HttpClient) {

  }

  login(login: Login) {
    return this.http.post('http://localhost:8080/' + login.role + '/login', login);
  }
}
