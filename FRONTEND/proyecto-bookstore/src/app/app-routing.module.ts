import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegistroComponent } from './auth/registro/registro.component';
import { DetalleBookComponent } from './book/detalle-book/detalle-book.component';
import { EditarBookComponent } from './book/editar-book/editar-book.component';
import { ListaBookComponent } from './book/lista-book/lista-book.component';
import { NuevoBookComponent } from './book/nuevo-book/nuevo-book.component';
import { IndexComponent } from './index/index.component';

const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registro', component:RegistroComponent},
  {path: '', component: ListaBookComponent},
  {path: 'book-detail/:id', component: DetalleBookComponent},
  {path: 'create-book', component: NuevoBookComponent},
  {path: 'update-book/:id', component: EditarBookComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
