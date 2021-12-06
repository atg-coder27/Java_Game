import java.applet. *;
import java.awt. *;
import java.awt.event. *;
public class NumberGame extends Applet
{
	TextField text1, text2;
	Button button1, button2;
	int key = (int) (Math.random () * 200) +1;
	int time = 0;
	public void init ()
	{
		text1 = new TextField (10);
		text2 = new TextField (25);
		button1 = new Button ("Go");
		button2 = new Button ("key");
		add (text1);
		add (text2);
		add (button1);
		add (button2);
		text1.addActionListener (new TextAct ());
		text2.addActionListener (new TextAct ());
		button1.addActionListener (new ButtonAct ());
		button2.addActionListener (new ButtonAct ());
	}
	class TextAct implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			TextField text;
			int operand;
			text = (TextField) (e.getSource ());
			operand = Integer.parseInt (text.getText ());
			if (operand <0 | operand> 200)
				text.setText ("Input data out of bounds");
		}
	}
	class ButtonAct implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			int input;
			if (e.getSource () == button1)
			{
				input = Integer.parseInt (text1.getText ());
				if (key == input)
				{
					text2.setText ("goodluck!" + "you have used" + Integer.toString (time) + "times!");
				}
				else
				{
					time ++;
					if (key> input)
						text2.setText ("you are small!");
					else text2.setText ("you are large!");
				}
			}
			else 
			{
				text2.setText ("you are so foolish ....");
				text1.setText (Integer.toString (key));
			}
		}
	}
	
}