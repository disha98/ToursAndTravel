package Tours;


import java.io.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
class Domestic extends passenger implements packages
{
    double ra,tot;
    String pa,pl,dur;
    int ppl;
    //passenger pas =new passenger();
    Domestic()
    {
        pa=pl=dur="";
        ra=0.0;
    }

    @Override
    public void Package()throws IOException
    {
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String pack[]={"1.Rajasthan    ", "2.Kerala       ", "3.Goa          ", "4.Hyderabad    ","5.Gujrat       "};
        String place[]={"\n     Udaipur\n     Jodhpur\n     Jaipur\n     Ranthambore\n     Jaisalmer", "\n     Munar\n     Cochin\n     Poovar", "\n     Panjim\n     Baga Beach\n     Vasco da Gama Church\n     Calangute Beach", "\n     Charminar\n     Golconda Fort\n     Hitech City\n     RamojiFilmCity", "\n     Ahmedabad\n     Rann of Kacchh\n     Salt Desert\n     Gir Forest"};
        String duration[]={"     5 nights,  days", "        5 nights,  days", "         5 nights,  days","5 nights,  days","     5 nights,  days"};
        double rate[]={9500.0, 5000.0, 3456.0,4567.0,56789.0};
        int ch;

        do
        {

            System.out.println("\t \t \f WELCOME \n \t THANK YOU FOR VISITING OUR DOMESTIC SECTION");
            System.out.println("enter package number");
            System.out.println("Menu:");
            System.out.println("PACKAGE                      DURATION                     RATE                ");
            for(int i=0;i<pack.length;i++)
            {
                System.out.println(pack[i]+"            "+place[i]+"         "+duration[i]+"                "+rate[i]);
            }
            System.out.println("6.Back to Main Menu");
            System.out.println("enter choice");
            try
            {
                ch=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {
                ch=0;
            }
            if(ch>=1 && ch<=5)
            {
                pa=pack[ch-1];
                pl=place[ch-1];
                dur=duration[ch-1];
                ra=rate[ch-1];
                input();                
                do
                {
                    System.out.println("Enter Number of travelers (1 to 500 only)");
                    try
                    {
                        ppl=Integer.parseInt(br.readLine());
                    }
                    catch(NumberFormatException nfe)
                    {
                        ppl=0;
                        System.out.println("Please enter numbers only");

                    }    
                    if(ppl>=1&& ppl<=500)
                    {
                        System.out.println("Enter any key to see bill, except 'ENTER' key");
                        String d=br.readLine();
                        if(d.length()==0)
                        {break;}

                        else 
                        {
                            bill(pa,ppl,pl,dur,ra);
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
            else if(ch==6)
            {
                
            }
            else
                System.out.println("Invalid choice ");
        }while(ch!=6);
    }

    @Override
    public void bill(String a,int n, String b, String c, double d)throws IOException
    { 
        
        double tot=d*n;        
        
        Calendar x=Calendar.getInstance();
        String bDate=x.get(Calendar.DATE)+ "/"+(x.get(Calendar.MONTH)+1)+"/"+x.get(Calendar.YEAR);
        System.out.println("                                        Your ticket/s has been booked.");
        System.out.println("                                        Thank you for using our services");
        double r=(Math.random()+1)*10000;
        int r1=(int)r;
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println("                           *****##### UNO Tours and Travels ltd. ######******");
        System.out.println();        
        System.out.println(" Date: "+bDate+"                                                                                     Bill No. "+r1);
        selectedPackage(tot);
        System.out.println(" AGENT NAME  --> Rachel                                  Contact: 3977 3977 / 7766454577");    
        System.out.println("                          THANK YOU FOR USING OUR SERVICES.ENJOY YOUR VACATION!!");
        System.out.println("_______________________________________________________________________________________________________________________________________");
        MyThread t=new MyThread(bDate,super.na,pa.substring(2),pl,r1,"Domestic");
        try {
            t.join();
        } catch (InterruptedException ex) {
            
        }
    }
    
    void selectedPackage(double a)
    {
        System.out.println("Your Selected package is "+pa);
        System.out.println("The package includes the places "+pl);
        System.out.println("The duration "+dur);
        System.out.println("The Rate is "+ra);
        System.out.println("Number of Passenger is "+ppl);
        System.out.println("TOTAL BILL "+a);
    }

    @Override
    void mydelayDot()
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

    void mydelayBill()
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

