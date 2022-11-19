import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Person } from './person';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  /**
   * Atributos componente
   */
  form:FormGroup;
  person:Person;
  /**
   * Constructor
   * @param fb 
   * @param router 
   * @param registerService 
   */
  constructor(private fb:FormBuilder, public router: Router, private registerService: RegisterService) {
    this.form=this.fb.group({
      id:['', Validators.required],
      name:['', Validators.required],
      surname:['', Validators.required],
      birth:['', Validators.required], 
      chargeOpt:['', Validators.required],
      email:['', Validators.required],
      password:['', Validators.required]
    });
    this.person=new Person(0, "","","","","","")
   }
   /**El metodo no carga nada cuando se inicia la pagina */
  ngOnInit(): void {
  }
  /**
   * Este metodo recupera los atributos de una persona y llama al metodo del servicio que registra a una persona
   */
  register(){
    const val=this.form.value;
    this.person.setId(val.id);
    this.person.setName(val.name);
    this.person.setSurname(val.surname);
    this.person.setBirth(val.birth);
    this.person.setCharge(val.chargeOpt);
    this.person.setEmail(val.email);
    this.person.setPaswword(val.password);
    console.log(this.person)

    
    this.registerService.register(this.person).subscribe(data=>{
      console.log(data)
      window.alert(data)
    });
    

   }
}
