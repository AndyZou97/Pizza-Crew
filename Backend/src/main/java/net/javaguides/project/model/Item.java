
package net.javaguides.project.model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    //@Column(name = "orderId")
    //private long orderId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "url")
    private String url;


    public Item()
    {

    }

    public Item(String itemName, String description, String price, String url)
    {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.url = url;
    }



    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
   /* public long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(long orderId)
    {
        this.orderId = orderId;
    }
    */


    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }


}