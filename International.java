package Tours;

import java.util.*;
import java.io.*;
class International extends passenger implements packages
{
    int ppl;
    String dur,pl,in;
    double ra,tot;
    String place[]={"1.USA","2.Germany","3.Sri Lanka","4.Bangkok","5.Singapore","6.Mauritius"};
    String inThat[]={"\n   1.Washington D.c.\n   2.Manhattan\n   3.Niagra\n   4.Los Angeles\n   5.Universal Studios","\n   1.Berlin \n   2.Hamburg  \n   3.Munich","\n   1. Colombo\n   2. Kandy \n   3. Galle","\n   1. Phuket \n   2. Pataya  \n   3. Grand Palace","\n   1.Singapore City\n   2. Woodlands","\n   1. Port Lois \n   2. Grand Bay \n   3. Triolet"};
    String duration[]={"6 weeks","            3 weeks","        5 days","            6 days","            3 weeks","                2 weeks"};
    double rate[]={234500.0,234656.0,   2141788.0, 142777.0,152653.0, 1234567.0};
    //passenger pas = new passenger();
    International()
    {
        ppl=0;
    }

    @Override
    public void Package()throws IOException
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int ch,i,j;
        do
        {
            System.out.println("                       WELCOME TO THE INTERNATIONAL SECTION");
            System.out.println("MENU:");
            System.out.println("COUNTRY                             DURATION             RATE");
            for(i=0;i<place.length;i++)
            {
                System.out.println(place[i]+"             "+inThat[i]+"             "+duration[i]+"             "+rate[i]);
            }
            System.out.println("7.Back to Main Menu");
            try
            {
                ch=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {
                ch=0;
            }
            if(ch>=1 && ch<=6)
            {
                pl=place[ch-1];
                in=inThat[ch-1];
                dur=duration[ch-1];
                ra=rate[ch-1];

                input();
                do
                {
                    System.out.println("Enter Number of travelers");
                    try
                    {
                        ppl=Integer.parseInt(br.readLine());
                    }
                    catch(NumberFormatException nfe)
                    {
                        ppl=0;
                        System.out.println("Please enter numbers only");

                    }    
                    if(ppl>=1)
                    {
                        System.out.println("Enter any key to see bill, except 'ENTER' key");
                        String d=br.readLine();
                        if(d.length()==0)
                        {break;}

                        else 
                        {bill(pl,ppl,in,dur,ra);
                            System.out.println("Enter any key to exit, except 'ENTER' key");
                            String c=br.readLine();
                            if(c.length()!=0)
                            {break;}
                        }
                    }  
                     else
                    {System.out.println("Please Enter Proper Number");}
                } while(true);
                break;
            }
            else if(ch==7)
            {

            }
            else
                System.out.println("Invalid choice ");
        }while(ch!=7);
    }
    
    public void bill(String a,int n, String b, String c, double d)throws IOException
    { 
        double tot=d*n;        
        Calendar x=Calendar.getInstance();
        String bDate=x.get(Calendar.DATE)+ "/"+(x.get(Calendar.MONTH)+1)+"/"+x.get(Calendar.YEAR);
        System.out.println("                                          Your ticket/s has been booked");
        System.out.println("                                        Thank you for using our services");
        double r=(Math.random()+1)*10000;
        int r1=(int)r;
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println("                           *****##### UNO Tours and Travels ltd. ######******");
        System.out.println();        
        System.out.println(" Bill Date: "+bDate+"                                                                                     Bill No. "+r1);
        System.out.println(" AGENT NAME  --> Rachel          \n Contact: 3977 3977 / 7766454577");    
        selectedPackage(tot);
        System.out.println("                          THANK YOU FOR USING OUR SERVICES.ENJOY YOUR VACATION!!");
        System.out.println("_______________________________________________________________________________________________________________________________________");
        MyThread t=new MyThread(bDate,super.na,pl.substring(2),in,r1,"International");
        try {
            t.join();
        } catch (InterruptedException ex) {
            
        }
    }
    void selectedPackage(double a)
    {
        System.out.println("Your Selected package is "+pl);
        System.out.println("The package includes the places "+in);
        System.out.println("The duration "+dur);
        System.out.println("The Rate is "+ra);
        System.out.println("Number of Passenger is "+ppl);
        System.out.println("TOTAL BILL "+a);
    }

    void mydelay()
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Blocked");
            }
        }

    
}
