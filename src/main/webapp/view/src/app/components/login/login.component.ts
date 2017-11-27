import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private login: Login;
  private id: Number;

  constructor(private loginService: LoginService) {}

  ngOnInit() {
  }

  loginAdmin(login: Login) {

    this.loginService.login(login).subscribe((res) => {
      if (res === -1) {
        alert('login failed');
      } else {
        if (login.role === 'admin') {
          
        } else if (login.role === 'customer') {

        } else {

        }
      }
    });
  }

}
export interface Login {
  username: String;
  password: String;
  role: String;
}
