package Tours;

import java.io.*;

class passenger
{
    String na, address, mobile,ID;// ID= passport number
    char gender;
    int age;

    void input()throws IOException
    {
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do //name check
        {
            System.out.println("Enter your name");
            na= br.readLine();
            if(na.length()==0)
                System.out.println("Please enter name");
            else
            {
                int i, c=0;
                char x;
                for(i=0;i<na.length();i++)
                {
                    x=na.charAt(i);
                    if(x==' ')
                        c++;
                }
                if(c==na.length())
                {
                        try {
                            throw new NameException();
                    } catch (NameException ex) {
                            System.out.println(ex);
                    }
                }
                else
                    break;
            }
        }while (true); 

        do //age check
        {
            try
            {
                System.out.println("Enter age");
                age=Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("please enter number only");
                age=0;
            }
            if(age>=18&& age<=80)
                break;
            else
            {
                    try {
                        throw new AgeException();
                } catch (AgeException ex) {
                        System.out.println(ex);
                }
            }
        }
        while(true);

        do //gender check
        {            
            System.out.println("Enter your gender(M/F)");
            gender=br.readLine().charAt(0);             
            gender=Character.toUpperCase(gender);
            if(gender=='M'||gender=='F' )
                break;
            else
            { 
                try {
                    throw new GenderException();
                } catch (GenderException ex) {
                    System.out.println(ex);
                }
            }
        }while (true);


        do //phone number check 
        { 
            long tmp=0;
            try
            { System.out.println("Enter your phone no.");
                mobile= br.readLine();
                tmp=Long.parseLong(mobile);
            }
            catch(NumberFormatException nfe)
            {
                mobile="";
            }
            if(mobile.length()==8|| mobile.length()==10)
                break;
            else
            {
                try {
                    throw new PhoneException();
                } catch (PhoneException ex) {
                    System.out.println(ex);
                }
            }
        } while(true);              

        }

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

    }
