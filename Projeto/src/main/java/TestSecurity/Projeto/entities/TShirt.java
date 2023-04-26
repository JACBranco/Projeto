package TestSecurity.Projeto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TShirt {

    @Id
    @GeneratedValue
    private long id;
    private double price;
    private int color;
    private int size;

    public enum sizeList{
        XS,S, M, L, XL, XXL, XXXL
    }

    public enum colorList {
        WHITE, BLACK, YELLOW, GREEN, BLUE, RED, ORANGE, BROWN, PINK, PURPLE, GRAY
    }

    public TShirt (){};
    public TShirt (double price, int color, int size){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColorName() {
        return colorList.values()[this.color].name();
    }

    public String getSizeName(){
        return sizeList.values()[this.size].name();
    }

}
