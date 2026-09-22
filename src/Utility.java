/*
* Copyright (c) 2026 Nathan William Barros. All rights reserved.
*
* Licensed under the MIT License (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    https://opensource.org/licenses/MIT
*    OR
*    see repo LICENSE
*/

/**
* Assignment 4b: Utility Helper Class
*
* @author Nathan W. Barros (nwbarros@students.unwsp.edu)
* @course COS 3271
* @version 1.0.0
*/

import java.util.Scanner;

class Utility {
    private static final Scanner userin = new Scanner(System.in);
    private static final int ATTEMPTS = 3;

    public static final String CLRSCR = "\033[2J\033[1;1H";

    public static void showBanner(String msg) {
        System.out.print(
                CLRSCR +
                "======================================================================\n"+
                "                       L.I.F.E  S.I.M.U.L.A.T.O.R                     \n"+
                "======================================================================\n"+
                msg + "\n\n");
    }

    /** Returns the accepted string, or null if the user types the escapeStr.
     *
     * @param prompt    - prompt shown to the user
     * @param allowed   - array of accepted input str
     * @param escapeStr - return null on this str
     *
     * @return String || null
     * */
    public static String queryUser(String prompt, String[] allowed, String escapeStr) {

        for (int i = 0; i < ATTEMPTS; i++) {
            System.out.print(prompt);
            String response = userin.nextLine();

            if (escapeStr.equalsIgnoreCase(response))   return null;

            // accept any response
            if (allowed == null && !response.isEmpty()) return response;

            // check for accepted responses
            for (String word : allowed) {
                if (word.equalsIgnoreCase(response)) return word;
            }

            System.out.print("----- response must be in [" + String.join(", ", allowed) + "] -----\n");
        }

        handleExit("Exceeded allocated attempts.", 0);
        return null; // included to prevent static analyzer warnings
    }

    /** Returns the accepted integer, or null if the user types the escapeStr.
     *
     * @param prompt    - prompt shown to the user
     * @param min       - minimum integer accepted
     * @param max       - maximum integer accepted
     * @param escapeStr - return null on this str
     *
     * @return Integer || null
     * */
    public static Integer getIntFromRange(String prompt, int min, int max, String escapeStr) {

        for (int i = 0; i < ATTEMPTS; i++) {
            System.out.print(prompt);
            String tmpStr = userin.nextLine();

            if (escapeStr.equalsIgnoreCase(tmpStr)) return null;

            try {
                Integer value = Integer.parseInt(tmpStr);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException e) {
                System.out.print("----- invalid integer -----\n");
            }

            System.out.printf("----- range %d to %d -----\n", min, max);
        }

        handleExit("Exceeded allocated attempts.", 0);
        return null; // unreachable
    }

    /** Returns the accepted double, or null if the user typed the escapeStr.
     *
     * @param prompt    - prompt shown to the user
     * @param min       - minimum float value
     * @param max       - maximum float value
     * @param escapeStr - return null on this str
     *
     * @return Double || null
     **/
    public static Double getDoubleFromRange(String prompt, double min, double max, String escapeStr) {

        for (int i = 0; i < ATTEMPTS; i++) {
            System.out.print(prompt);
            String tmpStr = userin.nextLine();

            if (escapeStr.equalsIgnoreCase(tmpStr)) return null;

            try {
                Double value = Double.parseDouble(tmpStr);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException e) {
                System.out.print("----- invalid number -----\n");
            }

            System.out.printf("----- range %.1f to %.1f -----\n", min, max);
        }

        handleExit("Exceeded allocated attempts.", 0);
        return null; // unreachable
    }

    public static void handleExit(String msg, int code) {
        System.out.println(CLRSCR + msg);
        System.exit(code);
    }
}

// EOF
