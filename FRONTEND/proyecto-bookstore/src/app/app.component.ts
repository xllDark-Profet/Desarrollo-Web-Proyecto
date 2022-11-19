import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyecto-bookstore';
  /**Atributo que representa que tipo de usuario se autentica */
  auth:string='';
  /**Metodo que cambia el header conforme el usuario cierre sesion */
  cambiarUsuario(){
    this.auth='';
    console.log("estoy");
  }
}
