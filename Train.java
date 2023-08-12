//   TRAIN
package train;
import payment.CombineProject;
import java.util.Scanner;
public class Train{
    public class Station{
        String stationName;
        String trainList[][] = new String[20][4];
        byte totalTrain=0;
        Station nextStation;
        Station prevStation;
    }
    private class NewTrain{
        String name;
        int trainNumber;
        int coachCount=0;
        int baseCost;
        NewTrain nextTrain;
        Coach first=null;
        Coach last=null;
    }
    NewTrain firstTrain=null;
    NewTrain lastTrain=null;
    public class Coach{
        String coachName;
        Seat arrangement[][] = new Seat[20][6];
        Coach next;
    }
    public class Seat{
        byte seatNo;
        String type;
        boolean isBooked=false;
    }
    private void createTrain(){
        NewTrain t = new NewTrain();
        System.out.print("Enter Train Name : ");
        t.name=scan.next();
        System.out.print("Enter Train Number : ");
        t.trainNumber=scan.nextInt();
        System.out.print("Enter Base Cost : ");
        t.baseCost=scan.nextInt();
        t.nextTrain=null;
        if(firstTrain==null){
            firstTrain=lastTrain=t;
        }
        else{
            lastTrain.nextTrain=t;
            lastTrain=t;
        }
    }
    public void createTrain(String name , int trainNo , int baseCost ){
        NewTrain t = new NewTrain();
        t.name=name;
        t.trainNumber=trainNo;
        t.baseCost=baseCost;
        t.nextTrain=null;
        if(firstTrain==null){
            firstTrain=lastTrain=t;
        }
        else{
            lastTrain.nextTrain=t;
            lastTrain=t;
        }
    }
    private NewTrain searchTrain(int no){
        NewTrain temp = firstTrain;
            while(true){
                if(temp==null){
                    break;
                }
                if(temp.trainNumber==no){
                    break;
                }
                temp = temp.nextTrain;
            }
            return temp;
            
    }
    private void addCoach(){
        int temp;
        NewTrain tempo;
        while(true){
            System.out.print("Enter Train Number : ");
            temp=scan.nextInt();
            tempo = searchTrain(temp);
            if(tempo==null){
                System.out.println("No Train Found.\n");
            }
            else{
                break;
            }
        }
        Coach d = createCoach();
        tempo.coachCount++;
        d.coachName = "D"+ Integer.toString(tempo.coachCount);
        d.next=null;
        if(tempo.first==null){
            tempo.first=tempo.last=d;
        }
        else{
            tempo.last.next=d;
            tempo.last=d;
        }
        System.out.println("Coach Is Successfully Added to "+tempo.name+"\n");
    }
    public void addCoach(int num){
        NewTrain tempo = searchTrain(num);
        Coach d = createCoach();
        tempo.coachCount++;
        d.coachName = "D"+ Integer.toString(tempo.coachCount);
        d.next=null;
        if(tempo.first==null){
            tempo.first=tempo.last=d;
        }
        else{
            tempo.last.next=d;
            tempo.last=d;
        }
    }
    public Coach createCoach(){
        byte count=1;
        Coach c = new Coach();
        for(byte i=0 ; i<20 ;i++){
            for(byte j=0; j<6; j++){
                c.arrangement[i][j] = new Seat();
                c.arrangement[i][j].seatNo=count;
                if(j==0||j==5){
                    c.arrangement[i][j].type="Window";
                }
                else if(j==1||j==4){
                    c.arrangement[i][j].type="Middle";
                }
                else{
                    c.arrangement[i][j].type="Asile";
                }
                count++;
            }
        }
        return c;
    }
public void printCoach(Coach x){
        for(byte i=0;i<20 ; i++){
            for(byte j=0 ; j<6;j++){
                System.out.print(x.arrangement[i][j].seatNo+"-"+x.arrangement[i][j].type+" , ");
            }
            System.out.println("");
        }
}
        private Station startingStation=null;
        private Station endStation=null;
        private Station temp;
        private String nearestStation;
        private String destination;
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
        private byte ans;
        String pwd;
        private String adminPassword="password";
    Scanner scan = new Scanner(System.in);
    private void addStation(){
        while(true){
            System.out.print("Enter 1--> Add Station At First , 2--> Add Station After , 3--> Back : ");
        ans=scan.nextByte();
        if(ans==1){addStationAtFirst();}
        else if(ans==2){addStationAfter();}
        else if(ans==3){break;}
        else{
            System.out.println("Invalid Input!!!");
        }
        }
    }
    private void addStationAtFirst(){
        Station s = new Station();
        System.out.print("Enter Station Name : ");
        s.stationName=scan.next();
        s.prevStation=null;
        if(startingStation==null){
            startingStation=endStation=s;
            s.prevStation=null;
        }
        else{
            startingStation.prevStation=s;
            s.nextStation=startingStation;
            startingStation=s;
        }
    }
    private void addStationAfter(){
        String name;
        while(true){
                System.out.print("Enter Station name After which you want to add Station : ");
            name = scan.next();
            Station temp = startingStation;
            while(true){
                if(temp.stationName.equals(name)){
                    break;
                }
                else{
                    temp=temp.nextStation;
                }
            }
            if(temp==null){
                System.out.println("No Station Found.");
            }
            else{
                break;
            }
        }
        Station s = new Station();
        System.out.print("Enter name of Station : ");
        s.stationName=scan.next();

        if(temp.nextStation==null){
            s.nextStation=null;
            endStation.nextStation=s;
            s.prevStation=endStation;
            endStation=s;
        }
        else{
            s.nextStation=temp.nextStation;
            temp.nextStation.prevStation=s;
            temp.nextStation=s;
            s.prevStation=temp;
        }
        
    }
    public void addStation(String name){
        Station s = new Station();
        s.stationName=name;
        s.nextStation=null;
        if(startingStation==null){
            startingStation=endStation=s;
        }
        else{
            endStation.nextStation=s;
            endStation=s;
        }
    }
    private Station findStation(){
        String tempName;
        System.out.print("Enter Station Name :");
        tempName=scan.next();
        temp=startingStation;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.stationName.equals(tempName)){
                break;
            }
            temp=temp.nextStation;
        }
        return temp;
    }
    private void login(){
        String id;

        System.out.print("Enter id : ");
        id=scan.next();
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
            pwd=scan.next();
            if(pwd.equals(temp.password)){
                if(temp.isAdmin==true){
                    while(true){
                        System.out.println("----------------------------------------------------\n");
                        System.out.print("Enter 1--> Operate Stations , 2--> Find Trains , 3-->Book Ticket , 4--> Back:  ");
                        ans=scan.nextByte();
                        if(ans==1){
                            System.out.println("----------------------------------------------------\n");
                            operateStation();
                        }
                        else if(ans==2){
                            System.out.println("----------------------------------------------------\n");
                            findTrains();
                        }
                        else if(ans==3){
                            System.out.println("----------------------BOOK TICKET-----------------\n");
                            bookTicket();
                        }
                        else if(ans==4){return;}
                        else{
                            System.out.println("Invalid Input!!!");
                            System.out.print("Enter 1--> Operate Stations , 2--> Find Trains , 3-->Book Ticket , 4--> Back:  ");
                        }
                    }
                }
                else{
                    while(true){
                        System.out.println("----------------------------------------------------\n");
                        System.out.print("Enter  1--> Find Trains , 2-->Book Ticket , 3--> Back:  ");
                        ans=scan.nextByte();
                        if(ans==1){
                            System.out.println("----------------------------------------------------\n");
                            findTrains();
                        }
                        else if(ans==2){
                            System.out.println("----------------------------------------------------\n");
                            bookTicket();
                        }
                        else if(ans==3){return;}
                        else{
                            System.out.println("Invalid Input!!!");
                            System.out.print("Enter  1--> Find Trains , 2-->Book Ticket , 3--> Back:  ");
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
        scan.nextLine();
        p1.name=scan.nextLine();
        while(true){
            System.out.print("Enter Your Mobile Numer : ");
            p1.mobileNumber=scan.nextLong();
            if(p1.mobileNumber>=1000000000L && p1.mobileNumber<=9999999999L){
                break;
            }
            else{
                System.out.println(" Enter Valid Number!!!!");
            }
        }
        System.out.print("Enter Your Email id : ");
        p1.emailId=scan.next();
        System.out.print("Create Id : ");
        p1.regestraionId=scan.next();
        System.out.print("Create Password : ");
        p1.password=scan.next();
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
    public Station findStation(String x){
        temp=startingStation;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.stationName.toLowerCase().equals(x.toLowerCase())){
                break;
            }
            temp=temp.nextStation;
        }
        return temp;
    }
    private void modifyTrain(Station temp){
        while(true){
            if(temp==null){
                System.out.println("No Station Found");
                return;
            }
            System.out.print("Enter 1--> Add , 2--> Remove , 3--> End : ");
            ans=scan.nextByte();
            if(ans==1){
                addTrain(temp);
            }
            else if(ans==2){
            }
            else if(ans==3){
                break;
            }
            else{
                System.out.println("Invalid Input.");
            }
        }
        
    }
    private void addTrain(Station x)
    {
        System.out.print("Enter Name of the Train :");
        x.trainList[x.totalTrain][0]=scan.next();
        System.out.print("Enter Arrival Time :");
        x.trainList[x.totalTrain][1]=scan.next();
        System.out.print("Enter Departure Time :");
        x.trainList[x.totalTrain][2]=scan.next();
        System.out.print("Train Number :");
        x.trainList[x.totalTrain][3]=scan.next();
        x.totalTrain++;
    }
    public void addTrain(String x , String name , String arrival , String departure , String trainNo )
    {
        Station temp = findStation(x);
        temp.trainList[temp.totalTrain][0]=name;
        temp.trainList[temp.totalTrain][1]=arrival;
        temp.trainList[temp.totalTrain][2]=departure;
        temp.trainList[temp.totalTrain][3]=trainNo;
        temp.totalTrain++;
    }
    private void findTrains(){
        Station s1;
        Station s2;
        while(true){
            System.out.print("Enter your Nearest Station :");
            nearestStation=scan.next();
            s1=findStation(nearestStation);
            if(s1!=null){
                break;
            }
            else{
                System.out.println("No Station Found.");
            }
        }
        while(true){
            System.out.print("Enter your Destination :");
            destination=scan.next();
            s2=findStation(destination);
            if(s2!=null){
                break;
            }
            else{
                System.out.println("No Station Found.");
            }
        }
        for(int i=0;i<s1.totalTrain;i++){
            for(int j=0;j<s2.totalTrain;j++){
                if(s1.trainList[i][0].equals(s2.trainList[j][0])){
                    System.out.println("---------TRAIN - "+(i+1)+"--------");
                    System.out.println("Name of Train :"+s1.trainList[i][0]);
                    System.out.println("Arrival Time :"+s1.trainList[i][1]);
                    System.out.println("Departure Time :"+s1.trainList[i][2]);
                    System.out.println("Train Number :"+s1.trainList[i][3]);
                }
            }
        }
    }
    private void operateStation(){
        while(true){
                System.out.print("Enter 1--> Add Station , 2--> Create New Train , 3--> Add Coach , 4--> Modify Train Timing ,5--> Exit : ");
                ans=scan.nextByte();
                if(ans==1){addStation();}
                else if(ans==2){createTrain();}
                else if(ans==3){addCoach();}
                else if(ans==4){modifyTrain(findStation());}
                else if(ans==5){break;}
                else{
                    System.out.println("Invalid Input.");
                }
        }
    }
    int tempans;
    private void bookTicket(){
        int totalCost=0;
        int tempNumber;
        Station s1;
        Station s2;
        while(true){
            System.out.print("Enter your Nearest Station :");
            nearestStation=scan.next();
            s1=findStation(nearestStation);
            if(s1!=null){
                break;
            }
            else{
                System.out.println("No Station Found.");
            }
        }
        while(true){
            System.out.print("Enter your Destination :");
            destination=scan.next();
            s2=findStation(destination);
            if(s2!=null){
                break;
            }
            else{
                System.out.println("No Station Found.");
            }
        }
        System.out.println("\n----------------------AVAILABLE TRAINS--------------------\n");
        for(int i=0;i<s1.totalTrain;i++){
            for(int j=0;j<s2.totalTrain;j++){
                if(s1.trainList[i][0].equals(s2.trainList[j][0])){
                    System.out.println("---------TRAIN - "+(i+1)+"--------");
                    System.out.println("Name of Train :"+s1.trainList[i][0]);
                    System.out.println("Arrival Time :"+s1.trainList[i][1]);
                    System.out.println("Departure Time :"+s1.trainList[i][2]);
                    System.out.println("Train Number :"+s1.trainList[i][3]);
                }
            }
        }
        NewTrain n;
        Station temp;
        Byte tempCount =0;
        Byte count=0;
            System.out.println("\n----------------------------------------------------\n");
            while(true){
                System.out.print("Enter your selected Train Number : ");
                tempNumber=scan.nextInt();
                temp = s1;
                while(temp!=s2){
                    temp=temp.nextStation;
                    tempCount++;
                }
                n = searchTrain(tempNumber);
                if(n!=null){
                    break;
                }
                else{
                    System.out.println("No Train Found !");
                }
            }
            totalCost=n.baseCost+(tempCount*5);
            getInfo();
            String iD;
            System.out.println("\n------------------------PAYMENT------------------------\n");
            do{
                if(count==3){
                    System.out.println("Try Again Later....");
                    return;
                }
                System.out.print("Enter Your UPI id : ");
                iD = scan.next();
                tempans=CombineProject.payment(totalCost,iD,"arctc.okaadybank");
                count++;
            }while(tempans!=0);
            System.out.println("---------------------------------------------------------\n");
            System.out.println("YOUR TICKETS ARE BOOKED.");
            System.out.println("----------YOUR TICKET----------");
            findSeat(n, pref);
            System.out.println("Train :"+n.name);
            System.out.println("Train no :"+n.trainNumber);
            System.out.println("Journey : "+nearestStation+" To "+destination);
            System.out.println("-------------------------------\n");
            
    }
    private String name;
    private byte age;
    private byte pref;

    private void getInfo(){
        System.out.println("\n-----------------------PASSANGER INFORMATION------------------\n");
        System.out.print("Enter Name : ");
        name= scan.next();
        System.out.print("Enter Age : ");
        age=scan.nextByte();
        while(true){
            System.out.print("Enter Preference 1--> Window , 2--> Middle , 3--> Asile , 4--> No Preference : ");
            pref=scan.nextByte();
            if(pref == 1 || pref == 2 || pref == 3 || pref == 4){
                break;
            }
            else{
                System.out.println("Invalid Preference !");
            }
        }
        System.out.println("\n----------------------------------------------------");
    }
    private void findSeat(NewTrain x , byte pref){
        byte i,j; 
        Coach temp = x.first;
        while(temp!= null){
            if(pref==1){
                for(i=0 ; i<20 ;i++){
                    if(temp.arrangement[i][0].isBooked==false){
                        temp.arrangement[i][0].isBooked=true;
                        System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][0].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][0].type);
                        return;
                    }
                    else if(temp.arrangement[i][5].isBooked==false){
                        temp.arrangement[i][5].isBooked=true;
                        System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][5].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][5].type);
                        return;
                    }
                    else{
                        temp=temp.next;
                    }
                }
            }
            else if(pref==2){
                for(i=0 ; i<20 ;i++){
                    if(temp.arrangement[i][1].isBooked==false){
                        temp.arrangement[i][1].isBooked=true;
                        System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][1].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][1].type);
                        return;
                    }
                    else if(temp.arrangement[i][4].isBooked==false){
                        temp.arrangement[i][4].isBooked=true;
                        System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][4].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][4].type);
                        return;
                    }
                    else{
                        temp=temp.next;
                    }
                }
            }
            else if(pref==3){
                for(i=0 ; i<20 ;i++){
                    if(temp.arrangement[i][2].isBooked==false){
                        temp.arrangement[i][2].isBooked=true;
                        System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][2].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][2].type);
                        return;
                    }
                    else if(temp.arrangement[i][3].isBooked==false){
                        temp.arrangement[i][3].isBooked=true;System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][3].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][3].type);
                        return;
                    }
                    else{
                        temp=temp.next;
                    }
                }
            }
            else if (pref==4){
                for(i=0;i<20;i++){
                    for(j=0;j<6;j++){
                        if(temp.arrangement[i][j].isBooked==false){
                            temp.arrangement[i][j].isBooked=true;
                            System.out.println("Name : "+name);
                        System.out.println("Age : "+age+" Years");
                        System.out.println("Coach : "+temp.coachName);
                        System.out.println("Seat No : "+temp.arrangement[i][j].seatNo);
                        System.out.println("Type : "+temp.arrangement[i][j].type);
                        return;
                        }
                        else{
                            temp=temp.next;
                        }
                    }
                    
                }
            }
        }
    }
    public void run(){
        while(true){
            System.out.println("\n--------------------Train Booking--------------------");
            System.out.print("Enter 1--> Login , 2--> Registeration , 3--> Exit : ");
            ans=scan.nextByte();
            if(ans==1){
                System.out.println("\n-----------------------LOGIN------------------------\n");
                login();
            }
            else if(ans==2){
                System.out.println("----------------------------------------------------\n");
                regestration();
            }
            else if(ans==3){break;}
            else{System.out.println("Invalid Input.");}
        }
    }
    public static void main(String args[]){
        Train t  = new Train();

    }
}