import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleBookComponent } from './book/detalle-book/detalle-book.component';
import { EditarBookComponent } from './book/editar-book/editar-book.component';
import { ListaBookComponent } from './book/lista-book/lista-book.component';
import { NuevoBookComponent } from './book/nuevo-book/nuevo-book.component';
import { CrudTableBookComponent } from './book/crud-table-book/crud-table-book.component';
import { CrudTableEditorialComponent } from './editorial/crud-table-editorial/crud-table-editorial.component';
import { NuevaEditorialComponent } from './editorial/nueva-editorial/nueva-editorial.component';
import { EditarEditorialComponent } from './editorial/editar-editorial/editar-editorial.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: '', component: ListaBookComponent},
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'detail/:id', component: DetalleBookComponent},
  {path: 'create-book', component: NuevoBookComponent},
  {path: 'update-book/:id', component: EditarBookComponent},
  {path: 'book-table', component: CrudTableBookComponent},
  {path: 'editorial-table', component: CrudTableEditorialComponent},
  {path: 'create-editorial', component: NuevaEditorialComponent},
  {path: 'update-editorial/:id', component: EditarEditorialComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
