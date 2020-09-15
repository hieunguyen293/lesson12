package lesson12.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lesson12.Model.DAO.AuthorDAO;
import lesson12.Model.DTO.Author;

public class AuthorController {

    private static final AuthorController INSTANCE = new AuthorController();
    AuthorDAO authorDAO = new AuthorDAO();

    private AuthorController() {

    }

    public static AuthorController getInstance() {
        return INSTANCE;
    }

    public ArrayList<Author> getAllAuthor() {
        ArrayList<Author> listAuthor = new ArrayList<>();
        try {
            listAuthor = authorDAO.getAllAuthor();
        } catch (SQLException e) {
            System.out.println("That bai");
        } finally {
            return listAuthor;
        }
    }

    public boolean addAuthor(Author author) throws SQLException {
        try {
            return authorDAO.addAuthor(author);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateAuthorByName(String name, Author author) {
        try {
            return authorDAO.updateAuthorByName(name, author);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteAuthorByName(String name) {
        try {
            return authorDAO.deleteAuthorByName(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
