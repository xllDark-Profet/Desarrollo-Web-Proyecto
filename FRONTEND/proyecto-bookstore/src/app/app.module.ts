import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import{HttpClientModule} from '@angular/common/http'
import{FormsModule} from '@angular/forms'

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
