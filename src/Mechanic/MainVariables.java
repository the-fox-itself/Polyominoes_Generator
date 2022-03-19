package Mechanic;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import static Libraries.Methods.*;

public class MainVariables {
    public static ArrayList<ArrayList<String>> listOfPolyominoes = new ArrayList<>();

    public static GameThreads.GameLoop gameLoop = new GameThreads.GameLoop();
    public static double millisecondsPerUpdate = 1000d / 144;

    public static int cameraCenterSquareX = 0;
    public static int cameraCenterSquareY = 0;
    public static int cameraCenterSquareDoubleX = 0;
    public static int cameraCenterSquareDoubleY = 0;
    public static int cameraScalePixelsPerSquare = 100;

    public static boolean gameLoopOn;
    public static boolean fullscreenOn = false;

    public static boolean w;
    public static boolean a;
    public static boolean s;
    public static boolean d;

    public static JFrame frame = getFrame("", null, FRAME_SIZE.width, FRAME_SIZE.height, null, null, true);


    public static class FrameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    if (!w)
                        w = true;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    if (!a)
                        a = true;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    if (!d)
                        d = true;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    if (!s)
                        s = true;
                    break;
                default:
                    System.out.println(e.getKeyChar());
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    w = false;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    a = false;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    d = false;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    s = false;
                    break;
            }
        }
    }

    public static class FrameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static class FrameWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            switch (e.getWheelRotation()) {
                case 1:
                    if (cameraScalePixelsPerSquare > 1) {
                        cameraScalePixelsPerSquare -= 1;
                        if (cameraCenterSquareDoubleY >= cameraScalePixelsPerSquare) {
                            cameraCenterSquareDoubleY -= cameraScalePixelsPerSquare;
                            cameraCenterSquareY += 1;
                        }
                        if (cameraCenterSquareDoubleY <= -1) {
                            cameraCenterSquareDoubleY += cameraScalePixelsPerSquare;
                            cameraCenterSquareY -= 1;
                        }
                        if (cameraCenterSquareDoubleX >= cameraScalePixelsPerSquare) {
                            cameraCenterSquareDoubleX -= cameraScalePixelsPerSquare;
                            cameraCenterSquareX += 1;
                        }
                        if (cameraCenterSquareDoubleX <= -1) {
                            cameraCenterSquareDoubleX += cameraScalePixelsPerSquare;
                            cameraCenterSquareX -= 1;
                        }
                    }
                    break;
                case -1:
                    cameraScalePixelsPerSquare += 1;
                    if (cameraCenterSquareDoubleY >= cameraScalePixelsPerSquare) {
                        cameraCenterSquareDoubleY -= cameraScalePixelsPerSquare;
                        cameraCenterSquareY += 1;
                    }
                    if (cameraCenterSquareDoubleY <= -1) {
                        cameraCenterSquareDoubleY += cameraScalePixelsPerSquare;
                        cameraCenterSquareY -= 1;
                    }
                    if (cameraCenterSquareDoubleX >= cameraScalePixelsPerSquare) {
                        cameraCenterSquareDoubleX -= cameraScalePixelsPerSquare;
                        cameraCenterSquareX += 1;
                    }
                    if (cameraCenterSquareDoubleX <= -1) {
                        cameraCenterSquareDoubleX += cameraScalePixelsPerSquare;
                        cameraCenterSquareX -= 1;
                    }
                    break;
            }
        }
    }
}
