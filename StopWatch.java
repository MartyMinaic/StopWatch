import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class StopWatch
{
    static JButton bn = new JButton("Start");
    JFrame fm = new JFrame("Stop Watch");
    JLabel lh = new JLabel("HH");
    JLabel lm = new JLabel("MM");
    JLabel ls = new JLabel("SS");
    JLabel lms = new JLabel("MS");
    JLabel cl1 = new JLabel(":");
    JLabel cl2 = new JLabel(":");
    JLabel cl3 = new JLabel(":");
    static JTextField th = new JTextField();
    static JTextField tm = new JTextField();
    static JTextField ts = new JTextField();
    static JTextField tms = new JTextField();
    JPanel fk = new JPanel();
    time ob = new time();
    int k=0;
    StopWatch()
    { 
        ts.setText("");
        tm.setText("");
        th.setText("");
        fm.add(lh);
        fm.add(lm);
        fm.add(ls);
        fm.add(lms);
        fm.add(th);
        fm.add(tm);
        fm.add(ts);
        fm.add(tms);
        fm.add(bn);
        fm.add(cl1);
        fm.add(cl2);
        fm.add(cl3);
        fm.add(fk);
        lh.setVisible(true);
        lm.setVisible(true);
        ls.setVisible(true);
        th.setVisible(true);
        tm.setVisible(true);
        ts.setVisible(true);
        bn.setVisible(true);
        fm.setVisible(true);
        cl1.setVisible(true);
        cl2.setVisible(true);
        cl3.setVisible(true);
        lh.setBounds(40,25,50,25);
        lm.setBounds(115,25,50,25);
        ls.setBounds(190,25,50,25);
        lms.setBounds(265,25,50,25);
        th.setBounds(25,50,50,20);
        tm.setBounds(100,50,50,20);
        ts.setBounds(175,50,50,20);
        tms.setBounds(250,50,50,20);
        cl1.setBounds(85,50,50,20);
        cl2.setBounds(160,50,50,20);
        cl3.setBounds(235,50,50,20);
        bn.setBounds(120,100,100,50);
        th.setEditable(false);
        tm.setEditable(false);
        ts.setEditable(false);
        tms.setEditable(false);
        fk.setBackground(Color.BLACK);
        bn.setBackground(Color.DARK_GRAY);
        bn.setForeground(Color.WHITE);
        lh.setForeground(Color.WHITE);
        lm.setForeground(Color.WHITE);
        ls.setForeground(Color.WHITE);
        lms.setForeground(Color.WHITE);
        th.setBackground(Color.BLACK);
        tm.setBackground(Color.BLACK);
        ts.setBackground(Color.BLACK);
        tms.setBackground(Color.BLACK);
        th.setForeground(Color.WHITE);
        tm.setForeground(Color.WHITE);
        ts.setForeground(Color.WHITE);
        tms.setForeground(Color.WHITE);
        cl1.setForeground(Color.WHITE);
        cl2.setForeground(Color.WHITE);
        cl3.setForeground(Color.WHITE);        
        tms.setText("00");
        ts.setText("00");
        tm.setText("00");
        th.setText("00");
        fm.setSize(350,200);
    }
    public static void main(String args[])
    {
        StopWatch ob = new StopWatch();
        ob.eventHandel();
    }
    void eventHandel()
    {
        bn.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            switch(k)
            {
                case 0:
                start();
                break;
                case 1:
                stop();
                break;
                case 2:
                reset();
                break;                
            }
          }
    });
    }
    void start()
    {
        //System.out.println("Start");
        k=1;
        //code
        ob.start();
        bn.setText("Stop");
    }
    void stop()
    {
        //System.out.println("Stop");
        k=2;
        //code
        ob.stop();
        StopWatch.bn.setBackground(Color.GRAY);
        StopWatch.bn.setForeground(Color.WHITE);
        bn.setText("Exit");
    }
    void reset()
    {
        //System.out.println("Reset");
        k=0;
        //code
        bn.setText("Start");
        System.exit(0);
    }
}
class time extends Thread
{
    int i=0,j=0,k=0,l=0;
    public void run() 
    { 
        try
        { 
            while(true)
            {
                update();
                sleep(10);
                i++;
                if(i==100)
                {
                    i=0;
                    j++;
                }
                if(j==60)
                {
                    j=0;
                    k++;
                }
                if(k==60)
                {
                    k=0;
                    l++;
                }
                if(j%2==0)
                {
                    StopWatch.bn.setBackground(Color.RED);
                    StopWatch.bn.setForeground(Color.WHITE);
                }
                else
                {
                    StopWatch.bn.setBackground(Color.YELLOW);
                    StopWatch.bn.setForeground(Color.BLACK);
                }
            }
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
    void update()
    {
        StopWatch.tms.setText(i+"");
        StopWatch.ts.setText(j+"");
        StopWatch.tm.setText(k+"");
        StopWatch.th.setText(l+"");
        if(j<10)
        {
            StopWatch.ts.setText("0"+StopWatch.ts.getText());
        }
        if(k<10)
        {
            StopWatch.tm.setText("0"+StopWatch.tm.getText());
        }
        if(l<10)
        {
            StopWatch.th.setText("0"+StopWatch.th.getText());
        }
    }
}
