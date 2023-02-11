/**
 *
 * @author Mahmoud Yasser
 */

import java.util.Scanner;


public class mainClass {
    static Scanner input = new Scanner(System.in);        
    static BookList bookList = BookList.getInstance();
    public static void main(String args[]){
        int menuOption;
        boolean shouldBreak = false;
        while(shouldBreak == false){
            System.out.println("----------- Main Menu -------------");
            System.out.println("1- Display all books");
            System.out.println("2- Add book");
            System.out.println("3- Update book");
            System.out.println("4- Delete book");
            System.out.println("5- Search for a book");
            System.out.println("6- Exit");
            System.out.println("Enter your choice: ");
            menuOption = input.nextInt();
            switch(menuOption){
                case 1 -> bookList.displayAllBooks();
                case 2 -> bookList.addBook();
                case 3 -> bookList.updateBook();
                case 4 -> bookList.deleteBook();
                case 5 -> bookList.searchBook();
                case 6 -> {
                    System.out.println("Closing the application...");
                    shouldBreak = true;
                }
                default -> System.out.println("Invalid Option");
            }
        }
    }
}
