package com.company;

import java.sql.Array;

public class Main {

    public static final String TEXT_RESET = "\u001B[0m";

    public static final String TEXT_BLACK = "\u001B[30m";

    public static final String TEXT_BG_PURPLE = "\u001B[45m";

    public static final String TEXT_BRIGHT_BG_BLACK = "\u001B[100m";
    public static final String TEXT_BRIGHT_BG_RED = "\u001B[101m";
    public static final String TEXT_BRIGHT_BG_GREEN = "\u001B[102m";
    public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String TEXT_BRIGHT_BG_BLUE = "\u001B[104m";

    public static void main(String[] args) {
        String input = "all";
        //String input = "Touch";
        //String input = "Controller";
        //String input = "KBM";
        //                stadium, venice, prison, pinball, music, oriental, picnic, station
        //overall
        double[] wrss = {46.646, 57.495, 34.274, 30.450, 43.201, 30.275, 17.506, 58.915};
        //Touch
        //double[] wrss = {49.994, 63.411, 38.855, 33.113, 46.821, 32.701, 19.095, 64.762};
        //Controller
        //double[] wrss = {47.240, 59.125, 37.050, 30.843, 44.490, 31.966, 17.708, 62.325};
        //KBM
        //double[] wrss = {46.646, 57.495, 34.274, 30.450, 43.201, 30.275, 17.506, 58.915};

        double[] wrs = {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 8; i++) {
            Double replace = Double.parseDouble(String.format("%.1f", wrss[i]));
            if (replace > wrss[i]) {
                replace = replace - 0.05;
            }
            replace = Double.parseDouble(String.format("%.3f", replace));
            wrs[i] = replace;
        }

        String spacing = "%-10s";

        System.out.println("Printing bracket times for: " + input);
        System.out.println("Music:" + "    Oriental:" + " Picnic:" + "   Pinball:" + "  Prison:" + "   Stadium:" + "  Station:" + "  Venice:");
        System.out.print(TEXT_BLACK);
        System.out.print(TEXT_BG_PURPLE);
        System.out.printf(spacing, wrs[4]);
        System.out.printf(spacing, wrs[5]);
        System.out.printf(spacing, wrs[6]);
        System.out.printf(spacing, wrs[3]);
        System.out.printf(spacing, wrs[2]);
        System.out.printf(spacing, wrs[0]);
        System.out.printf(spacing, wrs[7]);
        System.out.printf(spacing, wrs[1]);
        System.out.print(TEXT_RESET);
        System.out.print(TEXT_BLACK);
        System.out.println();
        System.out.print(TEXT_BRIGHT_BG_BLUE);
        System.out.printf(spacing, converter(wrs[4], 1.01));
        System.out.printf(spacing, converter(wrs[5], 1.01));
        System.out.printf(spacing, converter(wrs[6], 1.01));
        System.out.printf(spacing, converter(wrs[3], 1.01));
        System.out.printf(spacing, converter(wrs[2], 1.01));
        System.out.printf(spacing, converter(wrs[0], 1.01));
        System.out.printf(spacing, converter(wrs[7], 1.01));
        System.out.printf(spacing, converter(wrs[1], 1.01));
        System.out.print(TEXT_RESET);
        System.out.print(TEXT_BLACK);
        System.out.println();
        System.out.print(TEXT_BRIGHT_BG_GREEN);
        System.out.printf(spacing, converter(wrs[4], 1.025));
        System.out.printf(spacing, converter(wrs[5], 1.025));
        System.out.printf(spacing, converter(wrs[6], 1.025));
        System.out.printf(spacing, converter(wrs[3], 1.025));
        System.out.printf(spacing, converter(wrs[2], 1.025));
        System.out.printf(spacing, converter(wrs[0], 1.025));
        System.out.printf(spacing, converter(wrs[7], 1.025));
        System.out.printf(spacing, converter(wrs[1], 1.025));
        System.out.print(TEXT_RESET);
        System.out.print(TEXT_BLACK);
        System.out.println();
        System.out.print(TEXT_BRIGHT_BG_YELLOW);
        System.out.printf(spacing, converter(wrs[4], 1.05));
        System.out.printf(spacing, converter(wrs[5], 1.05));
        System.out.printf(spacing, converter(wrs[6], 1.05));
        System.out.printf(spacing, converter(wrs[3], 1.05));
        System.out.printf(spacing, converter(wrs[2], 1.05));
        System.out.printf(spacing, converter(wrs[0], 1.05));
        System.out.printf(spacing, converter(wrs[7], 1.05));
        System.out.printf(spacing, converter(wrs[1], 1.05));
        System.out.print(TEXT_RESET);
        System.out.print(TEXT_BLACK);
        System.out.println();
        System.out.print(TEXT_BRIGHT_BG_RED);
        System.out.printf(spacing, converter(wrs[4], 1.1));
        System.out.printf(spacing, converter(wrs[5], 1.1));
        System.out.printf(spacing, converter(wrs[6], 1.1));
        System.out.printf(spacing, converter(wrs[3], 1.1));
        System.out.printf(spacing, converter(wrs[2], 1.1));
        System.out.printf(spacing, converter(wrs[0], 1.1));
        System.out.printf(spacing, converter(wrs[7], 1.1));
        System.out.printf(spacing, converter(wrs[1], 1.1));
        System.out.print(TEXT_RESET);
        System.out.print(TEXT_BLACK);
        System.out.println();
        System.out.print(TEXT_BRIGHT_BG_BLACK);
        System.out.printf(spacing, converter(wrs[4], 1.2));
        System.out.printf(spacing, converter(wrs[5], 1.2));
        System.out.printf(spacing, converter(wrs[6], 1.2));
        System.out.printf(spacing, converter(wrs[3], 1.2));
        System.out.printf(spacing, converter(wrs[2], 1.2));
        System.out.printf(spacing, converter(wrs[0], 1.2));
        System.out.printf(spacing, converter(wrs[7], 1.2));
        System.out.printf(spacing, converter(wrs[1], 1.2));
    }

    public static double converter(double wr, double multiplier) {
        Double replace =  Double.parseDouble(String.format("%.3f", wr * multiplier));
        replace = Double.parseDouble(String.format("%.1f", replace));
        if (replace > wr) {
            replace = replace - 0.05;
        }
        replace = Double.parseDouble(String.format("%.3f", replace));
        return replace;
    }
}
