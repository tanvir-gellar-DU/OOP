class gradebook{
    private String coursename;
    private int[] grades;

    gradebook(String coursename,int[] grades)
    {
        this.coursename=coursename;
        this.grades=grades;
    }
    public String getcoursename()
    {
        return coursename;
    }
    public void processgrades()
    {
        outputgrades();
        System.out.println("class avg is "+getaverage());
        System.out.println("Lowest grade is : "+getminimum());
        System.out.println("Highest grade is "+getmaximum());
           
        
    }
        public int getminimum(){
            int lowgrade= grades[0];
            for(int grade:grades)
            {
                if(grade<lowgrade)
                lowgrade=grade;
            }
            return lowgrade;
        }
        public int getmaximum(){
            int highgrade= grades[0];
            for(int grade:grades)
            {
                if(grade>highgrade)
                highgrade=grade;
            }
            return highgrade;
        }
        public double getaverage()
        {
            int total=0;
            for(int grades:grades)
            {
                total=total+grades;
            }
            double m=total/grades.length;
            return m;
        }
        public void  outputgrades()
        {
            int i;
            System.out.println("the grades are : ");
            for(i=1;i<grades.length;i++)
            {
                System.out.println("Student " + i + ": " + grades[i]);
            }
        }
    }


public class javabook6 {
    public static void main(String[] args)
    {
        int[] grades={78,89,90,87,89,97,68,69,70,45,80};
        gradebook mygradebook=new gradebook("SE1102",grades);
        System.out.println("Welcome to the grade book for");
       System.out.println( mygradebook.getcoursename());
        mygradebook.processgrades();

    }
    
}
