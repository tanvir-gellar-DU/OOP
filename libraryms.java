import java.util.Scanner;
class book{
    String title;
    String author;
    String ISBN;
    int numcopies;
    public book(String title,String author,String ISBN,int numcopies)
    {
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.numcopies=numcopies;
    }
    void display()
    {
        System.out.println("title : "+title+" author : "+author+" ISBN: "+ISBN+" numberofcopies : "+numcopies);
    }
    void borrow()
    {
        if(numcopies>0)
        numcopies--;
        else
        System.out.println("not available");
    }
    void returnbook()
    {
        numcopies++;
        System.out.println("book "+title+" has been returned");
    }
    String gettitle()
    {
        return title;
    }
}
class library{
    book[] books;
    student[] students;
    int bookcount;
    int studentcount;
    public library(int maxbooks,int maxstudents)
    {
        books= new book[maxbooks];
        students=new student[maxstudents];
        bookcount=0;
        studentcount=0;
    }
    void addbook(book Book)
    {
        if(bookcount<books.length)
        books[bookcount++]=Book;
        else System.out.println("no place left in the shelf");
    }
    void addstudent(student Student)
    {
        if(studentcount<students.length)
        students[studentcount++]=Student;
        else System.out.println("no room left for student");
    }
    void displaybooks()
    {
        for(int i=0;i<bookcount;i++)
        {
            books[i].display();
            System.out.println();
        }
    }
    book findbook(String title)
    {
        for(int i=0;i<bookcount;i++)
        {
            if(title.equals(books[i].gettitle()));
            return books[i];
        }
        return null;
    }
    void borrowbook(String title,student Student)
    {
        book b1=findbook(title);
        if(b1!=null)
        {
            b1.borrow();
            Student.borrowbook(b1);
        }
        else {
            System.out.println("Book \"" + title + "\" not found in the library.");
        }
    }
    void returnbook(String title,student Student)
    {
        book b1=findbook(title);
        if(b1!=null)
        {
            b1.returnbook();
            Student.returnbook(b1);
        }
        else
        System.out.println("Book \"" + title + "\" not found in the library.");
    }
}
class student{
    String name;
    String id;
    book[] borrowedbooks;
    int bookcount;
    int maxbooks;
    public student(String name,String id,int maxbooks)
    {
        this.name=name;
        this.id=id;
        borrowedbooks=new book[maxbooks];
        bookcount=0;
    }
    void display()
    {
        System.out.println("name: "+name+"id: "+id);
        System.out.println("Borrowed Books:");
        for(int i=0;i<maxbooks;i++)
        {
            System.out.println(borrowedbooks[i].gettitle());
        }
    }
    void borrowbook(book Book)
    {
        if(Book!=null && bookcount < borrowedbooks.length)
        {borrowedbooks[bookcount++]=Book;
        System.out.println("book: "+Book.gettitle()+" has been borrowed by: "+name);}
        else
        System.out.println("Book not found or student cannot borrow more books.");
    }
    void returnbook(book Book)
    {
        for(int i=0;i<bookcount;i++)
        {
            if(borrowedbooks[i].gettitle().equals(Book.gettitle()))
            {
                borrowedbooks[i]=borrowedbooks[--bookcount];
                System.out.println("Book \"" + Book.gettitle() + "\" has been returned by " + name);
            }
        }
        System.out.println("Book \"" + Book.gettitle() + "\" was not borrowed by " + name);
    }
 }

public class libraryms {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the maximum number of books in the library: ");
        int maxbooks=sc.nextInt();
        System.out.print("Enter the maximum number of students in the library: ");
        int maxstudents = sc.nextInt();

        library l1=new library(maxbooks, maxstudents);
        System.out.println("Enter book details (title, author, ISBN, number of copies):");
        for(int i=0;i<maxbooks;i++)
        {
            String title=sc.next();
            String author=sc.next();
            String ISBN=sc.next();
            int numcopies=sc.nextInt();
            l1.addbook(new book(title, author, ISBN, numcopies));
        }
        System.out.println("Enter student details (name, ID):");
        for (int i = 0; i < maxstudents; i++) {
            String name = sc.next();
            String id = sc.next();
            l1.addstudent(new student(name, id, maxbooks));
            System.out.println("Available Books:");
            l1.displaybooks();
    
            // Code to borrow and return books...
    
            sc.close();
        }


    }
}
