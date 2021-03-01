package app.entities;

public class OrderUserBook {

    Book book;
    User user;


    public void setUser(User user1) {
        user = user1;
    }

    public User GetUser() {
        return user;
    }

    public void setBook(Book book1) {
        book = book1;
    }

    public Book getBookUsers() {
        return book;
    }

    @Override
    public String toString() {
        return "OrderUserBook{" +
                "book=" + book +
                ", user=" + user +
                '}';
    }


}
