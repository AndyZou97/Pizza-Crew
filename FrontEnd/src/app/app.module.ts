import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { CreateItemComponent } from './create-item/create-item.component';
import { FormsModule } from '@angular/forms';
import { UpdateItemComponent } from './update-item/update-item.component';
import { ItemDetailsComponent } from './item-details/item-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    UpdateItemComponent,
    ItemDetailsComponent,
    CreateItemComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
