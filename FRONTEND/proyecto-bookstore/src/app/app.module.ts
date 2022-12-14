import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import{HttpClientModule} from '@angular/common/http'
import{FormsModule,  ReactiveFormsModule } from '@angular/forms'

import { CookieService } from 'ngx-cookie-service';
//Imports extras
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

//components
import { ListaBookComponent } from './book/lista-book/lista-book.component';
import { DetalleBookComponent } from './book/detalle-book/detalle-book.component';
import { NuevoBookComponent } from './book/nuevo-book/nuevo-book.component';
import { EditarBookComponent } from './book/editar-book/editar-book.component';
import { CrudTableBookComponent } from './book/crud-table-book/crud-table-book.component';
import { CrudTableEditorialComponent } from './editorial/crud-table-editorial/crud-table-editorial.component';
import { NuevaEditorialComponent } from './editorial/nueva-editorial/nueva-editorial.component';
import { EditarEditorialComponent } from './editorial/editar-editorial/editar-editorial.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CrudTablePersonaComponent } from './persona/crud-table-persona/crud-table-persona.component';
import { EditarPersonaComponent } from './persona/editar-persona/editar-persona.component';
import { NuevaPersonaComponent } from './persona/nueva-persona/nueva-persona.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaBookComponent,
    DetalleBookComponent,
    NuevoBookComponent,
    EditarBookComponent,
    CrudTableBookComponent,
    CrudTableEditorialComponent,
    NuevaEditorialComponent,
    EditarEditorialComponent,
    LoginComponent,
    RegisterComponent,
    CrudTablePersonaComponent,
    EditarPersonaComponent,
    NuevaPersonaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
