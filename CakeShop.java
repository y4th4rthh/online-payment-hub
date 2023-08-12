package cakeshop;
import payment.CombineProject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static java.lang.System.exit;
public class CakeShop {

    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    static Scanner sc = new Scanner(System.in);
    int choice, c, cost, rs, total_Cost = 0;
    String[] cake_name = new String[100];
    int[] weight = new int[100];
    int[] price = new int[100];

    public int page() {
        System.out.println(
                "\n\n---------------------------- WELCOME TO -----------------------------\n                         THE QUEEN BAKER ");
        System.out.println("                                             # WE BAKE HAPPINESS... ");// moblie no. and
                                                                                                   // name address
        System.out.print(
                " Enter 1 to Show Menu\n Enter 2 to Show Special Offers \n Enter 3 to Order \n Enter 4 to exit : ");
        choice = sc.nextInt();

        return choice;
    }

    public void menu() {
        System.out.println("-------------------------------|| MENU ||------------------------------");
        System.out.println(" \n\n--------------- SPECIAL CAKES --------------\n");
        System.out.println(
                " 1. PAN GULKAND\n 2. RASMALAI \n 3. PISTA CAKE \n 4. RAINBOW CAKE \n 5. PINATA CAKE  \n 6. VENILA CAKE  \n 7. STRAWBERRY CAKE \n 8. MANGO CAKE \n 9. PINEAPPLE CAKE \n10. KIWI CAKE \n11. BLUE BERRY CAKE \n12. MIXES FRUIET   \n13. ROSE FALUDA \n14. BUTTER SCOTCH \n15. RAJBHOG \n16. RED VAVLET \n17. FLOWER BASKET \n18. TENDER COCONUT \n19. DOLL CKAE \n");
        System.out.println(" -------------- CHOCOLATE CAKES --------------\n");
        System.out.println(
                " 1. BLACk FOREST \n 2. WHITE FOREST  \n 3. OREO CAKE \n 4. NUTELLA CAKE \n 5. CHOCOLATE TRUFFLE CAKE  \n 6. CHOCOLATE ALMOND CAKE  \n 7. CHOCOLATE CHIPS CAKE \n 8. KITKAT CAKE \n 9. CHOKO DRIP CAKE \n10. CHOKO ORENGE CAKE \n11. DUTCH CHOCOLATE CAKE \n12. CHOCOLATE WALNUT   \n13. MOUSSE CAKE \n");

        while (true) {
            System.out.print(" Enter 1 to ORDER \n ENTER 2 TO GO HOME PAGE : ");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.print("\nHow many Cake you want to Order : ");
                int t = sc.nextInt();
                sc.nextLine();
                order(t, t, total_Cost);
            } else if (ch == 2) {

                run();
            } else {
                System.out.println("------------- please Enter correct value! -------------");
            }
        }
    }

    public void specialOffers() {
        System.out.println("\n-------------------------------|| MENU ||------------------------------");
        System.out.println(" \n\n--------------- SPECIAL CAKES --------------\n");
        System.out.println(
                " 1. PAN GULKAND\n 2. RASMALAI \n 3. PISTA CAKE \n 4. RAINBOW CAKE \n 5. PINATA CAKE  \n 6. VENILA CAKE  \n 7. STRAWBERRY CAKE \n 8. MANGO CAKE \n 9. PINEAPPLE CAKE \n10. KIWI CAKE \n11. BLUE BERRY CAKE \n12. MIXES FRUIET   \n13. ROSE FALUDA \n14. BUTTER SCOTCH \n15. RAJBHOG \n16. RED VAVLET \n17. FLOWER BASKET \n18. TENDER COCONUT \n19. DOLL CKAE \n");
        System.out.println(" -------------- CHOCOLATE CAKES --------------\n");
        System.out.println(
                " 1. BLACk FOREST \n 2. WHITE FOREST  \n 3. OREO CAKE \n 4. NUTELLA CAKE \n 5. CHOCOLATE TRUFFLE CAKE  \n 6. CHOCOLATE ALMOND CAKE  \n 7. CHOCOLATE CHIPS CAKE \n 8. KITKAT CAKE \n 9. CHOKO DRIP CAKE \n10. CHOKO ORENGE CAKE \n11. DUTCH CHOCOLATE CAKE \n12. CHOCOLATE WALNUT   \n13. MOUSSE CAKE \n");

        System.out.println("->->->->->->->->->->->->->-> || FESTIVAL OFFERS || <-<-<-<-<-<-<-<-<-<-<-<-<-<-");

        System.out.println(" \n------------- DIWALI SPECIAL OFFER --------------");
        System.out.println("\n -> Get 10% Discount on Purchase Above 1000 Rs\\. ");

        System.out.println(" \n------------- CHRISTMAS SPECIAL OFFER --------------");
        System.out.println("\n -> Get 2 Fire Candle Free on Purchase Above 1000 Rs\\. ");

        System.out.println(" \n------------- HOLI SPECIAL OFFER --------------");
        System.out.println("\n ->Get 2 Pestre Free on Purchase Above 1500 Rs\\. ");

        System.out.println(" \n------------- GANESH CHATURTHI SPECIAL OFFER --------------");
        System.out.println("\n -> Get MODAK PESTRE Free on Purchase Above 500 Rs\\. ");

        System.out.println("\n\n->->->->->->->->->->->->->-> || REGULAR OFFERS || <-<-<-<-<-<-<-<-<-<-<-<-<-<-");

        System.out.println(" \n\n -> Get 1 Fire Candle Free on purchase above 1000 Rs. ");

        System.out.println("\n -> 10% Discoutn on purchase above 2000 Rs. ");

        System.out.println("\n______________________________\n");

        while (true)

        {
            System.out.println("\n Enter 1 to Order Now \n Enter 2 to go HOME PAGE : ");
            int d = sc.nextInt();
            if (d == 1) {
                System.out.println("How Many Cake you want to order ? ");
                int t = sc.nextInt();
                sc.nextLine();
                order(t, t, total_Cost);
                break;

            } else if (d == 2) {
                run();
            } else {
                System.out.println("please Enter Right Number!");
            }
        }
    }

    public void order(int t, int l, int total_Cost) {
        System.out.println("\n-------------------------------|| MENU ||------------------------------");
        System.out.println(" \n\n--------------- SPECIAL CAKES --------------\n");
        System.out.println(
                " 1. PAN GULKAND\n 2. RASMALAI \n 3. PISTA CAKE \n 4. RAINBOW CAKE \n 5. PINATA CAKE  \n 6. VENILA CAKE  \n 7. STRAWBERRY CAKE \n 8. MANGO CAKE \n 9. PINEAPPLE CAKE \n10. KIWI CAKE \n11. BLUE BERRY CAKE \n12. MIXES FRUIET   \n13. ROSE FALUDA \n14. BUTTER SCOTCH \n15. RAJBHOG \n16. RED VAVLET \n17. FLOWER BASKET \n18. TENDER COCONUT \n19. DOLL CKAE \n");
        System.out.println(" -------------- CHOCOLATE CAKES --------------\n");
        System.out.println(
                " 1. BLACk FOREST \n 2. WHITE FOREST  \n 3. OREO CAKE \n 4. NUTELLA CAKE \n 5. CHOCOLATE TRUFFLE CAKE  \n 6. CHOCOLATE ALMOND CAKE  \n 7. CHOCOLATE CHIPS CAKE \n 8. KITKAT CAKE \n 9. CHOKO DRIP CAKE \n10. CHOKO ORENGE CAKE \n11. DUTCH CHOCOLATE CAKE \n12. CHOCOLATE WALNUT   \n13. MOUSSE CAKE \n");

        for (int i = t; i > 0;)

        {
            while (true) {
                int num = l - t + 1;

                System.out.print(
                        " \n -> Enter THE NAME of CAKE (as shown in menu in capital latters)  CAKE " + num + " : ");

                String s1 = sc.nextLine();
                if (s1.toUpperCase().equals("PAN GULKAND") || s1.toUpperCase().equals("PISTA CAKE") || s1.toUpperCase().equals( "RAINBOW CAKE")
                        || s1.toUpperCase().equals("PINATA CAKE") || s1.toUpperCase().equals("VENILA CAKE") || s1.toUpperCase().equals("STRAWBERRY CAKE")
                        || s1.toUpperCase().equals("MANGO CAKE") || s1.toUpperCase().equals("PINEAPPLE CAKE") || s1.toUpperCase().equals("KIWI CAKE")
                        || s1.toUpperCase().equals("BLUE BERRY CAKE") || s1.toUpperCase().equals("MIXES FRUIET") || s1.toUpperCase().equals("ROSE FALUDA")
                        || s1.toUpperCase().equals("BUTTER SCOTCH") || s1.toUpperCase().equals("RAJBHOG") || s1.toUpperCase().equals("RED VAVLET")
                        || s1.toUpperCase().equals("FLOWER BASKET") || s1.toUpperCase().equals("TENDER COCONUT") || s1.toUpperCase().equals("RASMALAI")
                        || s1.toUpperCase().equals("CHOCOLATE WALNUT") || s1.toUpperCase().equals("CHOCOLATE ALMOND CAKE")
                        || s1.toUpperCase().equals("CHOCOLATE TRUFFLE CAKE") || s1.toUpperCase().equals("BLACK FOREST") || s1.toUpperCase().equals("WHITE FOREST")
                        || s1.toUpperCase().equals("OREO CAKE") || s1.toUpperCase().equals("NUTELLA CAKE") || s1.toUpperCase().equals("CHOCOLATE CHIPS CAKE")
                        || s1.toUpperCase().equals("KITKAT CAKE") || s1.toUpperCase().equals("CHOKO DRIP CAKE") || s1.toUpperCase().equals("CHOKO ORENGE CAKE")
                        || s1.toUpperCase().equals("DUTCH CHOCOLATE CAKE") || s1.toUpperCase().equals("MOUSSE CAKE") || s1.toUpperCase().equals("DOLL CAKE")) {
                    System.out.print(" \n -> Enter THE NAME TO WRITE ON CAKE : ");
                    String s2 = sc.nextLine();

                    System.out.print(" \n -> How many GRAM of cake do you want ?(Only in numbers) : ");
                    int gm = sc.nextInt();
                    System.out.print(" \n -> Enter your Address : ");

                    String s5 = sc.nextLine();
                    sc.nextLine();
                    i--;
                    payment(s1, gm, s2, t, l, num, total_Cost);
                } else
                    System.out.println("--------------- please Enter the NAME As per menu! ---------------\n");
            }
        }
    }
    public void payment(String s, int gm, String s2, int h, int k, int num, int total_Cost) {

        for (int j = h; j >= 0;) {

            if (s.toUpperCase().equals("PAN GULKAND") || s.toUpperCase().equals( "PISTA CAKE") || s.toUpperCase().equals("RAINBOW CAKE")
                    || s.toUpperCase().equals("PINATA CAKE") || s.toUpperCase().equals("VENILA CAKE") || s.toUpperCase().equals("STRAWBERRY CAKE")
                    || s.toUpperCase().equals("MANGO CAKE") || s.toUpperCase().equals("PINEAPPLE CAKE") || s.toUpperCase().equals("KIWI CAKE")
                    || s.toUpperCase().equals("BLUE BERRY CAKE") || s.toUpperCase().equals("MIXES FRUIET") || s.toUpperCase().equals("ROSE FALUDA")
                    || s.toUpperCase().equals("BUTTER SCOTCH") || s.toUpperCase().equals("RAJBHOG") || s.toUpperCase().equals("RED VAVLET")
                    || s.toUpperCase().equals("FLOWER BASKET") || s.toUpperCase().equals("TENDER COCONUT")) {

                cost = (gm * 6) / 10;

                System.out.println(" \n           You have to pay " + cost + " Rs. ! FOR THIS CAKE ");

            } else if (s.toUpperCase().equals("RASMALAI") || s.toUpperCase().equals("CHOCOLATE WALNUT") || s.toUpperCase().equals("CHOCOLATE ALMOND CAKE")
                    || s.toUpperCase().equals("CHOCOLATE TRUFFLE CAKE")) {

                cost = (gm * 8) / 10;// 400
                System.out.println(" \n           You have to pay " + cost + " Rs. ! FOR THIS CAKE");

            } else if (s.toUpperCase().equals("BLACK FOREST") || s.toUpperCase().equals("WHITE FOREST") || s.toUpperCase().equals("OREO CAKE")
                    || s.toUpperCase().equals("NUTELLA CAKE") || s.toUpperCase().equals("CHOCOLATE CHIPS CAKE") || s.toUpperCase().equals("KITKAT CAKE")
                    || s.toUpperCase().equals("CHOKO DRIP CAKE") || s.toUpperCase().equals("CHOKO ORENGE CAKE") || s.toUpperCase().equals("DUTCH CHOCOLATE CAKE")
                    || s.toUpperCase().equals("MOUSSE CAKE")) {
                cost = (gm * 5) / 10;// 250
                System.out.println(" \n           You have to pay " + cost + " Rs. ! FOR THIS CAKE ");
            } else if (s.toUpperCase().equals("DOLL CAKE")) {
                cost = gm;// 500

                System.out.println(" \n           You have to pay " + cost + " Rs. ! FOR THIS CAKE ");
            }

            total_Cost = total_Cost + cost;

            bill(s, gm, cost, num, j, k, s, s2);

            j--;
            if (j > 0) {

                order(j, k, total_Cost);
            }

            if (j == 0) {

                // total_Cost = total_Cost + cost;
                if (total_Cost > 2000) {
                    total_Cost = total_Cost - (total_Cost * 10) / 100;
                    System.out.println("\n           YOU HAVE TO PAY TOTAL : " + total_Cost
                            + " Rs. (FOR ALL CAKES) ( with 10% discount ) ");
                } else
                    System.out.println("\n           YOU HAVE TO PAY TOTAL : " + total_Cost + " Rs.( FOR ALL CAKES) ");

                System.out.print("\n Enter your name : ");
                String customerName = sc.nextLine();

                bill(s, gm, cost, num, j, k, customerName, s2);
            }
        }
    }
    public void bill(String s, int gm, int cost, int num, int j, int m, String customerName, String s2) {
        if (j > 0)
            cake_name[j] = s;
        weight[j] = gm;
        price[j] = cost;
        int total = 0;
        if (j == 0) {
            System.out.print("\n\n-------------------------------|| BILL ||------------------------------\n");
            System.out.println("\nSHOP NAME : THE QUEEN BAKER                   DATE : " + formatDate.format(date));
            System.out.println("                                              TIME : " + formatTime.format(time));
            System.out.println("\nCostomer Name : " + customerName);
            System.out.println("\nsr. no.      CAKE NAME              WIEGHT                  PRICE  ");
            System.out.println("-----------------------------------------------------------------------\n");
            for (int f = 1; f <= m; f++)
            {
                total = total + price[f];
                System.out.println(f + ".        " + cake_name[m + 1 - f] + "                 " + weight[m + 1 - f]
                        + " gm                 " + price[m + 1 - f] + " Rs.");
            }
            if (total > 2000) {
                int discount = (total * 10) / 100;
                int total_cost = total - discount;
                System.out.println("-----------------------------------------------------------------------\n");
                System.out.println("                                                    TOTAL : " + total + " Rs.");
                System.out.print("    WITH 10% Discount  TOTAL : " + total_cost);
            } else {
                System.out.println("-----------------------------------------------------------------------\n");
                System.out.println("                                                    TOTAL : " + total + " Rs.");
            }
            System.out.println("\n-----------------------------------------------------------------------\n ");
            getTotal_Cost(total, s2);
        }
    }
    int tempans;
    int count=0;
    public void getTotal_Cost(int total_Cost, String s2) {
        System.out.println("\n---------------------------|| PAYMENT ||---------------------------");
        String iD;
        do{
                if(count==3){
                    System.out.println("Try Again Later....");
                    return;
                }
                System.out.print("Enter Your UPI id : ");
                iD = sc.next();
                tempans=CombineProject.payment(total_Cost,iD,"arctc.okaadybank");
                count++;
            }while(tempans!=0);
        feedback(s2); // s2 name write on cake
    }
    public void feedback(String s2) {
        System.out.println("\n______________________________\n ");
        System.out.println("HAPPY BIRTHDAY TO " + s2 + "\n               From THE QUEEN BAKER...");
        System.out.println("\n______________________________\n ");
        sc.nextLine();
        System.out.println(" \n Enter Your Honest Feedback : ");

        String s1 = sc.nextLine();
        System.out.println("\n______________________________\n ");
        System.out.println(
                "\nTHANK YOU!... for Order Cake From The Queen Baker , Hope You Enjoy... \n               HAVE A WONDERFUL DAY...\n ");
                CombineProject cb = new CombineProject();
                cb.start();
    }
    public void run() {
        while (true) {
            c = page();
            switch (c) {
                case 1:
                    menu();
                    break;
                case 2:
                    specialOffers();
                    break;
                case 3:
                    System.out.print("\n How many cake you want to Order : ");
                    int t = sc.nextInt();
                    sc.nextLine();
                    order(t, t, total_Cost);
                    break;
                case 4:
                    exit(1);
                default:
                    System.out.println("\n ------------ Please Enter Valid value ! --------------");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        CakeShop c1 = new CakeShop();
        c1.run();
    }
}