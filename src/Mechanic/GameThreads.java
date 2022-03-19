package Mechanic;

import java.util.Date;

import static Mechanic.MainVariables.*;

public class GameThreads {
    public static class GameLoop extends Thread {
        public void run() {
            double previous = new Date().getTime();
            double steps = 0;
            while (true) {
                if (gameLoopOn) {
                    double loopStartTime = new Date().getTime();
                    double elapsed = loopStartTime - previous;
                    previous = new Date().getTime();
                    steps += elapsed;

                    handleInput();

                    while (steps >= millisecondsPerUpdate) {
                        updateGameStats();
                        steps -= millisecondsPerUpdate;
                    }

                    frame.repaint();

                    double loopSlot = millisecondsPerUpdate;
                    double endTime = loopStartTime + loopSlot;
                    while (new Date().getTime() < endTime) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ignored) {
                        }
                    }
                } else {
                    previous = new Date().getTime();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public void handleInput() {
            if (!s && w) {
                cameraCenterSquareDoubleY += 1;
                if (cameraCenterSquareDoubleY >= cameraScalePixelsPerSquare) {
                    cameraCenterSquareY += cameraCenterSquareDoubleY/cameraScalePixelsPerSquare;
                    cameraCenterSquareDoubleY = 0;
                }
            } else if (!w && s) {
                cameraCenterSquareDoubleY -= 1;
                if (cameraCenterSquareDoubleY <= -1) {
                    cameraCenterSquareY -= Math.max(Math.abs(cameraCenterSquareDoubleY) / cameraScalePixelsPerSquare, 1);
                    cameraCenterSquareDoubleY = cameraScalePixelsPerSquare-Math.abs(cameraCenterSquareDoubleY);
                }
            }
            if (!d && a) {
                cameraCenterSquareDoubleX += 1;
                if (cameraCenterSquareDoubleX >= cameraScalePixelsPerSquare) {
                    cameraCenterSquareX += cameraCenterSquareDoubleX/cameraScalePixelsPerSquare;
                    cameraCenterSquareDoubleX = 0;
                }
            } else if (!a && d) {
                cameraCenterSquareDoubleX -= 1;
                if (cameraCenterSquareDoubleX <= -1) {
                    cameraCenterSquareX -= Math.max(Math.abs(cameraCenterSquareDoubleX) / cameraScalePixelsPerSquare, 1);
                    cameraCenterSquareDoubleX = cameraScalePixelsPerSquare-Math.abs(cameraCenterSquareDoubleY);
                }
            }
        }
        public void updateGameStats() {

        }
    }
}
