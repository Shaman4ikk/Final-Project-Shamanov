package app.entities;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private int id;
    private String root;
    private String condition;
    private int debt;

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public User(){
    }

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(password, user.password);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public void setRoot(String root) {
        this.root = root;
    }
    public String getRoot(){
        return root;
    }
}
