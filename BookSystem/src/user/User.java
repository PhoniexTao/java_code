package user;

import book.BookList;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
    public abstract void doIoperation(int choice, BookList bookList);
}
