import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    Score(String name, int score){ //Constructor and pass name and score in it
        setBounds(300, 50, 750, 550); //Combination of setSize and setLocation functions. If any component is not calling the setBounds function, then by default, JFrame calls the setBounds function
        //The setBounds function calls four arguments, the first two arguments is the location of the frame. From the left its 300 and from the top its 150.
        //The last two arguments of the setBounds function is the size of the frame which is 750 and 550 for the width and height respectively.
        getContentPane().setBackground(Color.WHITE);//Make the frame color to white
        setLayout(null); //My own layout

        //Put score image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score.png"));//To take image from file directory
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);//To scale the image, call getImage function from i1 and pass the width and height in the getScaledInstance
        ImageIcon i3 = new ImageIcon(i2);//Convert in ImageIcon by making an object of it and passed i2 which is the object of Image class
        JLabel image = new JLabel(i3); //Object of JLabel class which I called as image
        image.setBounds(0, 200, 300, 250);//To put image because I did not use swing layouts, so I had to put the image by myself. Used setBounds function to make my own layout
        //In the setBounds function above, the position from the left I made is 0 and from the top is 200, and 600 and 500 is the image's width and height
        add(image);//Use add function and pass the object which is i1 to put image (component) on top of the frame

        //Heading
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30); //The position from the left I made is 45 and from the right is also 30, and 700 and 30 is the label's width and height
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));//To change the font size of the question number by making an object of the font class
        //The first argument the above object takes is the font family, second is the font type, and the third is the font size
        add(heading);

        //Made it lblscore because the name score was already defined
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(330, 200, 300, 30); //The position from the left I made is 350 and from the right is also 200, and 300 and 30 is the label's width and height
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));//To change the font size of the question number by making an object of the font class
        //The first argument the above object takes is the font family, second is the font type, and the third is the font size
        add(lblscore);

        JButton submit = new JButton("Play Again");//Made the Submit button
        submit.setBounds(360, 270, 120, 30);//The position from the left is 360, from the top is 270, and the width and height respectively are 120 and 30
        submit.setBackground(new Color(30, 144, 255)); //Change the background color of the button, used setBackground function
        //Stored the color value in RGB so made an object of the color class
        submit.setForeground(Color.WHITE); //Change the foreground color, made an object of the color class
        //Directly called the color white
        submit.addActionListener(this);
        add(submit);

        setVisible(true);//To make it be visible
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);//After clicking the Play Again button
        new Login(); //Open the login class again
    }
    public static void main(String[] args) {
        new Score("User", 0); //Passed the name of the user and the score
    }
}
