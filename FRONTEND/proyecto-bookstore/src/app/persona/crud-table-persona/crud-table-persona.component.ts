import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Persona } from 'src/app/models/persona';
import { Person } from 'src/app/register/person';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-crud-table-persona',
  templateUrl: './crud-table-persona.component.html',
  styleUrls: ['./crud-table-persona.component.css']
})
export class CrudTablePersonaComponent implements OnInit {

  person: Person[] = [];

  constructor(
    private personaService: LoginService,
    private http:HttpClient, private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.cargarPersona();
  }

  cargarPersona(): void{
    this.personaService.personlist().subscribe(
      data =>{
        this.person = data; 
      },
      err => {
        console.log(err);
      }
    )
  }

}
