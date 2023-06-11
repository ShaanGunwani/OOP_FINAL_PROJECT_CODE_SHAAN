import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener { //Extends JFrame because JFrame calls the setBounds function
    //In this class the quiz should start after the user clicks the start button in the Rules frame
    //In this quiz class, all the questions will be displayed and the user can answer those questions


    //2D Array for questions. Because we will have questions and the answers of the questions. So, to store them, I am making 2D Array
    String questions[][] = new String[10][5]; //String type 2D Array
    //Total 10 questions are there. So, inputted 10 in the first square brackets for rows
    //Second square brackets is for the columns. I have 5 columns: One for the question and 4 more for the options

    //2D Array for storing the answers. (Need the correct answers)
    //Storing in 2D Array because, storing the answers of all the questions here
    String answers[][] = new String[10][2];
    //For the rows, stored 10 because there are 10 questions and for the columns storing
    //For the columns, could put 1 also instead, but I put 2

    String useranswers[][] = new String[10][1];//If user selected any option, then track the option which user selected. Made an array
    //10 for 10 questions and 1 for 1 option which user selected


    //Globally declare all labels because no scope in the outside start function
    JLabel qno, question;

    JRadioButton opt1, opt2, opt3, opt4; //All the radio buttons, to insert the values dynamically, declare all of them globally

    ButtonGroup groupoptions;//Declared globally
    JButton next, submit, lifeline;//Define globally
    public static int timer = 15; //Timer in seconds

    //After the time's up text is shown, I have to show directly the next question. For that, have to maintain a flag
    public static int ans_given = 0; //Flag name is ans_given and initial value is 0
    public static int count = 0; //Made a variable count and made initial value 0
    public static int score = 0;

    String name;//Declare username globally
    Quiz(String name) { //Constructor. After making the object of the class, the constructor of the class is being called
        this.name = name;//Store globally
        //Make the frame
        setBounds(30, 0, 1250, 700); //Combination of setSize and setLocation functions. If any component is not calling the setBounds function, then by default, JFrame calls the setBounds function
        //The setBounds function calls four arguments, the first two arguments is the location of the frame. From the left its 50 and from the top its 0, so it will open from the top.
        //The last two arguments of the setBounds function is the size of the frame which is 1440 and 850 for the width and height respectively.
        getContentPane().setBackground(Color.WHITE);//Make the frame color to white
        setLayout(null); //My own layout

        //Put quiz image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz.jpg"));//To take image from file directory
        JLabel image = new JLabel(i1); //Object of JLabel class which I called as image
        image.setBounds(0, 0, 1300, 320);//To put image because I did not use swing layouts, so I had to put the image by myself. Used setBounds function to make my own layout
        //In the setBounds function above, the position from the left I made is 0 and from the right is also 0, and 600 and 500 is the image's width and height
        add(image);//Use add function and pass the object which is i1 to put image (component) on top of the frame

        //Put labels below the quiz image in the frame
        //First label is of the name Question Number
        //Second label is of the actual question
        //Below the actual question label there will be the multiple choice questions
        qno = new JLabel(); //Leaving it empty because I insert the values dynamically. Because if I will make the values inside the object hardcore, then it will be always hardcore. But the question number will change always
        qno.setBounds(100, 380, 50, 30); //The position from the left I made is 100 and from the right is also 380, and 50 and 30 is the label's width and height
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));//To change the font size of the question number by making an object of the font class
        //The first argument the above object takes is the font family, second is the font type, and the third is the font size
        add(qno); //To add the question number to the frame

        //Displaying the question infront of the question number
        question = new JLabel(); //Leaving it empty because I insert the values dynamically. Because if I will make the values inside the object hardcore, then it will be always hardcore. But the question will change always
        question.setBounds(150, 380, 700, 30); //The position from the left I made is 100 and from the right is also 380, and 50 and 30 is the question's width and height
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));//To change the font size of the question by making an object of the font class
        //The first argument the above object takes is the font family, second is the font type, and the third is the font size
        add(question); //To add the question to the frame

        //Actual questions and answers. Questions with Options of the Quiz Application
        //In the 0th position, the question is stored and the rest 4 positions are the columns for the options
        //So, total 5 columns are there

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        //Answers Array of the above Questions
        answers[0][1] = "JDB"; //First question's answer
        answers[1][1] = "int"; //Second question's answer
        answers[2][1] = "java.util package"; //Third question's answer
        answers[3][1] = "Marker Interface"; //Fourth question's answer
        answers[4][1] = "Heap memory"; //Fifth question's answer
        answers[5][1] = "Remote interface"; //Sixth question's answer
        answers[6][1] = "import"; //Seventh question's answer
        answers[7][1] = "Java Archive"; //Eighth question's answer
        answers[8][1] = "java.lang.StringBuilder"; //Ninth question's answer
        answers[9][1] = "Bytecode is executed by JVM"; //Tenth question's answer


        //Make JRadioButton so that user can only select one option from those four options
        //JRadioButton for making the options button
        //For First Option
        opt1 = new JRadioButton(); //Make an object of the JRadioButton
        //Whatever I wrote inside it, it is written with the round buttons as the text with the option
        opt1.setBounds(170, 440, 700, 30);//Where I should show it. 170 from the left, 440 from the top, and the width and height respectively are 700 and 30
        opt1.setBackground(Color.WHITE);//Set background color to white
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));//Change font type
        //First argument is Font Family, second is Font Type, and third is the Font Size
        add(opt1);

        //For second option
        opt2 = new JRadioButton(); //Make an object of the JRadioButton
        //Whatever I wrote inside it, it is written with the round buttons as the text with the option
        opt2.setBounds(170, 480, 700, 30);//Where I should show it. 170 from the left, 480 from the top, and the width and height respectively are 700 and 30
        opt2.setBackground(Color.WHITE);//Set background color to white
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));//Change font type
        //First argument is Font Family, second is Font Type, and third is the Font Size
        add(opt2);

        //For third option
        opt3 = new JRadioButton(); //Make an object of the JRadioButton
        //Whatever I wrote inside it, it is written with the round buttons as the text with the option
        opt3.setBounds(170, 520, 700, 30);//Where I should show it. 170 from the left, 520 from the top, and the width and height respectively are 700 and 30
        opt3.setBackground(Color.WHITE);//Set background color to white
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));//Change font type
        //First argument is Font Family, second is Font Type, and third is the Font Size
        add(opt3);

        //For fourth option
        opt4 = new JRadioButton(); //Make an object of the JRadioButton
        //Whatever I wrote inside it, it is written with the round buttons as the text with the option
        opt4.setBounds(170, 560, 700, 30);//Where I should show it. 170 from the left, 560 from the top, and the width and height respectively are 700 and 30
        opt4.setBackground(Color.WHITE);//Set background color to white
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));//Change font type
        //First argument is Font Family, second is Font Type, and third is the Font Size
        add(opt4);

        //For user to choose one button for each question, I grouped the buttons
        groupoptions = new ButtonGroup(); //By making object of ButtonGroup class, can group all the buttons/RadioButtons
        groupoptions.add(opt1); //Grouping and adding all the options. So, when user select an option, the other options will automatically be deselected
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");//Make next button
        next.setBounds(1000, 440, 200, 30);//The position from the left is 1000, from the top is 460, and the width and height respectively are 200 and 30
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));//Changing the font of the button. First argument is Font Family, second is Font Type, and third is the Font Size
        next.setBackground(new Color(30, 144, 255)); //Change the background color of the button, used setBackground function
        //Stored the color value in RGB so made an object of the color class
        next.setForeground(Color.WHITE); //Change the foreground color, made an object of the color class
        //Directly called the color white
        next.addActionListener(this);//Need event when next button is clicked. Attached addActionListener event
        add(next); //Add the button

        lifeline = new JButton("Lifeline");//Made the 50 50 Lifeline button
        lifeline.setBounds(1000, 520, 200, 30);//The position from the left is 1000, from the top is 460, and the width and height respectively are 200 and 30
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));//Changing the font of the button. First argument is Font Family, second is Font Type, and third is the Font Size
        lifeline.setBackground(new Color(30, 144, 255)); //Change the background color of the button, used setBackground function
        //Stored the color value in RGB so made an object of the color class
        lifeline.setForeground(Color.WHITE); //Change the foreground color, made an object of the color class
        //Directly called the color white
        lifeline.addActionListener(this);//Need event when Lifeline button is clicked. Attached addActionListener event
        add(lifeline); //Add the button

        submit = new JButton("Submit");//Made the Submit button
        submit.setBounds(1000, 600, 200, 30);//The position from the left is 1000, from the top is 460, and the width and height respectively are 200 and 30
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));//Changing the font of the button. First argument is Font Family, second is Font Type, and third is the Font Size
        submit.setBackground(new Color(30, 144, 255)); //Change the background color of the button, used setBackground function
        //Stored the color value in RGB so made an object of the color class
        submit.setForeground(Color.WHITE); //Change the foreground color, made an object of the color class
        //Directly called the color white
        submit.setEnabled(false);//Initially this button will be disabled. Until the user will answer all the questions then the user can click this button
        submit.addActionListener(this);//Need event when submit button is clicked. Attached addActionListener event
        add(submit); //Add the button

        //Make a function to insert the values such as the question number, the question, the options, which are dynamically being inserted
        start(count); //Initial value I put is count because count's initial value is 0, to track the question number


        setVisible(true); //For the frame to show up and be visible

    }

    public void actionPerformed(ActionEvent ae){ //Override the unimplemented method
        // What to do after the button is clicked
        if (ae.getSource() == next) {//If next button is being called
            repaint();
            //Enable all the 4 options in the upcoming questions (except for only where it was being used)
            opt1.setEnabled(true); //To not make the 50-50 lifeline options disabled in the upcoming question. It will just work on the question it was used in
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1; //If next button is being clicked means user has already answered
            //From the groupoptions did the user selected any option, if not then I am making it empty (if), if yes then sending the actual option (else)
            if (groupoptions.getSelection() == null){ //If user didnt selected anything, empty will be stored
                //Whatever user have selected, will take that. If not selected anything then value - null.
                //Check whether user have selected any options from those 4 options. If user didn't select then ok
                useranswers[count][0] = "" ;//In 0th position, made empty string so in the question the user left it empty
                //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
            }else { //If user selected then will be stored in the useranswers
                //But if user selected, then track the option which user selected. Made an array for it above
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();//In 0th position, made empty string so in the question the user left it empty
                //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                //If user has answered, then the answer has to be stored in useranswers. So, from inside the groupoption, can take out the value using getSelection()
                //getSelection function will take out and give the option selected and getActionCommand will give the value
                //In the groupoptions all the 4 methods will be there then using the getSelection function, will take out the selected option, and then getActionCommand will give the value of the option and will be stored in the useranswers.
            }

            //To enable the submit button (Enable it in number 9 because count++ because after number 10 count cannot be incremented)
            if (count == 8){ //9th question
                next.setEnabled(false); //Disabling next button
                submit.setEnabled(true);
            }

            count++; //Increased the count
            start(count); //Called start method in which passed count

        } else if (ae.getSource() == lifeline){ //If lifeline button is being called
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) { // If question is 1,3,5,7,8
                opt2.setEnabled(false);//Disable option 2
                opt3.setEnabled(false);//Disable option 3
            }else { //If not those questions then
                opt1.setEnabled(false);//Disable option 1
                opt4.setEnabled(false);//Disable option 4
            }
            lifeline.setEnabled(false);//Lifeline button should be disabled after being used in one question

        //If user pressed submit button
        } else if (ae.getSource() == submit){ //If submit button is being called
            ans_given = 1;//Means user have answered

            //What did user select
            if (groupoptions.getSelection() == null) { //If user didnt selected anything, empty will be stored
                //Whatever user have selected, will take that. If not selected anything then value - null.
                //Check whether user have selected any options from those 4 options. If user didn't select then ok
                useranswers[count][0] = "";//In 0th position, made empty string so in the question the user left it empty
                //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
            } else { //If user selected then will be stored in the useranswers
                //But if user selected, then track the option which user selected. Made an array for it above
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();//In 0th position, made empty string so in the question the user left it empty
                //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                //If user has answered, then the answer has to be stored in useranswers. So, from inside the groupoption, can take out the value using getSelection()
                //getSelection function will take out and give the option selected and getActionCommand will give the value
                //In the groupoptions all the 4 methods will be there then using the getSelection function, will take out the selected option, and then getActionCommand will give the value of the option and will be stored in the useranswers.
            }

            //After user will select the option in the last question, calculate the score
            for (int i = 0; i < useranswers.length; i++){
                if (useranswers[i][0].equals(answers[i][1])){//(useranswers stored at 0th position)If useranswers array is equal to the actual answers which is the answers array
                    score += 10; //User gets +10 points

                }

            }
            setVisible(false);//Close this class

            //Open the Score class where score is displayed
            new Score(name, score);//Make an object of the score class and passed user's name and score

        }
    }

    //Make timer using graphics class because the value of the timer needs to be changed each second
    //Can repaint the frame using graphics class (Repaint the frame to update anything on the frame)
    //Repaint the frame using pain method

    //In paint method checking if user clicked in the submit button or not. If not then automatically submitted
    public void paint(Graphics g) { //Using paint method (it gets called automatically)and took an object of the Graphics class with the name 'g'
        super.paint(g);//Call the paint method from the super class and passed object of graphics class

        String time = "Time Left: " + timer + " seconds.";//Make timer so taking a string and displaying it on the frame and initially here it will be 15 seconds
        //Declared timer globally. The code up is the graphics for it to be seen in the frame
        g.setColor(Color.RED);//Take help of object of graphics class, used setColor class
        g.setFont(new Font("Tahoma", Font.BOLD, 25));//Change font size(made it 25 and font family is Tahoma and made it Bold) and font color used setFont function and made an object of the font class

        if (timer > 0) {//If the timer's value is more than 0
            g.drawString(time, 900, 400);//Using this can tell where to show which string from the x and y axis where to show
        } else {
            //After the time is up, I will show this for 1 second
            g.drawString("Time's Up!!", 900, 400);//Changed the timer to "Time's Up!!"
        }

        timer--; //Minus the timer value. Now timer value will be 14 but I have to minus the value after one second

        //Paint method is being called once when made class's object. If want to call it again, then have to call repaint method after one second
        try {
            Thread.sleep(1000);//So, the code of execution has to be stopped using thread class and inside it the sleep method
            //Using this can stop the code of execution for how much ever time you want. It takes value in milliseconds
            repaint();//Called repaint method. So that after every second the value will decrease
            //With the help of graphics class, I am repainting the frame. I called the repaint method which is calling the paint method
        } catch(Exception e){ //Enclose with Try and Catch because there is chances of getting exception
              //Wrapped it with try and catch
            e.printStackTrace();//Printed the error
        }

        //Now I will check if the user have answered or not by seeing if user selected any of the options
        if (ans_given == 1){ //If user have answered
            ans_given = 0; //Set the flag to 0 to track the next question
            timer =  15; //Set the timer back to 15
        } else if (timer < 0) { //If user didn't answer the question and timer is < 0
            //Automatically show next question
            timer = 15; //Set timer to 15
            opt1.setEnabled(true); //To not make the 50-50 lifeline options disabled in the upcoming question. It will just work on the question it was used in
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            //If time is up and still user has not yet pressed the next button
            if (count == 8){ //9th question
                next.setEnabled(false); //Disabling next button
                submit.setEnabled(true);
            }

            if (count == 9){//If time is up and user not yet clicked submit button, automatically quiz should be submitted
                //Submit button
                //Check which option in the last question did user selected
                if (groupoptions.getSelection() == null) { //If user didnt selected anything, empty will be stored
                    //Whatever user have selected, will take that. If not selected anything then value - null.
                    //Check whether user have selected any options from those 4 options. If user didn't select then ok
                    useranswers[count][0] = "";//In 0th position, made empty string so in the question the user left it empty
                    //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                } else { //If user selected then will be stored in the useranswers
                    //But if user selected, then track the option which user selected. Made an array for it above
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();//In 0th position, made empty string so in the question the user left it empty
                    //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                    //If user has answered, then the answer has to be stored in useranswers. So, from inside the groupoption, can take out the value using getSelection()
                    //getSelection function will take out and give the option selected and getActionCommand will give the value
                    //In the groupoptions all the 4 methods will be there then using the getSelection function, will take out the selected option, and then getActionCommand will give the value of the option and will be stored in the useranswers.
                }

                //After user will select the option in the last question, calculate the score
                for (int i = 0; i < useranswers.length; i++){
                    if (useranswers[i][0].equals(answers[i][1])){//(useranswers stored at 0th position)If useranswers array is equal to the actual answers which is the answers array
                          score += 10; //User gets +10 points

                    }

                }
                setVisible(false);//Close this class
                //Open the Score class where score is displayed



            }else { //If user has not yet clicked next for next question and time is up, automatically should go to next question
                //Next button
                //Before the 15 seconds, have to check whether the user has answered or not
                //To check that, used ButtonGroup class. The groupoptions.
                if (groupoptions.getSelection() == null) { //If user didn't selected anything, empty will be stored
                    //Whatever user have selected, will take that. If not selected anything then value - null.
                    //Check whether user have selected any options from those 4 options. If user didn't select then ok
                    useranswers[count][0] = "";//In 0th position, made empty string so in the question the user left it empty
                    //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                } else { //If user selected then will be stored in the useranswers
                    //But if user selected, then track the option which user selected. Made an array for it above
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();//In 0th position, made empty string so in the question the user left it empty
                    //Passed count in the rows brackets instead of passing 0 because count's initial value is 0
                    //If user has answered, then the answer has to be stored in useranswers. So, from inside the groupoption, can take out the value using getSelection()
                    //getSelection function will take out and give the option selected and getActionCommand will give the value
                    //In the groupoptions all the 4 methods will be there then using the getSelection function, will take out the selected option, and then getActionCommand will give the value of the option and will be stored in the useranswers.
                }
                count++;//After taking out all the options, do count++, Count's initial value is 0 then after ++ value will be 1
                start(count);//So, next question will be seen and for that, have to call start function because inside start function we are taking count and in the start function on the basis of count displaying all the questions and options. So, passed count
            }
        }
    }

        //Make the start function
        public void start ( int count){
            qno.setText("" + (count + 1) + ". "); //Count's initial value is 0 so here did 0 + 1. So, the initial first question value will be + 1
            //Put the brackets in the count+1 so that it will be created as an arithmetic expression.
            //So, the question number will be incremented by 1
            //Whatever value passed in the start function, when added with 1, it will be the question number
            //Put "" to convert from int to String. Value dynamically set

            question.setText(questions[count][0]);//Set values in the question. Array in the name of "questions" in which all questions are there
            //Count's first value is 0. So, it will take the value from the 0th row and 0th column
            //It will take the value from the first row and first column
            //Which is this: questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";

            //Same thing is being done with the options
            opt1.setText(questions[count][1]); //Because the first option is in column 1 and not 0 like in the question part
            opt1.setActionCommand(questions[count][1]);
            //If user selected an option, then have to make an action. To do that, used a function called setActionCommand
            //Before doing the getActionCommand function, first have to set the values
            opt2.setText(questions[count][2]);
            opt2.setActionCommand(questions[count][2]);
            opt3.setText(questions[count][3]);
            opt3.setActionCommand(questions[count][3]);
            opt4.setText(questions[count][4]); //Values are set here
            opt4.setActionCommand(questions[count][4]);

            groupoptions.clearSelection(); //So that when going to the next question, the option which was selected at the previous question won't be automatically selected in the next question

        }


        public static void main (String[]args){ //Main method (for JVM to see when running the class)
            new Quiz("User"); //Object of class and pass "User" because it should be parameterized and not default constructor


        }

    }
