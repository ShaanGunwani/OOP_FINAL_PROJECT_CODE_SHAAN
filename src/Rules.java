import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener { //Implemented ActionListener because I need a click event also
    String name; //Store globally
    JButton start, back;//Define back and start buttons globally
    Rules(String name){ //Constructor (Parameterised constructor which has name)
        //Make frame for rules
        this.name = name;
        getContentPane().setBackground(Color.WHITE);//To change the color of the frame
        setLayout(null);//Make my own layout

        JLabel heading = new JLabel("Welcome to Simple Minds "+ name + "!!!");//To add heading
        heading.setBounds(50, 20, 700, 30);//To set the heading in the frame use setBounds function
        //For the setBounds function above, it takes 4 arguments for its position. The first argument is from the left which is 50, second is from the right which is 20, third and fourth is its width and height which is 700 and 30 respectively
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));//To change font size use setFont function and then made object of font class. In it, it takes 3 arguments first is font family, second is font type and third is font size
        heading.setForeground(new Color(30, 144, 254));//Use setForeground function to change the font color of the heading
        //I made an object of the color class to pass the color for the heading in rgb
        add(heading);//Use add function to add components to the frame

        JLabel rules = new JLabel();//I will insert the values dynamically, so I am not putting anything in the object
        rules.setBounds(20, 90, 700, 350);//To set the rules  in the frame use setBounds function
        //For the setBounds function above, it takes 4 arguments for its position. The first argument is from the left which is 50, second is from the right which is 20, third and fourth is its width and height which is 700 and 30 respectively
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));//To change font size use setFont function and then made object of font class. In it, it takes 3 arguments first is font family, second is font type and third is font size
        //I did not change the Foreground color as it is ok in black color.
        rules.setText( //Mentioned all the rules here in HTML format
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" + //br stands for break row. It breaks the row and takes it to the next line.
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "<html>"
        );
        add(rules);//Use add function to add components to the frame

        //Add buttons
        back = new JButton("Back"); //Back button, when clicked will go to the previous frame
        back.setBounds(250, 450, 100, 30); //For the position of the buttons, I used the setBounds function.
        //From the left its 250, from the top its 500, and the width and height are 100 and 30 respectively
        back.setBackground(new Color(30, 144, 254));//To change the background color of the back button, made an object of the color class and input the color in rgb
        back.setForeground(Color.WHITE);//To change the "back" text color into white
        back.addActionListener(this);//To put click event in back button, used addActionListener function. This function tells that in this button some action is done/ something is clicked
        add(back);

        start = new JButton("Start"); //Start button used when user want to start the quiz
        start.setBounds(400, 450, 100, 30); //For the position of the buttons, I used the setBounds function.
        //From the left its 400, from the top its 450, and the width and height are 100 and 30 respectively
        start.setBackground(new Color(30, 144, 254));//To change the background color of the start button, made an object of the color class and input the color in rgb
        start.setForeground(Color.WHITE);//To change the "start" text color into white
        start.addActionListener(this);//To put click event in start button, used addActionListener function. This function tells that in this button some action is done/ something is clicked
        add(start);


        setSize(800, 550); //Size of the frame
        setLocation(250, 80); //Location/Position of the frame
        setVisible(true); //To make the frame appear and be visible

    }

    //Method Overriding
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == start){ //To check that which method is being called, used ActionEvent class' object
              new Quiz(name); //Make an object of the quiz class and pass user's name in it
        }else { //For back button
            setVisible(false); //Close the current frame
            new Login(); //Make object of Login class, so it will go back to the Login frame
        }
    }
    public static void main(String[] args) { //main method
        new Rules("User"); //Object of rules class. If user does not enter anything in the name, then it will by default be user
    }
}
