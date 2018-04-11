package Tours;

import java.io.*;
class UNO extends Thread
{
    static Domestic dom[]=new Domestic[100];
    static International inl[]=new International[100];
    static int domCount,intCount,custCount;
    UNO()
    {
        domCount=intCount=custCount=0;
    }

    public static void main(String[] args) throws IOException
    {
        //UNO uno=new UNO();
        mainMenu();
        reportMenu();
    }

    static void mainMenu() throws IOException
    {   int ch;
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        do
        {  

                System.out.println("\f");


                System.out.println("                                                      *       *    * * * * *   * * * * * ");
                System.out.println("                                                      *       *    *       *   *       * ");
                System.out.println("                                                      *       *    *       *   *       * ");
                System.out.println("                                                      * * * * *    *       *   * * * * * ");

                System.out.println("\n \n                                                          TOURS AND TRAVELS");


            System.out.println("               MOST ATTRACTIVE TOUR PACKAGES AT LOW COSTS!!");
            System.out.println("MENU: \n 1.Domestic \n 2.International \n 3.View booked packages \n 4.Exit \n Please Enter Your Choice.");
            try
            {
                ch=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {   ch=0;
            }

            switch(ch)
            {
                case 1:
                dom[domCount]=new Domestic();
                dom[domCount].Package();
                if(dom[domCount].pa.length()>0)
                    domCount++;
                break;
                case 2: 
                inl[intCount]=new International();
                inl[intCount].Package();
                //if(inl[intCount].pl.length()>0)
                    intCount++;
                break;
                case 3:
                reportMenu();
                break;
                case 4:
                System.out.print("Exiting");
                for(int i=0;i<2;i++)
                {
                    mydelay();
                    System.out.print(".");     
                }
                System.exit(0);
                break;
                default:
                System.out.println("Invalid choice ");
            }
        } while(ch!=6);
    }

    static void reportMenu() throws IOException
    {   int ch;
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("               REPORT MENU          ");
        System.out.println("MENU: \n 1.Domestic \n 2.International \n 3.Back \n Please Enter Your Choice.");
        try
        {
            ch=Integer.parseInt(br.readLine());
        }
        catch(NumberFormatException nfe)
        {   ch=0;
        }

        switch(ch)
        {
            case 1:
            domesticReport();
            break;
            case 2: 
            internationalReport();
            break;
            case 3:
            System.out.print("Going back to main menu ");
            for(int i=0;i<=3;i++)
            {
                mydelay();
                System.out.print("."); 
            }
            break;
            default:
            System.out.println("Invalid choice ");
        }
        System.out.println("press enter to continue");
        String c=br.readLine();

    }
    static void internationalReport()
    {
        if(intCount==0)
            System.out.println("No passengers today");
        else
        {
            int i;
            for(i=0;i<intCount;i++)
            {
                System.out.println(inl[i].na+"\n"+inl[i].pl+"\n"+inl[i].in+"\n"+inl[i].dur+"\n"+inl[i].ra+"\n \n");
            }
        }
    }

    static void domesticReport()
    {
        if(domCount==0)
            System.out.println("Please FIRST 'enter passenger details for domestic");
        else
        {
            int i;
            for(i=0;i<domCount;i++)
            {
                System.out.println(dom[i].na+"\n"+dom[i].pa+"\n"+dom[i].pl+"\n"+dom[i].ra+"\n"+dom[i].dur+"\n \n");
            }
        }
    }

    static void mydelay()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            
        }
    }
}
