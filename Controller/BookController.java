
package lesson12.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lesson12.Model.DAO.BookDAO;
import lesson12.Model.DTO.Book;

public class BookController {
    
    private static final BookController INSTANCE = new BookController();
    BookDAO bookDAO = new BookDAO();

    private BookController() {

    }

    public static BookController getInstance() {
        return INSTANCE;
    }

    public ArrayList<Book> getAllBook() {
        ArrayList<Book> listBook = new ArrayList<>();
        try {
            listBook = bookDAO.getAllBook();
        } catch (SQLException e) {
            System.out.println("That bai");
        } finally {
            return listBook;
        }
    }

    public boolean addBook(Book book) throws SQLException {
        try {
            return bookDAO.addBook(book);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateBookByName(String name, Book book) throws SQLException{
        try {
            return bookDAO.updateBookByName(name, book);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean deleteBookByName(String name) throws SQLException {
        try {
            return bookDAO.deleteBookByName(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean isIdAuthorExist(int idOfAuthor){
        try {
            return bookDAO.isIdAuthorExist(idOfAuthor);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
}
