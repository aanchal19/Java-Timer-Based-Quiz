/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Aanchhal
 */
public class t1  implements ActionListener,Runnable
{
    JFrame f;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l19;
    JRadioButton rb[] = new JRadioButton[6];
    JButton b1,b2;
    JButton b[] = new JButton[10];
    ButtonGroup bg;
    int count = 0;
    int flag[]=new int[10];
    String sqd;
    int time;
   Thread t;
    
    t1(String s)
    {
        sqd=s;
        f = new JFrame("Operating Systems Quiz");
        f.setSize(1536,1536);
        f.setLayout(null);
      
        p1 = new JPanel();
        p1.setBounds(0,0,1536,150);
        p1.setBackground(Color.GRAY);
        p1.setLayout(null);
        f.add(p1);
         
        for(int i=0;i<=9;i++)
            {flag[i]=0;}
        
        l1 = new JLabel("WELCOME TO ONLINE ASSESSMENT");
        l1.setBounds(200,50,1000,100);
        l1.setFont(l1.getFont().deriveFont(50.0f));
        p1.add(l1);
        
       
        
        p2 = new JPanel();
        p2.setBounds(0,150,1536,1386);
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setLayout(null);
       f.add(p2);
        
        l2 = new JLabel();
        l2.setBounds(280,40,500,80);
        l2.setFont(l2.getFont().deriveFont(15.0f));
        p2.add(l2);
        
        
   
        
        for(int i=0;i<10;i++)
        {
            b[i] = new JButton();
            p2.add(b[i]);
            b[i].setBackground(Color.LIGHT_GRAY);
            b[i].addActionListener(this);
        }
        b[0].setBounds(0,0,70,30);
        b[1].setBounds(0,30,70,30);
        b[2].setBounds(0,60,70,30);
        b[3].setBounds(0,90,70,30);
        b[4].setBounds(0,120,70,30);
        b[5].setBounds(0,150,70,30);
        b[6].setBounds(0,180,70,30);
        b[7].setBounds(0,210,70,30);
        b[8].setBounds(0,240,70,30);
        b[9].setBounds(0,270,70,30);
        
        b[0].setText("1");
        b[1].setText("2");
        b[2].setText("3");
        b[3].setText("4");
        b[4].setText("5");
        b[5].setText("6");
        b[6].setText("7");
        b[7].setText("8");
        b[8].setText("9");
        b[9].setText("10");
         
      
       
        l3 = new JLabel("ONLINE ASSESMENT SYSTEM : COPYRIGHT BY KANIKA & AANCHAL");
        l3.setOpaque(true);
        l3.setBackground(Color.BLACK);
        l3.setForeground(Color.white);
        l3.setBounds(0,520,1500,20);
        p2.add(l3);
       
        l4 = new JLabel("Rules of Quiz");
        l4.setBounds(300,30,300,50);
        l4.setFont(l4.getFont().deriveFont(25.0f));
        p2.add(l4);
        
        l5 = new JLabel("1. There are 10 questions in all.");
        l5.setBounds(310,70,300,50);
        p2.add(l5);
         l6 = new JLabel("2. All questions are of 1 mark each.");
        l6.setBounds(310,100,300,50);
        p2.add(l6);
         l7 = new JLabel("3. There is no negative marking.");
        l7.setBounds(310,130,300,50);
        p2.add(l7);
         l8 = new JLabel("4. Use of calculators is not permitted.");
        l8.setBounds(310,160,300,50);
        p2.add(l8);
         l13 = new JLabel("5. One question can be attempted only once.");
        l13.setBounds(310,190,300,50);
        p2.add(l13);
        l9 = new JLabel("6. You can view your score anytime you want by clicking on view score button on the bottom right of screen.");
        l9.setBounds(310,220,700,50);
        p2.add(l9);
        l10 = new JLabel("7. Once you have finished your quiz, click on Submit button.");
        l10.setBounds(310,250,350,50);
        p2.add(l10); 
        l19=new JLabel("8. Quiz time is inclusive of rules.");
        l19.setBounds(310,280,350,50);
        p2.add(l19); 
         l11 = new JLabel("Max Marks:10");
        l11.setBounds(1000,0,300,30);
        p2.add(l11);
         
        l12 = new JLabel("Time limit:10 min");
        l12.setBounds(100,0,300,30);
        p2.add(l12);
        String y=Integer.toString(time);
        l14=new JLabel(y);
        l14.setBounds(1200,0,300,30);
  p2.add(l14);
        
         b1 = new JButton("Submit");
         b1.setBounds(1200,450,100,30);
        p2.add(b1);
        b1.setVisible(false);
            
        b2 = new JButton("View Score");
        b2.setBounds(1040,450,115,30);
        p2.add(b2);
        b2.setVisible(false);       
        
         bg = new ButtonGroup();
       
        for(int i=0;i<5;i++)
        {
            rb[i] = new JRadioButton("");
            bg.add(rb[i]);
            p2.add(rb[i]);
            rb[i].setVisible(false);
        }
          // rb[4].setVisible(false);
 
         rb[0].setBounds(300,150,500,35);
        rb[1].setBounds(300,210,500,35);
        rb[2].setBounds(300,270,500,35);
        rb[3].setBounds(300,330,500,35);
        rb[4].setBounds(300,400,500,35);
           
       b2.addActionListener(this);
       b1.addActionListener(this);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
        
    }
    public void check()
    {
        if(flag[0]==1)
                {
                    if(rb[2].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[0].setEnabled(false);
                        flag[0]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[3].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[0].setEnabled(false);
                        flag[0]=0;
                
                    }
                    else
                         flag[0]=0;
                }
                if(flag[1]==1)
                {
                    if(rb[1].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[1].setEnabled(false);
                        flag[1]=0;
                    }
                     else if(rb[0].isSelected()||rb[3].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[1].setEnabled(false);
                        flag[1]=0;
                
                    }
                    else
                         flag[1]=0;
                }
                if(flag[2]==1)
                {
                    if(rb[1].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[2].setEnabled(false);
                        flag[2]=0;
                    }
                     else if(rb[0].isSelected()||rb[3].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[2].setEnabled(false);
                        flag[2]=0;
                
                    }
                    else
                         flag[2]=0;
                }
                if(flag[3]==1)
                {
                    if(rb[3].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[3].setEnabled(false);
                        flag[3]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[3].setEnabled(false);
                        flag[3]=0;
                
                    }
                    else
                         flag[3]=0;
                }
                if(flag[4]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[4].setEnabled(false);
                        flag[4]=0;
                    }
                     else if(rb[1].isSelected()||rb[2].isSelected()||rb[3].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[4].setEnabled(false);
                        flag[4]=0;
                
                    }
                    else
                         flag[4]=0;
                }
                if(flag[5]==1)
                {
                    if(rb[1].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[5].setEnabled(false);
                        flag[5]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[5].setEnabled(false);
                        flag[5]=0;
                
                    }
                    else
                         flag[5]=0;
                }
                if(flag[6]==1)
                {
                    if(rb[1].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[6].setEnabled(false);
                        flag[6]=0;
                    }
                     else if(rb[0].isSelected()||rb[3].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[6].setEnabled(false);
                        flag[6]=0;
                
                    }
                    else
                         flag[6]=0;
                }
                if(flag[7]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[7].setEnabled(false);
                        flag[7]=0;
                    }
                     else if(rb[2].isSelected()||rb[1].isSelected()||rb[3].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[7].setEnabled(false);
                        flag[7]=0;
                
                    }
                    else
                         flag[7]=0;
                }
                if(flag[8]==1)
                {
                    if(rb[2].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[8].setEnabled(false);
                        flag[8]=0;
                    }
                     else if(rb[0].isSelected()||rb[3].isSelected()||rb[1].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[8].setEnabled(false);
                        flag[8]=0;
                
                    }
                    else
                         flag[8]=0;
                }
                if(flag[9]==1)
                {
                    if(rb[2].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[9].setEnabled(false);
                        flag[9]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[0].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[9].setEnabled(false);
                        flag[9]=0;
                
                    }
                    else
                         flag[9]=0;
                }
    }
     public void actionPerformed(ActionEvent e)
        {
           
             
            //t.start();
          l1.setBounds(300,60,800,60);
         // l1.setText("Operating Systems Quiz");
          
           b1.setVisible(true);
           b2.setVisible(true);
           
          l4.setVisible(false);
          l5.setVisible(false);
          l6.setVisible(false);
          l7.setVisible(false);
          l8.setVisible(false);
          l9.setVisible(false);
          l10.setVisible(false);
          l13.setVisible(false);
          l19.setVisible(false);
         
           // rb[4].setSelected(true);
          for(int i=0;i<4;i++)
          {
              rb[i].setVisible(true);
          }
          
          
            if(e.getSource()==b[0])
            {
                check();
                
                l2.setText("<html>Que1:The primary distinction between the short term and long term scheduler is:</html>");
                rb[0].setText("The length of their queues");
                rb[1].setText("The type of processes they schedule");
                rb[2].setText("The frequency of their execution");
                rb[3].setText("All of the above");
                    rb[4].setSelected(true);
                bg.getSelection();
                flag[0]=1;
       
            
            }
                
            if(e.getSource()==b[1])
            {
                 check();
              rb[4].setSelected(true);
                l2.setText("<html>Que2:In the following cases non-preemptive scheduling occurs:</html>");
                rb[0].setText("When a process switches from running state to ready state");
                rb[1].setText("When a process switches from running state to waiting state");
                rb[2].setText("When a process switches from waiting state to ready state");
                rb[3].setText("All of the mentioned");
               flag[1]=1;
                bg.getSelection();
                
               
            }
             if(e.getSource()==b[2])
            {
                check();
                rb[4].setSelected(true);
                l2.setText("<html>Que3:The FCFS algorithm is particularly troublesome for _______________</html>");
                rb[0].setText("time sharing systems");
                rb[1].setText("multiprogramming systems");
                rb[2].setText("multiprocessor systems");
                rb[3].setText("operating systems");
                flag[2]=1;
                
            }
             if(e.getSource()==b[3])
             {
                   check();
                 l2.setText("<html>Que4:Spinlocks are: </html>");
                rb[0].setText("CPU cycles wasting locks over critical sections of programs");
                rb[1].setText("Locks that avoid time wastage in context switches");
                rb[2].setText("Locks that work better on multiprocessor systems");
                rb[3].setText("All of the above");
                rb[4].setSelected(true);
                 flag[3]=1;
             }
            
            if(e.getSource()==b[4])
             {
                
                      check();
                rb[4].setSelected(true); 
                l2.setText("Que5:The operations that can be invoked on a condition variable are:");
                rb[0].setText("wait & signal");
                rb[1].setText("hold & wait");
                rb[2].setText("signal & hold");
                rb[3].setText("All of the above");
                 flag[4]=1;
             }
             
            if(e.getSource()==b[5])
             { check();
             rb[4].setSelected(true);
                 l2.setText("Que6:A safe state is one in which: ");
                rb[0].setText("the system does not crash due to deadlock occurence");
                rb[1].setText("<html>the system can allocate resources to each process in such order and still avoid a deadlock</html>");
                rb[2].setText("the state keeps the system safe and protected");
                rb[3].setText("All of the above");
                 flag[5]=1;
             }
             
             if(e.getSource()==b[6])
             {
                 check();
                rb[4].setSelected(true);
                l2.setText("<html>Que7:If we preempt a resource from a process, the process cannot continue with its normal execution and it must be</html> ");
                rb[0].setText("aborted");
                rb[1].setText("rolled back");
                rb[2].setText("terminated");
                rb[3].setText("queued");
                 flag[6]=1;
             }
             if(e.getSource()==b[7])
             { check();
             rb[4].setSelected(true);
                 l2.setText("Que8:The ______ swaps processes in and out of the memory.");
                rb[0].setText("Memory manager");
                rb[1].setText("CPU");
                rb[2].setText("CPU manager");
                rb[3].setText("User");
                 flag[7]=1;
             }
             if(e.getSource()==b[8])
             {
                check();
                rb[4].setSelected(true);
                 l2.setText("<html>Que9:When the entries in the segment tables of 2 different processes point to same physical location:</html>");
                rb[0].setText("the segments are valid");
                rb[1].setText("the processes get blocked");
                rb[2].setText("segments are shared");
                rb[3].setText("All of the mentioned");
                 flag[8]=1;
             }
             if(e.getSource()==b[9])
             {
                  check();
                rb[4].setSelected(true);
                 l2.setText("Que10:Illegal addresses are trapped using the _____ bit");
                rb[0].setText("error");
                rb[1].setText("protection");
                rb[2].setText("valid-invalid");
                rb[3].setText("access");
                 flag[9]=1;
             }
             if(e.getSource()==b2)
             {
                 check();
                 JOptionPane.showMessageDialog(null,"Your total score till now is "+count);
                 
             }
             if(e.getSource()==b1)
             {  
                // System.out.println(sqd);
                 //System.out.println(count);
                 check();
                 JOptionPane.showMessageDialog(null,"Total score: "+count);
                 for(int i=0;i<10;i++)
                 {
                     b[i].setEnabled(false);
                 }
                 if(count==0)
                     count=-1;
                  try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="update MarksJava set Quiz="+count+" where id='"+sqd+"' ";
                        
			int i=st.executeUpdate(query);
                           if(i>0) { System.out.println("inserted"); } else{ System.out.println("Unsuccessful"); }
		}
		
		catch(Exception f)
		{
			System.out.println("Exception has occured"+f);
		}
                 
             }
             
        }
     public void run()
	{   int i;
            int h =0;
		for(i=0;i<=60;i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
			System.out.print(e);
			}
                       
                       int m=10;
                       int s=59;
                              
                       if((i%60==0)&&(i!=0))
                       {JOptionPane.showMessageDialog(null,"1 min is over");
                       h=h+1;
                       i=0;}
                       
                       String z1=Integer.toString(i);
                       String z2=Integer.toString(h);
                        String time="00:"+"0"+z2+":"+z1;
                        
                        l14.setText(time);
		

		}
		System.out.println("hi");
                i=0;
		
	}
    
}
