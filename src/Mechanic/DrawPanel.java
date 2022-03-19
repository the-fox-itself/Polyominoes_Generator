package Mechanic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Libraries.Methods.*;
import static Mechanic.MainVariables.*;

public class DrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < listOfPolyominoes.size(); i++) {
            ArrayList<String> polyominoes = listOfPolyominoes.get(i);

            for (int i1 = 0; i1 < polyominoes.size(); i1++) {
                String polyomino = polyominoes.get(i1);

                for (String square : polyomino.split("_")) {
                    int x = Integer.parseInt(square.split(":")[0]);
                    int y = Integer.parseInt(square.split(":")[1]);

                    int r = (i+1)*40;
                    int gr = i1*10;
                    int b = 50;
                    while (r > 255) {
                        r -= 255;
                    }
                    while (gr > 255) {
                        gr -= 255;
                    }
                    g.setColor(new Color(r, gr, b));
                    g.fillRect(((int)FRAME_SIZE.getWidth()/2)+i1*5*cameraScalePixelsPerSquare+x*cameraScalePixelsPerSquare+cameraCenterSquareX*cameraScalePixelsPerSquare+cameraCenterSquareDoubleX, ((int)FRAME_SIZE.getHeight()/2)+i*10*cameraScalePixelsPerSquare+y*cameraScalePixelsPerSquare+cameraCenterSquareY*cameraScalePixelsPerSquare+cameraCenterSquareDoubleY, cameraScalePixelsPerSquare, cameraScalePixelsPerSquare);
                }
            }
        }
    }
}
