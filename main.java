import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {   
        Student[] tab_stud=new Student[100];
        Scanner input=new Scanner(System.in);
        int choice;
        
        do
        {
        System.out.println("---------------------------------------------------------------");
        System.out.println("|\t[1]record a student information");
        System.out.println("|\t[2]first of class");
        System.out.println("|\t[3]last of class");
        System.out.println("|\t[4]Average of class");
        System.out.println("|\t[5]student above class average");
        System.out.println("|\t[6]re-initailise student list");
        System.out.println("|\t[7]Exit program");
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("Enter Your Option");
        choice=input.nextInt();
        input.nextLine();
            switch (choice) {
                case 1:
                    record_stud(tab_stud);
                    break;
                
                case 2 :
                    if(Student.numberstud==0)System.out.println("!!No student is register yet!!");
                    else first_class(tab_stud);
                    break;
                case 3:
                     if(Student.numberstud==0)System.out.println("!!No student is register yet!!");
                    else last_class(tab_stud);
                    break;

                case 4:
                float avg=0;
                    System.out.println("the class average with number of "+Student.numberstud+" student is "+class_avg(tab_stud));
                    break;
                
                case 5:
                    if(Student.numberstud==0)System.out.println("!!No student is register yet!!");
                    else
                    { float avge=class_avg(tab_stud);
                     above_avg(tab_stud, avge);
                    }
                    break;
                case 6:
                    re_initailise(tab_stud);
                    break;
                case 7:
                    System.out.println("Exit sucessfull!!!!!!");
                    break;
                default:
                    break;
            }
        }while(choice!=7);

    }

    // this function will bw use to register a student ingformation
    public static void record_stud(Student tab[])
    {   
        Scanner input=new Scanner(System.in);
        System.out.println("how many student do you want to register");
        int num=input.nextInt();
        input.nextLine();
        //this loop help to input data dependig on the value of size
        for(int i=0;i<num;i++)
        {
        System.out.println("information of **"+i+"** in database");
        System.out.println("enter student matricuke");
        String mat=input.nextLine();
        System.out.println("enter student name");
        String name=input.nextLine();
        System.out.println("enter student gender [Female/Male]");
        String gender=input.nextLine();
        System.out.println("enter student age");
        int age=input.nextInt();
        input.nextLine();
        System.out.println("enter student Average");
        float avg=input.nextFloat();
        input.nextLine();
        System.out.println("!!!!!!!!enregistre avec success!!!!!!\n\n");
            tab[i]=new Student(mat, name, gender, age, avg);
        }
    }

    public static void first_class(Student tab[]) //this function is use to know the first student
    {   
        int indmax=0;;
         float max=tab[0].average;
        //this for loop search for the student with highest max
        for(int i=0;i<Student.numberstud;i++)
        {
            if(tab[i].average>=max)
            {
                max=tab[i].average;
                indmax=i;
            }
        }
        
        System.out.println("the first is "+tab[indmax].name+" with average:"+max);
        //this for condition if use if two or more student share the highest max
        for(int i=0;i<indmax;i++)
        {
            if(tab[i].average==max)
            {
                System.out.println("Execo With Student\n Name:"+tab[i].name+"\t Mat:"+tab[i].matricule);
            }
        }
    }


    public static void last_class(Student tab[]) //this function is use to know the last student
    {   
        int indmin=0;;
        float min=tab[0].average;
        //this for loop search for the student with lowest min
        for(int i=0;i<Student.numberstud;i++)
        {
            if(tab[i].average<=min)
            {
                min=tab[i].average;
                indmin=i;
            }
        }
        
        System.out.println("the last is "+tab[indmin].name+" with average:"+min);
        //this for condition if use if two or more student share the lowest
        for(int i=0;i<indmin;i++)
        {
            if(tab[i].average==min)
            {
                System.out.println("having "+tab[i].name+" same average with him");
            }
        }
    }

    public static float class_avg(Student tab[]) // this function return the class average
    {
        float sum=0;
        for(int i=0;i<Student.numberstud;i++)
        {
            sum+=tab[i].average;
        }
        float avg=sum/Student.numberstud;
        return avg;
    }

    public static void above_avg(Student tab[],float average)
    {
        //float average=class_avg(tab);
        int j=0;
        for(int i=0;i<Student.numberstud;i++)
        {
            if(tab[i].average>average)
            {
                j+=1;
                System.out.println("["+j+"] "+tab[i].name);
            }
        }
    }



    public static void  re_initailise(Student tab[])
    {   int j=0;
        for(int i=0;i<Student.numberstud;i++)
        {
            tab[i]=null;
            j+=1;
        }
        System.out.println("!!!!!!re-initialisation success!!!!\n"+j+" student were erase\n\n");
    }
 
}