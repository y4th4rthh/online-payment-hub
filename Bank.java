//  BANK
package sastabank;
import java.util.Random;
import java.util.Scanner;
public class Bank{
    //Account Class
    public class Account{
            String name;
            String email;
            long mobileNum;
        public  String upiID;
            long acNum;
            int password;
        public int balance=0;
        public Account next;
            boolean hasUPIid=false;
            boolean isBlocked=false;
    }
    public static Account head=null;
    private byte ans;
    private int money;
        Scanner scan = new Scanner(System.in);
        Random number = new Random();
        //Set data without parameters.
        private void setData(){
            Account one = new Account();
            scan.nextLine();
            System.out.print("-> Enter Your Name : ");
            one.name=scan.nextLine();
            while(true){
                System.out.print("-> Enter Mobile Number : ");
                one.mobileNum=scan.nextLong();
                if(one.mobileNum>=1000000000L && one.mobileNum<=9999999999L){
                    break;
                }
                else{
                    System.out.println("   Enter Valid Number!!!!");
                }
            }
            System.out.print("-> Enter Your Email Id : ");
            one.email=scan.next();
            one.acNum = number.nextLong(10000000000000L,99999999999999L);
            System.out.println("-> Your Account Number : "+one.acNum);
            System.out.print("-> Set Password(only numbers) : ");
            one.password=scan.nextInt();
            System.out.println("\n   Your current balance is "+one.balance+" Rupees.");
            one.next=null;
            if(head==null){
                head = one;
            }
            else{
                Account temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=one;
            }
        }
        //set data with parameters.
        public  void setData(String name , long mobileNo , String e_id , long acNo , int pwd , int credit , String id){
            Account one = new Account();
            one.name=name;
            one.mobileNum=mobileNo;
            one.email=e_id;
            one.acNum =acNo;
            one.password=pwd;
            one.balance = credit;
            one.upiID=id;
            one.next=null;
            if(head==null){
                head = one;
            }
            else{
                Account temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=one;
            }
        }
        //To generate UPI id.
        private void generateUPI(Account ac){
            if(ac.hasUPIid==true){
                System.out.println("   Your Account Already has UPI Id.");
                System.out.println("-> Your UPI Id : "+ac.upiID);
                return;
            }
            String[] username=ac.email.split("@",2);
            ac.upiID=username[0]+".okaadybank";
            ac.hasUPIid=true;
            System.out.println("-> Your UPI Id : "+ac.upiID);
        }
        //To find Account by Account Number.
        private Account find(){
            long num;
            int pwd;
            System.out.print("-> Enter Account Number :");
            num=scan.nextLong();
            Account temp =head;
            while(temp!=null){
                if(temp.acNum==num){
                    break;
                }
                else{
                    temp=temp.next;
                }
            }
            if(temp==null){
                System.out.println("   Account doesn't exist. Please check your Account Number.");
                return null;
            }
            if(temp.isBlocked==true){
                System.out.println("   Your Account is Blocked for 24 hours.");
                System.out.println("   Account can't Accessed.");
                return null;
            }
            if(ans!=1){
                System.out.print("-> Enter Password : ");
            int count=1;
                while(true){
                    pwd = scan.nextInt();
                    if(count==3){
                        System.out.println("Your Account has been blocked for 24 hours!!!!");
                        temp.isBlocked=true;
                        return null;
                    }
                    if(pwd==temp.password){
                        break;
                    }
                    else{
                        System.out.println("   Password doesn't match.");
                        System.out.print("   ReEnter Password : ");
                        count++;
                    }    
                }
            }
            return temp;
        }
        private void deposite(Account ac){
            if(ac==null){return;}
            System.out.print("-> Enter Amount to deposite : ");
            money = scan.nextInt();
            ac.balance=ac.balance+money;
            System.out.println("-> Process Successfully Completed.");
        }
        private void withdrawl(Account ac){
            if(ac==null){return;}
            System.out.print("-> Enter Amount to Withdrawl : ");
            money = scan.nextInt();
            if(money>ac.balance){
                System.out.println("   You have not enough money.");
                System.out.println("   Your current Balance is "+ac.balance+" Rupees.");
                return;
            }
            else{
                ac.balance=ac.balance-money;
            }
            System.out.println("Your available balance is "+ac.balance+" Rupees.");
            System.out.println("Process Successfully Completed.");
        }
        private void details(Account ac){
            if(ac==null){return;}
            System.out.println("-> Name : "+ac.name);
            System.out.println("-> Mobile number : "+ac.mobileNum);
            System.out.println("-> Email id : "+ac.email);
            if(ac.hasUPIid==true){
                System.out.println("-> UPI id : "+ac.upiID);
            }
            System.out.println("-> Account number : "+ac.acNum);
            System.out.println("-> Current Balance : "+ac.balance+" Rupees");
        }
        private void accessAccount(){
            while(true){
                System.out.print("\n1--> Deposite , 2--> Withdrawl , 3--> Details , 4--> Generate UPI id , 5--> End process :");
                ans=scan.nextByte();
                if(ans==1){
                    System.out.println("\n-----------------------DEPOSITE---------------------");
                    deposite(find());
                    System.out.println("----------------------------------------------------\n");
                }
                else if(ans==2){
                    System.out.println("\n--------------------WITHDRAWL---------------------------------------------------");
                    withdrawl(find());
                    System.out.println("----------------------------------------------------");
                }
                else if(ans==3){
                    System.out.println("\n------------------ACCOUNT DETAILS-------------------");
                    details(find());
                    System.out.println("----------------------------------------------------");
                }
                else if(ans==4){
                    System.out.println("\n------------------GENERATE UPI ID-------------------");
                    generateUPI(find());
                    System.out.println("----------------------------------------------------");
                }
                else if(ans==5){
                    System.out.println("\n--------------------------------------------------------------------------------");
                    break;}
                else{
                    System.out.print("\n--------------------------------------------------------------------------------");
                    System.out.println("Inavlid input.");
                    System.out.print("--------------------------------------------------------------------------------");
                }
            }
        }
        //Main Method from where program starts.
    public void welcome(){
        System.out.println("\n------------------------------- WELCOME TO AADY BANK ---------------------------\n\n        Would you like to Create a New Account or Access Account ?");
        System.out.println("\n--------------------------------------------------------------------------------");
        while(true){
            System.out.print("Press 1--> New Account , 2--> Access Account , 3--> Leave Bank : ");
            ans = scan.nextByte();
            System.out.println("-------------------------------------------------------------------------------");
            if(ans==1){
                System.out.println("\n----------------------------------NEW ACCOUNT-----------------------------------");
                setData(); 
                System.out.println("--------------------------------------------------------------------------------");
            }
            else if(ans==2){
                System.out.print("\n---------------------------------ACCESS ACCOUNT---------------------------------");
                accessAccount();
            }
            else if(ans==3){
                break;}
            else{
                System.out.println("Invalid input.");
            }
        }    
    }    
}