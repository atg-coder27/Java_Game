import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class RockScissorsPaper extends Applet implements ActionListener
{
private Button rockButton;
private Button scissorsButton;
private Button paperButton;
private String buttonPressed = "";
private int computerValue = -1;
private int myValue;
private int playerScore = 10;
private int computerScore = 10;
private int drawScore = 0;
private Image imgRock;
private Image imgScissors;
private Image imgPaper;

public void init()
{
    rockButton = new Button("Rock");
    scissorsButton = new Button("Scissors");
    paperButton = new Button("Paper");
    add(rockButton);
    add(scissorsButton);
    add(paperButton);
    rockButton.addActionListener(this);
    scissorsButton.addActionListener(this);
    paperButton.addActionListener(this);
    imgRock = getImage(getCodeBase(), "rock.jpg");
    imgScissors = getImage(getCodeBase(), "scissors.jpg");
    imgPaper = getImage(getCodeBase(), "paper.jpg");
}

public void actionPerformed(ActionEvent event)
{
    buttonPressed = ((Button)event.getSource()).getLabel();
    computerValue = randomNumber012();
    translator(buttonPressed);
    repaint();
}

public void paint(Graphics g)
{
    super.paint(g);
    rockButton.setLocation(20,260);
    rockButton.setSize(70,35);
    paperButton.setLocation(210, 260);
    paperButton.setSize(70, 35);
    scissorsButton.setLocation(380, 260);
    scissorsButton.setSize(90, 35);
    choice(g);
    g.drawString("Player's Wins: " + playerScore, 10, 20);
    g.drawString("Computer's Wins: " + computerScore, 180, 20);
    g.drawString("Draws: " + drawScore, 400, 20);
    g.drawString("Your Choice: " + buttonPressed, 20, 60);
    g.drawString("Computer's Pick: ", 350, 60);
    winner(g, computerValue, myValue);
}

int randomNumber012()
{
    return (int)(Math.random()*3);
}

public void translator(String s)
{
    if(s.equals("Rock"))
    {
        myValue = 0;
    }
    else if(s.equals("Scissors"))
    {
        myValue = 1;
    }
    else if(s.equals("Paper"))
    {
        myValue = 2;
    }
}

public void choice(Graphics g)
{
    if(myValue == 0)
    {
        g.drawImage(imgRock, 20, 100, 100, 60, this);
    }
    else if(myValue == 1)
    {
        g.drawImage(imgScissors, 20, 100, 100, 60, this);
    }
    else if(myValue == 2)
    {
        g.drawImage(imgPaper, 20, 100, 100, 60, this);
    }

    if(computerValue == 0)
    {
        g.drawString("Computer's Pick: Rock", 350, 60);
        g.drawImage(imgRock, 350, 100, 100, 60, this);
    }
    else if(computerValue == 1)
    {
        g.drawString("Computer's Pick: Scissors", 350, 60);
        g.drawImage(imgScissors, 350, 100, 100, 60, this);
    }
    else if(computerValue == 2)
    {
        g.drawString("Computer's Pick: Paper", 350, 60);
        g.drawImage(imgPaper, 350, 100, 100, 60, this);
    }
}

public void winner(Graphics g, int cv, int mv)
{
    if(cv == -1)
    {
        g.drawString("", 200, 100);
    }
    else if(cv == mv)
    {
        g.drawString("Draw", 200, 250);
        drawScore = drawScore + 1;
    }
    else if(cv == 0 && mv == 1 || cv == 2 && mv == 0 || cv == 1 && mv == 2)
    {
        g.drawString("Computer Wins", 200, 250);
        playerScore = playerScore - 1;
    }
    else
    {
        g.drawString("You Win!", 200, 250);
        computerScore = computerScore - 1;
    }

    if (playerScore == 0)
    {
        System.out.println("You lost!");
        playerScore = 10;
        computerScore = 10;
        drawScore = 0;
    }
    else if(computerScore == 0)
    {
        System.out.println("You won!");
        playerScore = 10;
        computerScore = 10;
        drawScore = 0;
    }
}
}