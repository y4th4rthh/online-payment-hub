package payment;
import sastabank.Bank;
import sastabank.Bank.Account;
import bill.electricityBilll;
import telecombill.Recharge;
import cakeshop.CakeShop;
import train.Train;
import moviebooking.MovieBookingTickets;
import static java.lang.System.exit;

import java.util.Scanner;
public class CombineProject{
        Bank one = new Bank();
        Train t1 = new Train();
        MovieBookingTickets mb = new MovieBookingTickets();
        CakeShop c1 = new CakeShop();
        Recharge rb = new Recharge();
        electricityBilll b1 = new electricityBilll();

        Scanner scan = new Scanner(System.in);
        public  static int payment(int bill , String iD , String accepterId){
            Scanner sc = new Scanner(System.in);
            Account temp =Bank.head;
            Account temp2 = Bank.head;
            while(temp!=null){
                if(temp.upiID.equals(iD)){
                    break;
                }
                else{
                    temp=temp.next;
                }
            }
            if(temp==null){
                System.out.println("Incorrect ID!!!!");
                return -1;
            }
            else{
                while(true){
                    int otp = (int)(Math.random()*10000);
                    int ans;
                    System.out.println("Your OTP is - "+otp+".");
                    System.out.print("Enter OTP :");
                    ans=sc.nextInt();
                    if(ans==otp){
                        break;
                    }
                }
                temp.balance=temp.balance-bill;
                System.out.println("Payment Successful.");
                System.out.println("Rs. "+bill+" is Debited From Your Account.");
                System.out.println("Your Available Balance is "+temp.balance+" Rs.");
            }
            while(temp2!=null){
                if(temp2.upiID.equals(accepterId)){
                    break;
                }
                else{
                    temp2=temp2.next;
                }
            }
            temp2.balance=temp2.balance+bill;
            
            return 0;
        }
        public  void start(){
        
        one.setData("Aarsh", 8780497776L, "aipatel3104@gmail.com", 12345678912345L, 3104, 80000,"aipatel3104.okaadybank");
        one.setData("Aaditya", 7096676302L, "aadipatel1019@gmail.com", 12341234123412L, 1019, 100000,"aadipatel1019.okaadybank");
        one.setData("Devarshi", 7383823545L, "devarshipatel8103@gmail.com", 12345123451234L, 8103, 150000,"devarshipatel8103.okaadybank");
        one.setData("Yatharth", 9925055858L, "yatharthpatel1103@gmail.com", 12312312312312L, 1103, 200000,"yatharthpatel1103.okaadybank");
        one.setData("ARCTC", 1234567890L, "arctc@gmail.com", 88887777666655L, 1234, 0,"arctc.okaadybank");
        one.setData("CakeShop", 7383823545L, "cakeshop@gmail.com", 99998888777766L, 1357, 0,"cakeshop.okaadybank");
        one.setData("YVCL", 9988998899L, "yvcl@gmail.com", 80000800008888L, 2468, 0,"yvcl.okaadybank");
        one.setData("AadyCinema", 9242592425L, "aadycinema@gmail.com", 80000800008888L, 92425, 0,"aadycinema.okaadybank");


            
        t1.regestration("Aarsh",8780497776L, "aipatel3104@gmail.com", "Aarsh3104", "3104",true);
        t1.regestration("Aaditya", 8780497776L,"aadipatel1019@gmail.com", "Aadi1019", "1019",false);
        t1.regestration("Deavarshi",8780497776L, "aadipatel1019@gmail.com", "Devarshi8103", "8103",false);
        t1.regestration("Yatharth", 8780497776L,"aadipatel1019@gmail.com", "Yatharth1103", "1103",true);

        t1.createTrain("Intercity_Express",12929,25);
        t1.addCoach(12929);
        t1.addCoach(12929);
        t1.addCoach(12929);
        t1.addCoach(12929);

        t1.createTrain("Gujarat_Queen",19033,25);
        t1.addCoach(19033);
        t1.addCoach(19033);
        t1.addCoach(19033);
        t1.addCoach(19033);

        t1.createTrain("Sanjan-Surat_Memu_Special",9087,20);
        t1.addCoach(9087);
        t1.addCoach(9087);
        t1.addCoach(9087);
        t1.addCoach(9087);

        t1.createTrain("Gujarat_SF_Express",22953,30);
        t1.addCoach(22953);
        t1.addCoach(22953);
        t1.addCoach(22953);
        t1.addCoach(22953);

        t1.addStation("Valsad");
        t1.addTrain("Valsad", "Gujarat_Queen", "-start-", "04:05", "19033");
        t1.addTrain("Valsad", "Intercity_Express", "-start-", "07:15", "12929");
        t1.addTrain("Valsad", "Sanjan-Surat_Memu_Special", "08:14", "08:16", "09087");
        t1.addTrain("Valsad", "Gujarat_SF_Express", "08:52", "08:57", "22953");

        t1.addStation("Bilimora");
        t1.addTrain("Bilimora", "Gujarat_Queen", "04:24", "04:26", "19033");
        t1.addTrain("Bilimora", "Intercity_Express", "07:19", "07:21", "12929");
        t1.addTrain("Bilimora", "Sanjan-Surat_Memu_Special", "08:37", "08:39", "09087");
        t1.addTrain("Bilimora", "Gujarat_SF_Express", "09:12", "09:14", "22953");

        t1.addStation("Amalsad");
        t1.addTrain("Amalsad", "Gujarat_Queen", "04:32", "04:34", "19033");
        t1.addTrain("Amalsad", "Intercity_Express", "07:26", "07:27", "12929");
        t1.addTrain("Amalsad", "Sanjan-Surat_Memu_Special", "08:47", "08:48", "09087");

        t1.addStation("Navsari");
        t1.addTrain("Navsari", "Gujarat_Queen", "04:40", "04:42", "19033");
        t1.addTrain("Navsari", "Intercity_Express", "07:39", "07:41", "12929");
        t1.addTrain("Navsari", "Sanjan-Surat_Memu_Special", "09:12", "09:14", "09087");
        t1.addTrain("Navsari", "Gujarat_SF_Express", "09:31", "09:33", "22953");

        t1.addStation("Maroli");
        t1.addTrain("Maroli", "Gujarat_Queen", "04:49", "04:51", "19033");
        t1.addTrain("Maroli", "Intercity_Express", "07:48", "07:50", "12929");
        t1.addTrain("Maroli", "Sanjan-Surat_Memu_Special", "09:22", "09:23", "09087");

        t1.addStation("Surat");
        t1.addTrain("Surat", "Gujarat_Queen", "05:30", "05:35", "19033");
        t1.addTrain("Surat", "Intercity_Express", "08:15", "08:20", "12929");
        t1.addTrain("Surat", "Gujarat_SF_Express", "10:02", "10:07", "22953");
        t1.addTrain("Surat", "Sanjan-Surat_Memu_Special", "10:25", "-end-", "09087");

         mb.addScreen(1);
            mb.addShow(1,"Morning","KANTARA","08:00 AM To 11:00 AM");
            mb.addShow(1,"Afternoon","RAMSETU","12:00 PM To 03:00 PM");
            mb.addShow(1,"Night","KANTARA","08:00 PM To 11:00 PM");
        mb.addScreen(2);
            mb.addShow(2,"Morning","KARTHIKEYA2","08:00 AM To 11:00 AM");
            mb.addShow(2,"Afternoon","KANTARA","12:00 PM To 03:00 PM");
            mb.addShow(2,"Night","KARTHIKEYA2","08:00 PM To 11:00 PM");
        mb.addScreen(3);
            mb.addShow(3,"Morning","RAMSETU","08:00 AM To 11:00 AM");
            mb.addShow(3,"Afternoon","KARTHIKEYA2","12:00 PM To 03:00 PM");
            mb.addShow(3,"Night","RAMSETU","08:00 PM To 11:00 PM");
        mb.regestration("Aarsh",8780497776L, "aipatel3104@gmail.com", "Aarsh3104", "3104",true);
        mb.regestration("Aaditya", 8780497776L,"aadipatel1019@gmail.com", "Aadi1019", "1019",false);
        mb.regestration("Deavarshi",8780497776L, "aadipatel1019@gmail.com", "Devarshi8103", "8103",false);
        mb.regestration("Yatharth", 8780497776L,"aadipatel1019@gmail.com", "Yatharth1103", "1103",true);
            
            byte ans;
            System.out.println("\n----------------------------PROJECT AADY----------------------------------------");
            while(true){
                System.out.print("-------------------------------------------------------------------------------\nPress 1--> Bank , 2--> Electricity Bill , 3--> Train Booking , 4--> Recharge , 5--> Movie Booking , 6--> Order Cake , 7-->Exit:");
                ans=scan.nextByte();
                System.out.print("-------------------------------------------------------------------------------\n");
                if(ans==1){
                    one.welcome();
                }
                else if(ans==2){
                        b1.bill();
                }
                else if(ans==3){
                    t1.run();
                }
                else if(ans==4){
                    
                    rb.telecombill();
                }
                else if(ans==5){
                    mb.proceed();
                }
                else if(ans==6){
                    c1.run();
                }
                else if(ans==7){
                    exit(1);
                }
                else{
                    System.out.println("Invalid Input.");
                }
            }
        }
    public static void main(String args[]){
        CombineProject cb = new CombineProject();
        cb.start();
    }
}