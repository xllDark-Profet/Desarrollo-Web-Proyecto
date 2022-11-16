import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyecto-bookstore';
  auth:string='';

  cambiarUsuario(){
    this.auth='';
    console.log("estoy");
  }
}
