package book;

public class BookList {
    private Book[] booklist = new Book[10];
    private int usedSize;

    public BookList() {
        this.booklist[0] = new Book("三国演义","罗贯中",10,"小说");
        this.booklist[1] = new Book("西游记","吴承恩",59,"小说");
        this.booklist[2] = new Book("红楼梦", "曹雪芹", 16, "小说");

        this.usedSize = 3;
    }

    public Book getBook(int pos) {
        return booklist[pos];
    }

    public Book[] getBooklist() {
        return booklist;
    }

    public void setBook(int pos, Book book) {
        this.booklist[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
