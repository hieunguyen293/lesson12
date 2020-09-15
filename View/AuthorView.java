package lesson12.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import lesson12.Controller.AuthorController;
import lesson12.Model.DTO.Author;

public class AuthorView {

    AuthorController authorController = AuthorController.getInstance();
    Scanner sc = new Scanner(System.in);

    public void execute() throws SQLException {
        while (true) {
            boolean response;
            System.out.println("1. Show author");
            System.out.println("2. Add author");
            System.out.println("3. Delete author");
            System.out.println("4. Update author");
            System.out.println("0. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ArrayList<Author> listAuthor = authorController.getAllAuthor();
                    for (int i = 0; i < listAuthor.size(); i++) {
                        System.out.println("STT " + (i + 1) + ": " + listAuthor.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.print("Enter name author: ");
                    String name = sc.next();
                    System.out.print("Enter age author: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    Author author = new Author(name, age);
                    if (authorController.addAuthor(author)) {
                        System.out.println("Succes");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
                case 3:
                    System.out.print("Nhap vao ten author muon xoa: ");

                    try {
                        String nameAuthorDel = sc.next();
                        sc.nextLine();

                        response = authorController.deleteAuthorByName(nameAuthorDel);
                        if (response) {
                            System.out.println("Thanh cong");
                        } else {
                            System.out.println("That bai");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {

                    }
                    break;
                case 4:
                    System.out.print("Nhap vao ten author muon update: ");
                    String nameAuthorUp = sc.next();

                    System.out.print("Enter name new author: ");
                    String newName = sc.next();
                    System.out.print("Enter age new author: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    Author author2 = new Author(newName, newAge);
                    try {
                        response = authorController.updateAuthorByName(nameAuthorUp, author2);
                        if (response) {
                            System.out.println("Thanh cong");
                        } else {
                            System.out.println("That bai");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {

                    }
                    break;
                default:
                    return;
            }
        }

    }
}
