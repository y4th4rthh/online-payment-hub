package moviebooking;
import payment.CombineProject;
import java.util.*;
public class MovieBookingTickets {
    Scanner sc = new Scanner(System.in);
    private class Screen {
        int screenNo;
        Show first=null;
        Show last = null;
        Screen next;
    }
    Screen start =null;
    Screen end = null;
    private class Show {
        String showType;
        String showTime;
        String movieName;
        Show next;
        Seat arrangement[] = new Seat[180];
    }
    private class Seat {
        int seatNo;
        int price;
        boolean isBooked = false;
    }
    private class Person{
        String name;
        String regestraionId;
        boolean isAdmin=false;
        String emailId;
        long mobileNumber;
        String password;
        Person next;
    }
    Person first=null;
    Person last=null;
    String pwd;
    private void login(){
        String id;
        System.out.print("Enter Your id : ");
        id=sc.next();
        Person temp=first;
        while(true){
            if(temp==null){
                System.out.println("Invalid Id !!!!");
                System.out.println("Please Recheck your Id or Register your Id.");
                return;
            }
            if(temp.regestraionId.equals(id)){
                break;
            }
            else{temp=temp.next;}
        }
        while(true){
            System.out.print("Enter Password : ");
            pwd=sc.next();
            if(pwd.equals(temp.password)){
                if(temp.isAdmin==true){
                    while(true){
                        System.out.print("Enter 1--> Available Shows , 2--> Book Ticket , 3--> Back :");
                        ans=sc.nextInt();
                        if(ans==1){
                            printShow();
                        }
                        else if(ans==2){
                            printShow();
                            bookTicket();
                        }
                        else if (ans==3){
                            return;
                        }
                        else{
                            System.out.println("Invalid Input!!!");
                        }
                    }
                }
                else{
                    while(true){
                        System.out.print("Enter 1--> Available Shows , 2--> Book Ticket , 3--> Back :");
                        ans=sc.nextInt();
                        if(ans==1){
                            printShow();
                        }
                        else if(ans==2){
                            printShow();
                            bookTicket();
                        }
                        else if (ans==3){
                            break;
                        }
                        else{
                            System.out.println("Invalid Input!!!");
                        }
                    }
                }
            }
            else{
                System.out.println("Incorrect Password!!!!");
            }
        }
    }
    private void regestration(){
        Person p1 = new Person();
        System.out.print("Enter Your Name : ");
        sc.nextLine();
        p1.name=sc.nextLine();
        while(true){
            System.out.print("Enter Your Mobile Numer : ");
            p1.mobileNumber=sc.nextLong();
            if(p1.mobileNumber>=1000000000L && p1.mobileNumber<=9999999999L)
            {
                break;
            }
            else{
                System.out.println("Enter Valid Mobile Number !!!");
            }
        }
        System.out.print("Enter Your Email id : ");
        p1.emailId=sc.next();
        System.out.print("Create Id : ");
        p1.regestraionId=sc.next();
        System.out.print("Create Password : ");
        p1.password=sc.next();
        p1.next=null;
        if(first==null){
            first=last=p1;
        }
        else{
            last.next=p1;
            last=p1;
        }
    }
    public void regestration(String name, long mobile ,String e_id , String id , String pwd, boolean admin){
        Person p1 = new Person();
        p1.name=name;
        p1.mobileNumber=mobile;
        p1.emailId=e_id;
        p1.regestraionId=id;
        p1.password=pwd;
        p1.isAdmin=admin;
        p1.next=null;
        if(first==null){
            first=last=p1;
        }
        else{
            last.next=p1;
            last=p1;
        }
    }
    int tempNum;
    private Screen findScreen(){
        Screen temp;
        while(true){
            temp = start;
            System.out.print("Select Screen Number :");
            tempNum=sc.nextInt();
        
        while(true){
            if(temp==null){
                break;
            }
            if(temp.screenNo==tempNum){
                break;
            }
            else{
                temp=temp.next;
            }
        }
        if(temp==null){
            System.out.println("Invalid Screen !!!");
        }
        else{
            break;
        }
    }
    return temp;
    }
    private Screen findScreen(int num){
        tempNum=num;
        Screen temp = start;
        while(true){
            if(temp.screenNo==tempNum){
                break;
            }
            else{
                temp=temp.next;
            }
        }
        return temp;
    }
    String tempString;
    private Show findShow(){
    Screen temp = findScreen();
    if(temp==null){
            System.out.println("Screen is not Available. Try Another Screen.");
            return null;
        }
    else{
            Show temp1 ;
        while(true){
            temp1 = temp.first;
            System.out.print("Select Show Type (Morning / Afternoon / Night) : ");
            tempString = sc.next();
            
    while(true){
        if(temp1==null){
            break;
        }
        else if(temp1.showType.toLowerCase().equals(tempString.toLowerCase())){
            break;
        }
        else{
            temp1=temp1.next;
        }
    }
    if(temp1==null){
        System.out.println("Invalid Show !!!");
    }
    else{
        break;
    }
    }
    showSitting(temp1);
    return temp1;
    }
}
    public void addShow( int screenNum , String type , String movie ,String time) {
        Screen temp = findScreen(screenNum);
        Show s = new Show();
        s.showType=type;
        s.movieName=movie;
        s.showTime=time;
        for (int i = 0; i < 180; i++) {
            s.arrangement[i] = new Seat();
            s.arrangement[i].seatNo = i + 1;
            if (i < 60) {
                s.arrangement[i].price = 110;
            } 
            else if (i >= 60 && i <105 ) {
                s.arrangement[i].price = 130;
            }
            else if(i>=105 && i<150){
                s.arrangement[i].price = 150;
            }
            else {
                s.arrangement[i].price = 170;
            }
        }
        s.next=null;
        if(temp.first==null){
            temp.first=temp.last=s;
        }
        else{
            temp.last.next=s;
            temp.last=s;
        }
    }
    public void addScreen(int screenNumber) {
        Screen s = new Screen();
        s.screenNo=screenNumber;
        s.next=null;
        if(start==null){
            start=end=s;
        }
        else{
            end.next=s;
            end=s;
        }    
    }
    String tempType;
    String tempMovie;
    String tempTime;
    private void printShow(){
        Screen temp = start;
        while(temp!=null){
        Show temp1;
                System.out.println("               SCREEN - "+temp.screenNo);
                System.out.println("");
                System.out.println("  TYPE          MOVIE                 TIME");
                temp1=temp.first;
                while(true){
                    if(temp1==null){
                        break;
                    }
                    else{
                        tempType = String.format("%-15s",temp1.showType);
                        tempMovie = String.format("%-15s",temp1.movieName);
                        tempTime = String.format("%-15s",temp1.showTime);
                        System.out.println(tempType + tempMovie + tempTime);
                        temp1=temp1.next;
                    }
                }
                temp=temp.next;
                System.out.println("");
            }
            System.out.println("");
    }
    int ans;
    String stringTemp;
    private void showSitting(Show temp){
        System.out.println("");
        System.out.println("           ------------------------------------------------------------------------");
        System.out.println("           |                                SCREEN                                |");
        System.out.println("           ------------------------------------------------------------------------");
        System.out.println("");
        for (int i = 0; i < 180; i++) {
            Seat temp1 = temp.arrangement[i];
            if(temp1.isBooked==false){
                stringTemp = String.format(" %03d ",temp1.seatNo);
                System.out.print(stringTemp);
            }
            else{
                System.out.print("  X  ");
            }
            if(i==14||i==29||i==44||i==59||i==74||i==89||i==104||i==119||i==134||i==149||i==164||i==179){
                if(i==59||i==104||i==149||i==179){
                    System.out.println("\n");
                    if(i==149){
                        System.out.print("          ");
                    }
                }
                else{
                    System.out.println("");
                    if(i==164){
                        System.out.print("          ");
                    }
                }
                
            }
            else if(i%10==4 ||i%10==9){
                if(i==154||i==159||i==169||i==174){
                }
                else
                System.out.print("          ");
            }
            
        }
        System.out.println("");
    }
    int tempInt;
    private Seat findSeat(){
        int i;
        Show temp = findShow();
        
        if(temp==null){
            System.out.println("Show is not Available. Try Another Show.");
            return null;
        }
        else{
            Seat tempx=null;
            System.out.println("-----Seat Price-----");
            System.out.println("001-060   110 Rs.");
            System.out.println("061-105   130 Rs.");
            System.out.println("106-150   150 Rs.");
            System.out.println("151-180   170 Rs.");
            while(true){    
            
            System.out.print("Enter You Selected Seat Number : ");
            tempInt=sc.nextInt();
            for(i=0 ; i<180 ;i++){
                if(temp.arrangement[i].seatNo==tempInt){
                    tempx = temp.arrangement[i];
                    break;
                }
            }
            if(tempx==null){
                System.out.println("Seat is Unavailable. Try Another Seat.");
            }
            else if(tempx.isBooked==true){
                System.out.println("Seat is Already Booked . Try Another Seat.");
            }
            else{
                break;
            }
        }
            return tempx;
        }
    
}
    String x;
    private void bookTicket(){
        while(true){
        Seat temp = findSeat();
        if(temp==null){
            System.out.println("Seat is unavailable. Try another Seat.");
        }
        else if(temp.isBooked==false){
            System.out.println("----------------------------PAYMENT------------------------\n");
            System.out.print("Enter UPI Id : ");
            x=sc.next();
            CombineProject.payment(temp.price,x,"aadycinema.okaadybank");
            
            temp.isBooked=true;
            System.out.println("Your Ticket is Booked.");
            return;
        }
        else{
            System.out.println("Seat is Already Booked. Try another Seat.");
        }
    }
        
    }
    public void proceed() {
        while (true) {
            System.out.print("Press  1--> Login , 2--> Regestration ,  3--> Logout:  ");
            ans = sc.nextInt();
            if (ans == 1) {
                login();
            } else if (ans == 2) {
                regestration();
            } else if (ans == 3) {
                break;
            } else if (ans >= 4 || ans <= 0) {
                System.out.println("Invalid Input.");
            }
        }
    }
}