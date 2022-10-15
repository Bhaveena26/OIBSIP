import java.util.*;
import java.io.*;
class Atm{
    String name,userName,password,accountNo;
    float balance = 20000f;
    int transactions = 0;
    String transactionHistory = "";
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name:- ");
        this.name = sc.nextLine();
        System.out.println("Enter your Username:- ");
        this.userName = sc.next();
        System.out.println("Enter your Password:- ");
        this.password = sc.next();
        System.out.println("Enter your Account Number:- ");
        this.accountNo = sc.nextLine();
        System.out.println("Your Registration is completed... Now login");
   }
    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
            System.out.println("Enter your Username:- ");
            String Username = sc.nextLine();
            if(Username.equals(userName)){
                while(!isLogin){
                    System.out.println("Enter your Password:- ");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("Login Successful!!!");
                        isLogin = true;
                    }
                    else{
                        System.out.println("Incorrect Password.");
                    }
                }
            }    
            else{
                System.out.println("Username not Found.");
            }
        }
        return isLogin;
   }
   public void withDraw(){
        System.out.println("Enter your amount to withdraw:- ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("Withdraw of Amount is Successful!!!");
                String s = "Withdrawed amount is : "+amount;
                transactionHistory = transactionHistory.concat(s);
            }
            else{
                System.out.println("Insufficient Balance in your account...");
            }
        }
        catch(Exception e){
        }
   }
   public void deposit(){
    System.out.println("Enter amount to deposit:- ");
    Scanner sc = new Scanner(System.in);
    float amount = sc.nextFloat();
    try{
        if(amount <= 25000f){
            transactions++;
            balance += amount;
            System.out.println("Amount Successfully deposited!!!");
            String s = "Deposited amount is : "+amount;
            transactionHistory = transactionHistory.concat(s);
        }
        else{
            System.out.println("Amount Limit is exceeded. Limit is Rs.50000.00 only...");
        }
    }
    catch(Exception e){
    }
   }
   public void transfer(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Receipent's Name:- ");
    String receipent = sc.nextLine();
    System.out.println("Enter amount to transfer:- ");
    float amount = sc.nextFloat();
    try{
        if(balance >= amount){
            if(amount <= 25000f){
                transactions++;
                balance -= amount;
                System.out.println("Amount:- Rs."+amount +" is tranferred successfully to "+receipent+" !!!");
                String s = "Amount:- Rs."+amount +" is to "+receipent+" !!!";
                transactionHistory = transactionHistory.concat(s);
            }
            else{
                System.out.println("Amount Limit is exceeded. Limit is Rs.25000.00 only...");
            }
        }
        else{
            System.out.println("Insufficient Balance in your account...");
        }
    }
    catch(Exception e){
    }
   }
   public void checkBalance(){
    System.out.println("Your account balance is:- "+balance);
   }
   public void transactionHistory(){
    if(transactions == 0){
        System.out.println("No transactions done!!!");
    }
    else{
        System.out.println("Your transaction history is:- \n"+transactionHistory);
    }
   }
}
public class AtmInterface{
    public static int takeInput(int limit){
        int inp = 0;
        boolean flag = false;
        while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                inp = sc.nextInt();
                flag = true;
                if(flag && inp > limit || inp < 0){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Enter the integer value only...");
                flag = false;
            }
        }
        return inp;
    }
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("\n\n*-*-*-*-*-*-*-*-* WELCOME TO ATM SYSTEM *-*-*-*-*-*-*-*-*");
    System.out.println("1.Register\n2.Exit");
    System.out.println("Enter your choice:- ");
    int choice = takeInput(2);
    if(choice == 1){
        Atm obj = new Atm();
        obj.register();
        while(true){
            System.out.println("1.Login\n2.Exit");
            System.out.println("Enter your choice:- ");
            int c = takeInput(2);
            if(c == 1){
                if(obj.login()){
                    System.out.println("\n\n*-*-*-*-*-*-*-*-* WELCOME BACK "+obj.name +" *-*-*-*-*-*-*-*-*");
                    boolean isFinish = false;
                    while(!isFinish){
                        System.out.println("\n1.Withdraw\n2.Transfer\n3.Deposit\n4.Check Balance\n5.Transaction History\n6.Exit");
                        System.out.println("Enter your choice:- ");
                        int ch = takeInput(61);
                        switch(ch){
                            case 1:{
                                obj.withDraw();
                                break;
                            }
                            case 2:{
                                obj.transfer();
                                break;
                            }
                            case 3:{
                                obj.deposit();
                                break;
                            }
                            case 4:{
                                obj.checkBalance();
                                break;
                            }
                            case 5:{
                                obj.transactionHistory();
                                break;
                            }
                            case 6:{
                                System.out.println("Thankyou "+obj.name +" Have a nice day!!!!");
                                System.exit(0);
                                break;
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("Thankyou "+obj.name +" Have a great time!!!!");
                System.exit(0);
            }
        }
    }
    else{
        System.out.println("Thankyou Visit us again!!!!");
        System.exit(0);
    }
}
}
