import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  item_id!: number
  item!: Item
  constructor(private route: ActivatedRoute, private itemService: ItemService) { }

  ngOnInit(): void {
    this.item_id = this.route.snapshot.params['item_id'];

    this.item= new Item();
    this.itemService.getItemById(this.item_id).subscribe( data => {
      this.item = data;
    });
  }

}
