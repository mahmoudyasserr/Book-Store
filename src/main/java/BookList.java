/**
 *
 * @author Mahmoud Yasser
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    static Scanner input = new Scanner(System.in);
    //create an object of BookList
    private static final BookList bookInstance = new BookList();

    //make the constructor private so that this class cannot be
    //instantiated (Singleton Class)
    private BookList(){}

    //Get the only object available
    public static BookList getInstance(){
       return bookInstance;
    }
    
    //dynamic array of books
    private final ArrayList<Book> bookList = new ArrayList();

    //Print all the available books
    public void displayAllBooks (){
        if(bookList.isEmpty()){
            System.out.println("No books are available");
        }
        else{
            bookList.forEach(book -> {
                System.out.println(book.toString());
            });
        }
    }
    
    //Check if a book is available in the array
    private boolean isBookAvailable(Book book){
        boolean result = false;
        //checking the bookName attribute only because it must be unique
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getBookName().equals(book.getBookName())){
                //if the name exists in the array list, then the book is available
                result = true;
            }
        }
        return result;
    }
    
    //add books to the array list
    public void addBook(){
	Book newBook;
	int addCount = 0;
        boolean isDuplicated;
        
	while(addCount <= 0){
            System.out.println("Enter the number of books you want to add");
            addCount = input.nextInt();
            //ask the user over and over again until a positive number is entered
            if(addCount <= 0){
                    System.out.println("Enter a positive number");
            }
	}
	

	for(int i = 0; i < addCount; i++){
            newBook = new Book();
            isDuplicated = false;
            System.out.println("Enter book " + i + " name");
            newBook.setBookName(input.next());
            //Check if the book is already available in the array list
            for(int j = 0; j < bookList.size(); j++){
                if(isBookAvailable(newBook)){
                    System.out.println("This book already exists");
                    isDuplicated = true;
                    break;
                }
            }
            
            if(!isDuplicated){
                System.out.println("Enter book " + i + " author");
                newBook.setAuthorName(input.next());
                //asking the user to enter a price until a positive value is entered
                while(newBook.getBookPrice() <= 0){
                    System.out.println("Enter book " + i + " price");
                    newBook.setBookPrice(input.nextDouble());
                    if(newBook.getBookPrice() <= 0){
                        System.out.println("Enter a positive price");
                    }
                }
                //add the new book to the array list    
                bookList.add(newBook);
            }
            
	}  
    }
    
    //update the book name/author name/price
    public void updateBook(){
        String updatedBookName; //new name
        Book updatedBook = null;
        int updateOption;
        boolean shouldBreak = false;
        
        System.out.println("Enter the name of the book you want to update");
        updatedBookName = input.next();
        //getting the book object with the name entered by the user
        for(int i = 0; i < bookList.size(); i++){
            if(updatedBookName.equalsIgnoreCase(bookList.get(i).getBookName())){
                updatedBook = bookList.get(i);
            }
        }
        
        if(updatedBook == null){
            System.out.println("This book does NOT exist");
        }
        
        else{  
            while(shouldBreak == false){
                System.out.println("----------Update Menu----------");
                System.out.println("1- Update book name");
                System.out.println("2- Update book author");
                System.out.println("3- Update book price");
                System.out.println("4- Back to main menu");
                System.out.println("Enter update option");
                updateOption = input.nextInt();
                switch(updateOption){
                    case 1 -> {
                        System.out.println("Enter new book name:");
                        updatedBook.setBookName(input.next());
                    }
                    case 2 -> {
                        System.out.println("Enter new author name:");
                        updatedBook.setAuthorName(input.next());
                    }
                    case 3 -> {
                        System.out.println("Enter new book price:");
                        updatedBook.setBookPrice(input.nextDouble());
                    }
                    case 4 -> shouldBreak = true;
                    default -> System.out.println("Invalid option");
                }
            }
        }
    }
    
    //delete a book from the array list
    public void deleteBook(){
        Book deletedBook = null;
        String deletedBookName;
        System.out.println("Enter the name of the book you want to delete");
        deletedBookName = input.next();
        //getting the book object with the name entered by the user
        for(int i = 0; i < bookList.size(); i++){
            if(deletedBookName.equalsIgnoreCase(bookList.get(i).getBookName())){
                deletedBook = bookList.get(i);
            }
        }
        if(deletedBook == null){
            System.out.println("This book does NOT exist");
        }
        else{
            bookList.remove(deletedBook);
        }   
    }
    
    
    public void searchBook(){
	Book searchedBook = null;
	String searchedBookName;
	System.out.println("Enter the name of the book");
	searchedBookName = input.next();
        //getting the book object with the name entered by the user
	for(int i = 0; i < bookList.size(); i++){
            if(searchedBookName.equalsIgnoreCase(bookList.get(i).getBookName())){
                searchedBook = bookList.get(i);
            }
	}
	if(searchedBook == null){
		System.out.println("This book does NOT exist");
	}
	else{
            System.out.println("This book is available");
            System.out.println(searchedBook.toString());
	}
    }
}
