//Aja Curry
//Alex Soyoh

//Used with DrawingPanel.java

import java.awt.*;

public class GUI {
    public static void main(String [] args) {
        DrawingPanel panel = new DrawingPanel(500,500);
        Graphics g = panel.getGraphics();

        g.drawRect(110,50,200,100);
        g.drawOval(110,200,200,100);
        g.drawString("GAMEOVER",130,80);
        g.drawString("YOU WIN",130,230);
    }
}