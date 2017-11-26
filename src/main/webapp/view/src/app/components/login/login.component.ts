import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../services/login.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private login: FormGroup;
  private id: Number;

  constructor(private loginService: LoginService) {}

  ngOnInit() {
    this.login = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
//    this.loginService.login(this.login).subscribe((data) => {
//      console.log(data);
//    });
  }

  loginAdmin({value, valid}: {value: Login, valid: boolean}) {
    console.log(this.login);
  }

}
export interface Login {
  username: String;
  password: String;
}
