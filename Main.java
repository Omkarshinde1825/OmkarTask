import java.util.*;
class Vehical{
    int rate;
    String name , category;
    Vehical(String name, String category, int rate){
        this.name=name;
        this.category=category;
        this.rate=rate;
    }
    public int fare(int days){
        return(this.rate*days);
    }
    public void display(){
        System.out.println("Name: "+this.name+"\tCategory: "+this.category+"\tRate: "+this.rate);
    }
}
class Main{

    public static Vehical lowCost(Vehical[] car,int days){
        int max=9999;
        Vehical result= null;
        for(Vehical obj:car){
            if (obj.fare(days)<max){
                max=obj.fare(days);
                result=obj;
            }
        }
        return result;

    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int ch;
        Vehical[] car= new Vehical[2];
        car[0]= new Vehical("asd","abc",800);
        car[1]= new Vehical("qwe","sad",1200);
        
        // for(int i=0; i<car.length;i++){
        //     System.out.println("Enter Name: ");
        //     String na= sc.nextLine();
            
        //     System.out.println("Enter Category:");
        //     String cat= sc.nextLine();
        //     System.out.println("Enter rate");
        //     int rate= sc.nextInt();
        //     sc.nextLine();

        //     car[i]= new Vehical(na,cat,rate);
            

        // }
        do{
            System.out.println("1.Display ");
            System.out.println("2.Recommanded");
            System.out.println("3.Cheapest Car ");
            System.out.println("Enter chocice: ");
            ch= sc.nextInt();
            
            switch(ch){
                case 1:
                    for(Vehical obj:car){
                        obj.display();
                    }
                    break;
                case 2:
                    for(Vehical obj:car){
                        if(obj.rate<1500){
                            if(obj.category.equals("abc")){
                                obj.display();
                                System.out.println("Its Recommanded!!");
                            }
                        }
                    }
                    break;
                case 3: 
                    System.out.println("Days: ");
                    int days= sc.nextInt();
                    Vehical v= lowCost(car,days);
                    System.out.println("Name: "+v.name+"\tCategory: "+v.category+"\tRate: "+v.rate);
                    System.out.println("Total Fare:"+v.fare(days));
                    break;

                    
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }while(ch!=4);
        
    }
}