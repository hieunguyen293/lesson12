
package lesson12.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lesson12.Helper.DatabaseUtil;
import lesson12.Model.DTO.Author;

public class AuthorDAO {
    
    DatabaseUtil dbUtil = new DatabaseUtil();
    
    public ArrayList<Author> getAllAuthor() throws SQLException {
        String sql = "Select * from Author;";
        ArrayList<Author> authorList = new ArrayList<>();
        ResultSet rs = dbUtil.executeQuery(sql);
        while (rs.next()) {
            Author temp = new Author();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setAge(rs.getInt("age"));
            authorList.add(temp);
        }
        return authorList;
        
    }
    
    public boolean addAuthor(Author author) throws SQLException {
        String sql = "SELECT name FROM Author WHERE EXISTS (SELECT name FROM Author WHERE name = '" + author.getName() + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                return false;
            } else {
                sql = "Insert into Author(name,age) values('" + author.getName() + "'," + author.getAge()+ ");";

                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean updateAuthorByName(String name, Author author) throws SQLException {
        String sql = "SELECT name FROM Author WHERE EXISTS (SELECT name FROM Author WHERE name = '" + name + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                sql = "UPDATE Author SET name = '" + author.getName() + "', age = " + author.getAge()+ " WHERE name = '" + name + "' ";
//                sql = "Insert into Book(name,price) values('" + book.getName() + "','" + book.getPrice() + "');";

                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean deleteAuthorByName(String name) throws SQLException {
        String sql = "SELECT name FROM Author WHERE EXISTS (SELECT name FROM Author WHERE name = '" + name + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                sql = "DELETE FROM Author WHERE name = '" + name + "';";
                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
}
