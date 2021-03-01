package db;

import app.entities.Book;
import app.entities.Order;
import app.entities.OrderUserBook;
import app.entities.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class DBManager {
    private static String url = "jdbc:mysql://localhost:3306/final_db?user=root&password=stargame19941995";
    private static DBManager dbManager;


    private static void readFromFile() {
        Properties properties = new Properties();
        try (FileInputStream fileInputstream = new FileInputStream("app.properties")) {
            properties.load(fileInputstream);
            url = properties.getProperty("connection.url");
        } catch (IOException e) {
            Logger.getLogger(e.getMessage());
        }
    }

    private DBManager() {
        readFromFile();
    }

    public static DBManager getInstance() {
        if ((dbManager == null)) {
            dbManager = new DBManager();
        }
        readFromFile();
        return dbManager;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setUser("root");
        ds.setPassword("stargame19941995");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/final_db");
        return ds.getConnection();
    }

    public void insertUser(User user) {
        String insert = "INSERT INTO USERS (login, password, root) VALUES (?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            psSt.setString(1, user.getLogin());
            psSt.setString(2, user.getPassword());
            psSt.setString(3, "user");
            psSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUser(User user1) {
        String insert = "SELECT id,login,password,root,debt FROM USERS WHERE login ='" + user1.getLogin() + "'AND password = '" + user1.getPassword() + "'";
        ResultSet rs;
        User user = new User();
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoot(rs.getString("root"));
                user.setDebt(rs.getInt(5));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addBookToUser(User user, int id) {
        String insert = "INSERT INTO users_books  VALUES (?,?,?,?,?)";
        LocalDate date = LocalDate.now();
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            psSt.setInt(1, user.getId());
            psSt.setInt(2, id);
            psSt.setString(3, "В очікуванні");
            psSt.setDate(4, sqlDate);
            date = date.plusMonths(1);
            sqlDate = java.sql.Date.valueOf(date);
            psSt.setDate(5, sqlDate);
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        setBooksNumber(id);
    }

    public void setBooksNumber(int id) {
        String insert = "update books set num = num-1 WHERE id = " + id + ";";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert)) {
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String insert = "SELECT id, name, author, num, date, publisher FROM books";
        ResultSet rs;
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                if (rs.getInt(4) != 0) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setName(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setNum(rs.getInt(4));
                    book.setDate(rs.getString(5));
                    book.setPublisher(rs.getString(6));
                    books.add(book);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return books;
    }

    public List<Book> sortBooks(String sort) {
        List<Book> books = getBooks();

        switch (sort) {
            case "nameABC": {
                books.sort(Comparator.comparing(Book::getName));
                break;
            }
            case "nameCBA": {
                books.sort(Comparator.comparing(Book::getName).reversed());
                break;
            }
            case "authorABC": {
                books.sort(Comparator.comparing(Book::getAuthor));
                break;
            }
            case "authorCBA": {
                books.sort(Comparator.comparing(Book::getAuthor).reversed());
                break;
            }
            case "numABC": {
                books.sort(Comparator.comparing(Book::getNum));
                break;
            }
            case "numCBA": {
                books.sort(Comparator.comparing(Book::getNum).reversed());
            }
            case "pubABC": {
                books.sort(Comparator.comparing(Book::getPublisher));
                break;
            }
            case "pubCBA": {
                books.sort(Comparator.comparing(Book::getPublisher).reversed());
            }
            case "dateABC": {
                books.sort(Comparator.comparing(Book::getDate));
                break;
            }
            case "dateCBA": {
                books.sort(Comparator.comparing(Book::getDate).reversed());
            }
        }

        return books;
    }

    public List<Book> searchBooks(String search) {
        List<Book> sbooks = new ArrayList<>();
        String insert = "SELECT * FROM books WHERE name LIKE '%" + search + "%' OR author LIKE '%" + search + "%'";
        ResultSet rs;
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                if (rs.getInt(4) != 0) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setName(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setNum(rs.getInt(4));
                    book.setDate(rs.getString(5));
                    book.setPublisher(rs.getString(6));
                    sbooks.add(book);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sbooks;
    }

    public List<Book> usersBooks(User user) {
        List<Book> sbooks = new ArrayList<>();
        String insert = "SELECT books.id, books.name, books.author , books.num, books.date, books.publisher, users_books.time_take, users_books.return_time FROM books " +
                "INNER JOIN users_books ON books.id = users_books.book_id WHERE users_books.user_id = '" + user.getId() + "';";
        ResultSet rs;
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                if (rs.getInt(4) != 0) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setName(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setNum(rs.getInt(4));
                    book.setDate(rs.getString(5));
                    book.setPublisher(rs.getString(6));
                    book.setGetDate(rs.getString(7));
                    book.setRetDate(rs.getString(8));
                    sbooks.add(book);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sbooks;
    }


    public List<Order> getOrders() {
        List<Order> order = new ArrayList<>();
        String insert = "SELECT u.login as user_id, b.name as book_id, acess, time_take, return_time, author, book_id From users_books join users u on u.id = users_books.user_id\n" +
                " join books b on b.id = users_books.book_id;";
        ResultSet rs;
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setUserLogin(rs.getString(1));
                ord.setBookName(rs.getString(2));
                ord.setAcess(rs.getString(3));
                ord.setTimeTake(String.valueOf(rs.getDate(4)));
                ord.setReturnTime(String.valueOf(rs.getDate(5)));
                ord.setAuthor(rs.getString(6));
                ord.setBookId(rs.getInt(7));
                order.add(ord);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void setAccess(String access, int bookId) {
        String update = "UPDATE users_books SET acess =? where book_id =?";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(update)) {
            psSt.setString(1, access);
            psSt.setInt(2, bookId);
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getUsers() {
        String insert = "SELECT id , login, root, conditions, debt FROM users";
        List<User> users = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setRoot(rs.getString(3));
                user.setCondition(rs.getString(4));
                user.setDebt(rs.getInt(5));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return users.stream().filter((user) -> user.getRoot().equals("user")).collect(Collectors.toList());
    }

    public List<User> getLibrarian() {
        String insert = "SELECT id,login,password,root FROM USERS";
        ResultSet rs;
        List<User> librar = new ArrayList<>();
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            rs = prSt.executeQuery();
            while (rs.next()) {
                User libr = new User();
                libr.setId(rs.getInt(1));
                libr.setLogin(rs.getString(2));
                libr.setPassword(rs.getString(3));
                libr.setRoot(rs.getString("root"));
                librar.add(libr);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return librar.stream().filter((user) -> user.getRoot().equals("librarian")).collect(Collectors.toList());
    }

    public void setDebt() {
        List<Order> orders = getOrders().stream()
                .filter((order) -> LocalDate.now().isAfter(LocalDate.parse(order.getReturnTime())))
                .collect(Collectors.toList());
        orders.forEach(
                (order) -> {
                    String update = "UPDATE users SET debt = debt + 100 WHERE login = " + order.getUserLogin() + ";";
                    try {
                        getConnection().prepareStatement(update).executeUpdate();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void updateBook(String name, String author, String num, String publisher, String date, int id) {
        StringBuilder str = new StringBuilder();
        if (!name.equals("")) {
            str.append("name = '").append(name).append("',");
        }
        if (!author.equals("")) {
            str.append("author = '").append(author).append("',");
        }
        if (!num.equals("")) {
            str.append("num = '").append(num).append("',");

        }
        if (!publisher.equals("")) {
            str.append("publisher = '").append(publisher).append("',");
        }
        if (!date.equals("")) {
            str.append("date = '").append(date).append("'");
        }
        System.out.println(str);

        String insert = "UPDATE books SET " + str + " WHERE id = " + id + "";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        String insert = "DELETE FROM books WHERE id = '" + id + "'";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addBook(String name, String author, String num, String publisher, String date) {
        String insert = "INSERT INTO books (name, author, num, date, publisher) VALUES (?,?,?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println(name + author + num + publisher + date);
            psSt.setString(1, name);
            psSt.setString(2, author);
            psSt.setString(3, num);
            psSt.setString(4, date);
            psSt.setString(5, publisher);
            psSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void addLibrarian(String login, String password) {
        String insert = "INSERT INTO users (login, password, root) VALUES (?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            psSt.setString(1, login);
            psSt.setString(2, password);
            psSt.setString(3, "librarian");
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteLibrarian(int id) {
        String insert = "DELETE FROM users WHERE id = '" + id + "'";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setConditionUser(String condition, int id) {
        String insert = "UPDATE users SET conditions = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert)) {
            psSt.setString(1, condition);
            psSt.setInt(2, id);
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void retBookToUser(User user, int id) {
        String insert = "DELETE FROM users_books where book_id ='" + id + "' AND user_id ='" + user.getId() + "'";
        LocalDate date = LocalDate.now();
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert)) {
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        setBooksNum(id);
    }

    public void setBooksNum(int id) {
        String insert = "update books set num = num+1 WHERE id = " + id + ";";
        try (Connection con = getConnection();
             PreparedStatement psSt = con.prepareStatement(insert)) {
            psSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}