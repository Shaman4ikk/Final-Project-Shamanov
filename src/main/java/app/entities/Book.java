package app.entities;

public class Book {
    private int id;
    private String name;
    private String author;
    private int num;
    private String publisher;
    private String date;
    private String getDate;
    private String retDate;

    public void setRetDate(String retDate)
    {
        this.retDate = retDate;
    }
    public String getRetDate(){
        return retDate;
    }
    public void setGetDate(String getDate)
    {
        this.getDate = getDate;
    }
    public String getGetDate(){
        return getDate;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public String getName(){
        return name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public int getNum(){return num;}
    public void setNum(int num){
        this.num = num;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public Book() {

    }

    public Book(int id, String name, String author, int num, String date, String publisher, String getDate, String retDate)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.num = num;
        this.date = date;
        this.publisher = publisher;
        this.getDate = getDate;
        this.retDate = retDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num + ", publisher=" + publisher +", date=" + date +
                '}';
    }
}
