import java.awt.*;
import java.util.*;
import java.applet.Applet;

public class Expo
{
static final Color red            = Color.red;
static final Color green          = Color.green;
static final Color purple         = new Color(128,0,128);
static final Color black          = Color.black;
static Color currentColor         = black;
public static void setColor(Graphics g, Color newColor)
{
    g.setColor(newColor);
    currentColor = newColor;
}
public static void drawLine(Graphics g, int x1, int y1, int x2, int y2)
{
    g.drawLine(x1,y1,x2,y2);
}
public static void fillCircle(Graphics g, int centerX, int centerY, int radius)
{
    int diameter = 2 * radius;
    g.fillOval(centerX-radius, centerY-radius, diameter, diameter);
}
}