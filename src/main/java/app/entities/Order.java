package app.entities;

public class Order {
    private String userLogin;
    private String bookName;
    private String acess;
    private String timeTake;
    private String returnTime;
    private String author;
    private int bookId;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAcess() {
        return acess;
    }

    public void setAcess(String acess) {
        this.acess = acess;
    }

    public String getTimeTake() {
        return timeTake;
    }

    public void setTimeTake(String timeTake) {
        this.timeTake = timeTake;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
