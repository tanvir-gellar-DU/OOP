import java.util.ArrayList;
class course{
    String coursename;
    String courseid;
    double numofcredits;
    public course(String coursename,String courseid,double numofcredits)
    {
        this.coursename=coursename;
        this.courseid=courseid;
        this.numofcredits=numofcredits;
    }
    public String toString() {
        return coursename + " " + courseid + " " + numofcredits;
    }

    public String getcourseid() {
        return courseid;
    }
}
class user{
    String username;
    String name;
    String password;
    String email;
    public user(String username,String name,String password,String email)
    {
        this.username=username;
        this.name=name;
        this.password=password;
        this.email=email;
    }
    boolean login(user User)
    {
       return  User.username.equals(this.username) && User.password.equals(this.password);
    }

   public  String toString()
    {
        return username+" "+name+" "+email;
    }
}
class student extends user{
    ArrayList<course> courses;
    int year;
    int semester;
    public student(String username,String name,String password,String email,int year,int semester)
    {
        super( username,name,password,email);
        this.year=year;
        this.semester=semester;
        courses=new ArrayList<>();
    }
    void addcourse(course Course) throws Exception{
        if(courses.contains(Course))
        {
            throw new Exception("course already added.");
        }
        courses.add(Course);
    }
    void dropcourse(course Course) throws Exception{
        if(!courses.contains(Course))
        {
            throw new Exception("course not added");
        }
        courses.remove(Course);
    }
    void setyear(int year)
    {
        this.year=year;
    }
    void setsemester(int semester)
    {
        this.semester=semester;
    }
    public String toString()
    {
        StringBuffer stringbuffer=new StringBuffer();
        stringbuffer.append(super.toString()+" ");
        stringbuffer.append(year+" ");
        stringbuffer.append(semester+" ");

        for(course x: courses)
        {
            stringbuffer.append(x.toString()+" ");
        }
        return stringbuffer.toString().trim();
    }
}
    class employee extends user{
        double salary;
        String designation;
        int startingyear;
    
     public employee(String username, String name, String password, String email, double salary, String designation, int startingyear) {
        super(username, name, password, email);
        this.salary = salary;
        this.designation = designation;
        this.startingyear = startingyear;
    }

    public void setsalary(double salary) {
        this.salary = salary;
    }

    public double getsalary() {
        return salary;
    }

    public void setdesignation(String designation) {
        this.designation = designation;
    }

    public String getdesignation() {
        return designation;
    }
}
    class staff extends employee{
        public staff(String username, String name, String password, String email, double salary, String designation, int startingyear)
        {
            super(username,name,password,email,salary,designation,startingyear);
        }

        public void setsalary(double baseamount)
        {
            if(this.getdesignation().endsWith("officer")){
                super.setsalary(super.getsalary()+ baseamount*0.25);
            }
            else
            super.setsalary(super.getsalary()+ baseamount*0.10);
        }
    }
    class teacher extends employee{
        ArrayList<course> listofcourses;
        public teacher(String username, String name, String password, String email, double salary, String designation, int startingyear)
        {
            super(username,name,password,email,salary,designation,startingyear);
            listofcourses=new ArrayList<>();
        }
        public void addcourse(course Course)throws Exception{
            if(listofcourses.contains(Course))
            {
                throw new Exception("course is already added");
            }
            else
            listofcourses.add(Course);
        }
        public void setsalary(double baseamount)
        {
            super.setsalary(super.getsalary() + baseamount * 0.25);
        }
        public String toString() {
            return super.toString() + " teaches: " + listofcourses;
        }
    }

public class unimanagement {
    public static void main(String[] args){
        course courseOOP = new course("OOP", "SE 101", 3);
        course courseMath = new course("MATH", "MATH 102", 3);
        course courseStat = new course("STAT", "STAT 103", 3);

        student jack = new student("jack11", "Jack", "1111", "jack@gmail.com", 1, 2);
        student hasan = new student("hasan", "Hasan", "1112", "hasan@gmail.com", 2, 2);

        teacher Hayley = new teacher("h112", "Hayley", "222", "h@gmail.com", 50000, "Lecturer", 2019);

        staff Matt = new staff("matt", "Matt", "111", "matt@gmail.com", 40000, "Senior officer", 2019);
        staff Karim = new staff("kar", "Karim", "1122", "karim@gmail.com", 30000, "Office Staff", 2020);

        System.out.println(hasan);
        System.out.println(Hayley);
        System.out.println(Matt.getsalary());
        Matt.setsalary(100);
        System.out.println(Matt.getsalary());

    }
    
}
