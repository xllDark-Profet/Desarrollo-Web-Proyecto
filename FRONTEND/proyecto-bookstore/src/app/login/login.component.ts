import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { user } from './user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

form:FormGroup
userLogin:user  
userAuth:user

constructor(private fb:FormBuilder, private loginService: LoginService,public router: Router ) { 
  this.form=this.fb.group({
    email:['', Validators.required],
    password:['', Validators.required]
  });
  this.userLogin= new user("", "");
  this.userAuth= new user("", "");
}

ngOnInit(): void {
}

login(){
  const val=this.form.value
  this.userLogin.setUsername(val.email)
  this.userLogin.setPassword(val.password)

  console.log("Email: "+  val.email);
  console.log("Contrasena: "+ val.password);

  this.loginService.login(this.userLogin).subscribe(data=> {
    console.log(data);
    this.loginService.setToken(data.token);
    console.log(data);
    this.router.navigateByUrl('');
  });
}

}
