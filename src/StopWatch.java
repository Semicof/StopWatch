import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class StopWatch implements ActionListener {
    JFrame frame=new JFrame();
    JButton startButton=new JButton("Start");
    JButton resetButton=new JButton("Reset");
    JLabel label=new JLabel();
    int eTime=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean isStarted=false;
    String sec_string=String.format("%02d",seconds);
    String min_string=String.format("%02d",minutes);
    String h_string=String.format("%02d",hours);

    Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eTime+=1000;
            hours=(eTime/3600000);
            minutes=(eTime/60000)%60;
            seconds=(eTime/1000)%60;
            sec_string=String.format("%02d",seconds);
            min_string=String.format("%02d",minutes);
            h_string=String.format("%02d",hours);
            label.setText(h_string+":"+min_string+":"+sec_string);
        }
    });
    StopWatch()
    {
        label.setText(h_string+":"+min_string+":"+sec_string);
        label.setBounds(100,100,200,100);
        label.setFont(new Font("Arial",Font.PLAIN,40));
        label.setBorder(BorderFactory.createBevelBorder(1));
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Arial",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.setBorderPainted(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Arial",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.setBorderPainted(false);
        resetButton.addActionListener(this);

        frame.add(label);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton)
        {
            if(isStarted==false)
            {
                isStarted=true;
                startButton.setText("Stop");
                start();
            }
            else {
                isStarted=false;
                startButton.setText("Start");
                stop();
            }
        }
        if(e.getSource()==resetButton)
        {
            reset();
            isStarted=false;
            startButton.setText("Start");
        }
    }

    void start()
    {
        timer.start();
    }
    void stop(){
        timer.stop();
    }
    void reset()
    {
        stop();
        eTime=0;
        hours=0;
        minutes=0;
        seconds=0;
        sec_string=String.format("%02d",seconds);
        min_string=String.format("%02d",minutes);
        h_string=String.format("%02d",hours);
        label.setText(h_string+":"+min_string+":"+sec_string);
    }
}
