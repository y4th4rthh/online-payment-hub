package telecombill;
import payment.CombineProject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Recharge {
    public void telecombill() {
        String captcha;
        long pswd;
        int cap, cha;
        Detailz n1 = new Detailz();
        Scanner sc = new Scanner(System.in);
        Random lap = new Random();
        cap = lap.nextInt(111, 999);
        cha=lap.nextInt(164,9934);
        System.out.println("--------------------------------------------------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("-----------------------x-Recharge-x--------------------------");
            System.out.print("Enter your PhoneNo : ");
            pswd = sc.nextLong();
            sc.nextLine();
            if (pswd > 6000000000L && pswd < 9999999999L) {
                System.out.println("Your Captcha Code is-" + cap + "L&v" + cha);
                for (i = 0; i < 3; i++) {
                    System.out.print("Please reEnter your Captcha : ");
                    captcha = sc.nextLine();
                    if (captcha.equals(cap + "L&v" + cha)) {
                        System.out.println("Captcha Verified");
                        n1.run(pswd);
                        return;
                    } else {
                        System.out.println("Invalid Captcha.. Please Try Again");
                    }
                }
            } else {
                System.out.println("Invalid Input PhoneNo. must be of 10 digit");
            }
        }
    }
    public static void main(String[] args) {
        Recharge rb = new Recharge();
        rb.telecombill();
    }
}
class Detailz{
    Scanner sc = new Scanner(System.in);
    void run( long pswd) {
        Person r1 = new Person();
        int ans;
        String stk;
        System.out.print("Enter your Name:");
        stk = sc.nextLine();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Press-1-->Get AN Offer , Press-2-->Pay Bill Online , Press-3-->Exit");
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
    int j, py;
    int p;
    String u;
    int  m;
    long n;
    String str;
    float duedate;
    LocalDate l1 =LocalDate.now();
        LocalTime l2=LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    void person(String stk, long pswd){
System.out.println("-----------------------------------------------------------------------------------------");
System.out.println("Issuer-> Telecom India PVT.LTD");
System.out.println("Name-> " + stk + "                     " + "Date of Issue->" + formatter.format(l1) +" Time:-> " +l2);
System.out.println("Your PhoneNo.- "+pswd);
System.out.println("-----------------------------------------------------------------------------------------");
System.out.println("Price-->229");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->1.5 GB/Day");
System.out.println("Validity--> 28 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->359");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->3 GB/Day");
System.out.println("Validity--> 28 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->479");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->1.5 GB/Day");
System.out.println("Validity--> 56 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->719");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->1.5 GB/Day");
System.out.println("Validity--> 84 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->499");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->2 GB/Day");
System.out.println("Validity--> 56 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("Disney + Hotstar Subscription");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->3099");
System.out.println("Calls--> Truely Unlimited");
System.out.println("Data-->2 GB/Day");
System.out.println("Validity--> 365 Days");
System.out.println("weekend data rollover + binge all night");
System.out.println("Disney + Hotstar Subscription");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->99");
System.out.println("Calls Limidity--> Rs 99");
System.out.println("Data-->200 MB");
System.out.println("Validity--> 28 Days");
System.out.println("---------------------------------------");

System.out.println("---------------------------------------");
    System.out.println("Price-->111");
System.out.println("Calls Limidity--> Rs 111");
System.out.println("Data-->200 MB");
System.out.println("Validity--> 31 Days");
System.out.println("---------------------------------------");
}
void personpay(String stk ,long pswd) {
    int tempans;
    int count=0;
    String iD;
    System.out.println("------------------------------------------------------------");

    System.out.println("------------------------------------------------------------");
    System.out.println("Name-> " + stk + "                    ");
    System.out.println("Issuer-> Telecom India PVT. LTD.");
    System.out.println("Your PhoneNo-" + pswd);
    System.out.println("------------------------------------------------------------");
        while(true){
        System.out.println("Enter the payment amount according to offers");
        py = sc.nextInt();
        if(py==99 ||py==111 ||py==299 ||py==359 ||py==479 ||py==719 ||py==3099){
        do{
            if(count==3){
                System.out.println("Try Again Later....");
                return;
            }
            System.out.print("Enter Your UPI id : ");
            iD = sc.next();
            tempans=CombineProject.payment(py,iD,"yvcl.okaadybank");
            count++;
        }while(tempans!=0);
        break;
    }
    }
}
        void exit() {
        while(true){
            System.out.println("Thanks for Visiting!");
            return;
        }
        }

}