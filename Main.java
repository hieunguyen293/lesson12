
package lesson12;

import java.sql.SQLException;
import lesson12.View.AuthorView;
import lesson12.View.BookView;

public class Main {
        public static void main(String[] args) throws SQLException{
        BookView bookView = new BookView();
        AuthorView authorView = new AuthorView();
        
        bookView.execute();
        authorView.execute();
        
        /*
        Book còn cái lúc add new book vào, idOfAuthor sai nhưng vẫn hiện Success nhưng mà dữ liệu k insert vào database
        
        */
    }
}
