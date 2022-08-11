import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ColdObservable } from 'rxjs/internal/testing/ColdObservable';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.css']
})
export class CreateItemComponent implements OnInit {

  item:Item = new Item;

  constructor(private itemService:ItemService,
    private router:Router) { }

  ngOnInit(): void {
  
  }
  saveItem(){
    this.itemService.createItem(this.item).subscribe();
    }

  goToItemList(){
    this.router.navigate(["/items"]);
  }
  
    

  onSubmit(){
    this.saveItem();
    this.goToItemList();

  }

}
