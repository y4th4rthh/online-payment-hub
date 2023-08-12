package bill;
import payment.CombineProject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
public class electricityBilll {
    public void bill(){
        String captcha;
        long pswd;
        int cap,cha;
        Details n1 = new Details();
        Scanner sc = new Scanner(System.in);
        Random lap =new Random();
        cap=lap.nextInt(111,999);
        cha=lap.nextInt(164,9934);
        System.out.println("--------------------------------------------------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("--------------------x-ElectricityBIll-x-----------------------");
            System.out.println("Enter your Unique 8 Digit UserID ");
            pswd = sc.nextLong();
            sc.nextLine();
            if(pswd>10000000 && pswd<99999999){
                System.out.println("--------------------------------------------------------------");
                System.out.println("Your Captcha Code is- "+cap+"L&v"+cha);
                for(i=0;i<3;i++){
                    System.out.println("Please reEnter your Captcha");
                    captcha=sc.nextLine();
                    if(captcha.equals(cap+"L&v"+cha)){
                        System.out.println("Captcha Verified");
                        n1.run( pswd);
                        return;
                    }
                    else{
                        System.out.println("Invalid Captcha.. Please Try Again");
                    }
                    }
            }
            else{
                System.out.println("Invalid Input UserID must be of 11 digit");
            }
        }
    }
    public static void main(String[] args) {
    electricityBilll eb = new electricityBilll();
    eb.bill();
    }
}
class Details{
    Scanner sc = new Scanner(System.in);
    void run( long pswd) {
        Person r1 = new Person();
        int ans;
        String stk;
        System.out.print("Enter your Name:");
        stk = sc.nextLine();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Press-1-->Get A BILL , Press-2-->Pay Bill Online , Press-3-->Exit");
            ans = sc.nextInt();
            if (ans == 1) {
                r1.person(stk, pswd);
            } else if (ans == 2) {
                r1.personpay(stk ,pswd);
                return;
            } else if (ans == 3) {
                r1.exit();
                return;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
class Person{
    Scanner sc = new Scanner(System.in);
    int bill,f,py;
    int p;
    String u;
    int m;
    long n;
    String str;
    float duedate;
    void person(String stk, long pswd) {
        Random h = new Random();
        bill = h.nextInt(888, 5000);
        LocalDate l1 =LocalDate.now();
        LocalTime l2=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name-> " + stk + "                     " + "Date of Issue->" + formatter.format(l1));
        System.out.println("User Id- " + pswd+"                 "+"Time- "+l2);
        System.out.println("Issuer->DGVCL PVT. LTD.");
        System.out.println("Your Bill amount is- " + bill);
        System.out.println("DueDate->" + formatter.format((LocalDate.now().plusDays(15))));
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
    }
    void personpay(String stk ,long pswd) {
        int count=0;
        String iD;
        int tempans;
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name-> " + stk + "                    ");
        System.out.println("Issuer->DGVCL PVT. LTD.");
        System.out.println("UserID-" + pswd);
        System.out.println("Proceed to the PAYMENT---->");
        do{
            if(count==3){
                System.out.println("Try Again Later....");
                return;
            }
            System.out.print("Enter Your UPI id : ");
            iD = sc.next();
            tempans=CombineProject.payment(bill,iD,"yvcl.okaadybank");
            count++;
        }while(tempans!=0);
    }
    void exit() {
            System.out.println("Thanks For Visiting");
            return;
    }
}