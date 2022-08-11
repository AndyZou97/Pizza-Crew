import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateItemComponent } from './create-item/create-item.component';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { ItemListComponent } from './item-list/item-list.component';
import { UpdateItemComponent } from './update-item/update-item.component';

const routes: Routes = [
  {path: 'items',component:ItemListComponent},
  {path: '', redirectTo: 'items', pathMatch: 'full'},
  {path: 'create-item', component:CreateItemComponent},
  {path: 'update-item/:id', component: UpdateItemComponent},
  {path: 'item-details/:id', component: ItemDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
