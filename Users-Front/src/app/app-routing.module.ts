import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authentification/login/login.component';
import { HomeComponent } from './home/home.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { ListProductComponent } from './product/list-product/list-product.component';


const routes: Routes = [
  {path: '', redirectTo:'/login', pathMatch:'full'},
  {path: 'login', component:LoginComponent},
  {path: 'home', component:HomeComponent,
    children: [
      {path:'', component: ListUserComponent},
      {path:'list-user', component: ListUserComponent},
      {path:'list-product', component: ListProductComponent}
    ]},
  {path: '**', redirectTo:'/login', pathMatch:'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
