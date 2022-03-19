package Mechanic;

import java.util.ArrayList;
import java.util.List;

import static Mechanic.MainVariables.*;
import static Libraries.Methods.*;

public class Mechanic {
    final public static DrawPanel drawPanel = new DrawPanel();

    void preparation() {
        polyominoesGeneration();

        frame.addKeyListener(new FrameKeyListener());
        frame.addMouseListener(new FrameMouseListener());
        frame.addMouseWheelListener(new FrameWheelListener());

        frame.setUndecorated(fullscreenOn);

        frame.add(drawPanel);
        drawPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        gameLoopOn = true;
        gameLoop.start();

        visTrue(frame);
    }

    void polyominoesGeneration() {
        ArrayList<String> monominoes = new ArrayList<>();
        monominoes.add("0:0");
        listOfPolyominoes.add(monominoes);
        System.out.println(monominoes.size());
        for (int squares = 2; squares < 6; squares++) {
            ArrayList<String> previousSet = listOfPolyominoes.get(squares-2);
            ArrayList<String> repeats = new ArrayList<>();
            ArrayList<String> newSet = new ArrayList<>();
            String newPolyomino;

            for (String previousPolyomino : previousSet) {
                ArrayList<String> polyomino = new ArrayList<>(List.of(previousPolyomino.split("_")));
                for (String square1 : polyomino) {
                    int x = Integer.parseInt(square1.split(":")[0]);
                    int y = Integer.parseInt(square1.split(":")[1]);

                    if (!polyomino.contains((x+1)+":"+(y)) & !repeats.contains(previousPolyomino+"_"+(x+1)+":"+(y))) {
                        newPolyomino = previousPolyomino+"_"+(x+1)+":"+(y);
                        newSet.add(newPolyomino);
                        repeats.addAll(getRepeats(newPolyomino));
                    }
                    if (!polyomino.contains((x-1)+":"+(y)) & !repeats.contains(previousPolyomino+"_"+(x-1)+":"+(y)) & ((y > 0 && (x-1) > 0) || (y <= 0 && (x-1) >= 0))) {
                        newPolyomino = previousPolyomino+"_"+(x-1)+":"+(y);
                        newSet.add(newPolyomino);
                        repeats.addAll(getRepeats(newPolyomino));
                    }
                    if (!polyomino.contains((x)+":"+(y+1)) & !repeats.contains(previousPolyomino+"_"+(x)+":"+(y+1)) & (((y+1) > 0 && x > 0) || ((y+1) <= 0 && x >= 0))) {
                        newPolyomino = previousPolyomino+"_"+(x)+":"+(y+1);
                        newSet.add(newPolyomino);
                        repeats.addAll(getRepeats(newPolyomino));
                    }
                    if (!polyomino.contains((x)+":"+(y-1)) & !repeats.contains(previousPolyomino+"_"+(x)+":"+(y-1))) {
                        newPolyomino = previousPolyomino+"_"+(x)+":"+(y-1);
                        newSet.add(newPolyomino);
                        repeats.addAll(getRepeats(newPolyomino));
                    }
                }
            }
            listOfPolyominoes.add(newSet);
            System.out.println(newSet.size());
        }
    }

    ArrayList<String> getRepeats(String polyomino) {
        ArrayList<String> repeatsReturn = new ArrayList<>();
        repeatsReturn.add(polyomino);
        for (int i = 0; i < 3; i++) {
            StringBuilder rotatedPolyomino = new StringBuilder();
            for (String coordinates : polyomino.split("_")) {
                if (!rotatedPolyomino.toString().equals("")) {
                    rotatedPolyomino.append("_");
                }

                int x = Integer.parseInt(coordinates.split(":")[0]);
                int y = Integer.parseInt(coordinates.split(":")[1]);

                int x90 = 0;
                int y90 = 0;

                if ((x <= 0 && y >= 0) || (x >= 0 && y > 0)) {
                    y90 = Math.abs(x);
                } else {
                    y90 = -x;
                }
                x90 = y;

                rotatedPolyomino.append(x90).append(":").append(y90);
            }
            repeatsReturn.add(rotatedPolyomino.toString());
        }
        return repeatsReturn;
    }
}
