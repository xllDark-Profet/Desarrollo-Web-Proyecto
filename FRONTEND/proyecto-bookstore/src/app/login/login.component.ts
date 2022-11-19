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
/**
 * Atributos componente
 */
form:FormGroup
userLogin:user  
userAuth:user
/**
 * Constructor de la clase 
 * @param fb 
 * @param loginService 
 * @param router 
 */
constructor(private fb:FormBuilder, private loginService: LoginService,public router: Router ) { 
  this.form=this.fb.group({
    email:['', Validators.required],
    password:['', Validators.required]
  });
  this.userLogin= new user("", "");
  this.userAuth= new user("", "");
}
/**
 * Metodo que no hace nada cuando se cargue la aplicacion 
 */
ngOnInit(): void {
}
/**
 * Este metodo se encarga de recuperar los valores del email y la contrasena y llamar al metodo del servicio 
 * que realiza la autenticacion y a su vez al que guarda el token en la cookie
 */
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
