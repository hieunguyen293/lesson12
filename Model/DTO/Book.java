
package lesson12.Model.DTO;

public class Book {
    int id;
    String name;
    int price;
    int idOfAuthor;

    public int getIdOfAuthor() {
        return idOfAuthor;
    }

    public void setIdOfAuthor(int idOfAuthor) {
        this.idOfAuthor = idOfAuthor;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book() {
    }

    public Book(String name, int price, int idOfAuthor) {
        this.name = name;
        this.price = price;
        this.idOfAuthor = idOfAuthor;
    }

    public Book(int id, String name, int price, int idOfAuthor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idOfAuthor = idOfAuthor;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", price=" + price + ", idOfAuthor=" + idOfAuthor + '}';
    }

    

    
    
}
