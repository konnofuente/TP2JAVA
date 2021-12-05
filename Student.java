//
public class Student {
   String matricule;
   String name;
   String gender;
   int age;
   float average;
   static int numberstud;
   
   public Student(String matricule,String name,String gender,int age,float average)
   {
       this.matricule=matricule;
       this.name=name;
       this.gender=gender;
       this.age=age;
       this.average=average;
       numberstud++;
   }

   public void info_student()
   {
       System.out.println("Matricule:"+this.matricule+"\n Nom:"+this.name+"\n gender:"+this.gender+"\n age of birth:"+this.age+"\n average:"+this.average);
   }

  
}
