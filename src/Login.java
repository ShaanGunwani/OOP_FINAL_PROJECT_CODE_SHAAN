import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener { //Used inheritance by extends and Used interface by implementing ActionListener
    //Used ActionListener interface to put click event in the buttons, such that when the back button will be clicked, the frame should close and when the rules button will be clicked, the next frame should open
    //JFrame class - to make the frame

    JButton rules, back; //Declare globally because I am using it in different function and outside the constructor
    JTextField tfname; //Declare globally
    Login(){ //Constructor
        //Code for showing the frame when running the main method
        getContentPane().setBackground(Color.WHITE); //To change the background color of the frame
        setLayout(null); //To make my own layout and to not use swing layouts
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpeg"));//To take image from file directory
        JLabel image = new JLabel(i1); //Object of JLable class which I called as image
        image.setBounds(0, 0,600,500 );//To put image because I did not use swing layouts, so I had to put the image by myself. Used setBounds function to make my own layout
        //In the setBounds function above, the position from the left I made is 0 and from the right is also 0, and 600 and 500 is the image's width and height
        add(image);//Use add function and pass the object which is i1 to put image (component) on top of the frame

        JLabel heading = new JLabel("Simple Minds");//To add heading "Simple Minds"
        heading.setBounds(750, 60, 300, 45);//To set the heading in the frame use setBounds function
        //For the setBounds function above, it takes 4 arguments for its position. The first argument is from the left which is 750, second is from the right which is 60, third and fourth is its width and height which is 300 and 45 respectively
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40 ));//To change font size use setFont function and then made object of font class. In it, it takes 3 arguments first is font family, second is font type and third is font size
        heading.setForeground(new Color(30, 144, 254));//Use setForeground function to change the font color of the heading
        //I made an object of the color class to pass the color for the heading in rgb
        add(heading);//Use add function to add components to the frame

        JLabel name = new JLabel("Enter your name");//To add "Enter your name"
        name.setBounds(810, 150, 300, 20);//To set the position in the frame use setBounds function
        //For the setBounds function above, it takes 4 arguments for its position. The first argument is from the left which is 810, second is from the right which is 150, third and fourth is its width and height which is 300 and 20 respectively
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18 ));//To change font size use setFont function and then made object of font class. In it, it takes in 3 arguments. First is font family, second is font type and third is font size
        name.setForeground(new Color(30, 144, 254));//Use setForeground function to change the font color
        //I made an object of the color class to pass the color for the heading in rgb
        add(name);//Use add function to add components to the frame

        //To make a box to take/enter values from the user, we can use text field
        tfname = new JTextField(); //Use JTextField class and make object of this class
        tfname.setBounds(735, 200, 300, 25); //To put it in frame use setBounds function
        //From the left 735, from the top 200, and the width and height is 300 and 25 respectively
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));//Font size for user to enter value in the text field. In it, it takes in 3 arguments. First is font family, second is font type and third is font size
        add(tfname); //To add it to the frame

        //To make the buttons, I used the JButtons class
        rules = new JButton("Rules"); //Rules button
        rules.setBounds(735, 270, 120, 25); //For the position of the buttons, I used the setBounds function.
        //From the left its 735, from the top its 120, and the width and height are 120 and 25 respectively
        rules.setBackground(new Color(30, 144, 254));//To change the background color of the rules button, made an object of the color class and input the color in rgb
        rules.setForeground(Color.WHITE);//To change the "rules" text color into white
        rules.addActionListener(this);//To put click event in rule button, use addActionListener function. This function tells that in this button some action is done/ something is clicked
        add(rules);

        back = new JButton("Back"); //Back button
        back.setBounds(915, 270, 120, 25); //For the position of the buttons, I used the setBounds function.
        //From the left its 915, from the top its 120, and the width and height are 120 and 25 respectively
        back.setBackground(new Color(30, 144, 254));//To change the background color of the back button, made an object of the color class and input the color in rgb
        back.setForeground(Color.WHITE);//To change the "back" text color into white
        back.addActionListener(this);//To put click event in back button, use addActionListener function. This function tells that in this button some action is done/ something is clicked
        add(back);


        setSize(1200, 500);
        setLocation(50, 100); //To make the frame be in the center, 50 from the left and 100 from the top.
        setVisible(true); //The frame is by default hidden. So, we can see it by making the setVisible to true

    }

    //To implement interface in a class, override all the unimplemented methods and abstract methods in the interface
    public void actionPerformed(ActionEvent ae) { //Implemented actionPerformed method
        //Code for defining what action should be performed if the user clicks any of the two buttons
        if (ae.getSource() == rules) { //First, differentiate which button is clicked. I differentiated with the help of the ActionEvent class with the help of its object (ae) and with the getSource function. Then, I call the same function of the two buttons internally
            //To check whether the rules button is being clicked
            String name = tfname.getText();//To get the value which the user entered
            //With the help of getText function, can get whatever the user has entered in the text field and stored it in the "name" string
            setVisible(false);//When the user will click the rules button, then the current frame which is the login frame should close
            new Rules(name);//Open the new Rules class frame and pass the "name" in here.
        }
        else if(ae.getSource() == back){
            //If the rules button is not clicked then check whether the back button is clicked
            setVisible(false); //Hide the frame

        }
    }
    public static void main(String[] args) { //main method
        new Login(); //Object of login class

    }
}
