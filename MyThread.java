package Tours;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Disha
 */
public class MyThread extends Thread
{
    String bDate, na, pa, pl;
    int r1;
    MyThread()
    {
        super("");
        start();
    }

    public MyThread(String bDate, String na, String pa, String pl, int r1, String n) {
        super(n);
        this.bDate = bDate;
        this.na = na;
        this.pa = pa;
        this.pl = pl;
        this.r1 = r1;
        start();
    }

    @Override
    public void run()
    {
        FileWriter fi=null;
        try {
            if(getName().equals("Domestic"))
                fi = new FileWriter("C:\\Users\\Mahe\\Desktop\\HIMYM\\DomesticBill.txt",true);
            else if(getName().equals("International"))
                fi = new FileWriter("C:\\Users\\Mahe\\Desktop\\HIMYM\\InternationalBill.txt",true);
            String line=System.lineSeparator();
            fi.write(line+"Date: "+bDate+line);
            fi.write("Bill No. : "+r1+line);
            fi.write("Name : "+na+line);
            fi.write("Selected Package :  "+pa+line);
            fi.write("Included Places : "+pl+line);
        } catch (IOException ex) {
            
        } finally {
            try {
                fi.flush();
                fi.close();
            } catch (IOException ex) {
                
            }
        }
    }
}
