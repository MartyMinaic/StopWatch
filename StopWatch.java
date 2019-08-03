import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class StopWatch
{
    JButton bn = new JButton("Start");
    JFrame fm = new JFrame("Stop Watch");
    JLabel lh = new JLabel("HH");
    JLabel lm = new JLabel("MM");
    JLabel ls = new JLabel("SS");
    JLabel cl1 = new JLabel(":");
    JLabel cl2 = new JLabel(":");
    static JTextField th = new JTextField();
    static JTextField tm = new JTextField();
    static JTextField ts = new JTextField();
    JPanel fk = new JPanel();
    JPanel fkl = new JPanel();
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
        fm.add(th);
        fm.add(tm);
        fm.add(ts);
        fm.add(bn);
        fm.add(cl1);
        fm.add(cl2);
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
        lh.setBounds(40,25,50,25);
        lm.setBounds(115,25,50,25);
        ls.setBounds(190,25,50,25);
        th.setBounds(25,50,50,20);
        tm.setBounds(100,50,50,20);
        ts.setBounds(175,50,50,20);
        cl1.setBounds(85,50,50,20);
        cl2.setBounds(160,50,50,20);
        bn.setBounds(120,100,100,50);
        th.setEditable(false);
        tm.setEditable(false);
        ts.setEditable(false);
        fk.setBackground(Color.BLACK);
        bn.setBackground(Color.GRAY);
        bn.setForeground(Color.WHITE);
        lh.setForeground(Color.WHITE);
        lm.setForeground(Color.WHITE);
        ls.setForeground(Color.WHITE);
        th.setBackground(Color.BLACK);
        tm.setBackground(Color.BLACK);
        ts.setBackground(Color.BLACK);
        th.setForeground(Color.WHITE);
        tm.setForeground(Color.WHITE);
        ts.setForeground(Color.WHITE);
        cl1.setForeground(Color.WHITE);
        cl2.setForeground(Color.WHITE);
        fm.setSize(250,200);
    }
    public static void main()
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
    int i=0,j=0,k=0;
    public void run() 
    { 
        try
        { 
            while(true)
            {
                update();
                sleep(1000);
                i++;
                if(i==60)
                {
                    i=0;
                    j++;
                }
                if(j==60)
                {
                    j=0;
                    k++;
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
        StopWatch.ts.setText(i+"");
        StopWatch.tm.setText(j+"");
        StopWatch.th.setText(k+"");
        if(i<10)
        {
            StopWatch.ts.setText("0"+StopWatch.ts.getText());
        }
        if(j<10)
        {
            StopWatch.tm.setText("0"+StopWatch.tm.getText());
        }
        if(k<10)
        {
            StopWatch.th.setText("0"+StopWatch.th.getText());
        }
    }
}
