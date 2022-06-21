package com.ufba.eng.soft.bibliotecapessoal.front.util;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.RoundButton;

import javax.swing.*;
import java.awt.*;

public class Style {

    public static Color getGreenColor() {
        return new Color(155, 190, 57);
    }

    public static Color getExitRed() {
        return new Color(233, 94, 93);
    }

    public static Color getGrayColor() {
        return new Color(81, 95, 129);
    }

    public static Font getStandardFont(int size) {
//        return new Font("Segoe UI Semibold", 0, size);
        return new Font("Yu Gothic UI Semilight", 0, size);
    }

    public static void setStandardUiButtonStyle(JButton button, Color backgroundColor) {
        button.setBorder(new RoundButton(10));
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
    }

    public static Color getEasyBlueColor() {
        return new Color(56, 152, 184);
    }

    public static Color getPurpleColor() {
        return new Color(176, 82, 191);
    }

    public static Color getOrangeColor() {
        return new Color(238, 146, 50);
    }
}
