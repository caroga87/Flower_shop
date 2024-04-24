package n2exerciciSQL.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static final Scanner input = new Scanner(System.in);
    private static final String INT_FORMAT_ERR_MSG = "There is a format error on your response. Enter a integer";
    private static final String DOUBLE_FORMAT_ERR_MSG = "There is a format error on your response. Enter a double";
    private static final String FLOAT_FORMAT_ERR_MSG = "There is a format error on your response. Enter a float";
    private static final String EMPTY_STRING_ERR_MSG = "Your response must not be empty.";
    private static final String YES_NO_ERR_MSG = "Hay un error en tu respuesta. Ingresa S or N if si o no.";
    private static final String BYTE_FORMAT_ERR_MSG = "There is a format error on your response. Enter a byte";

    public static byte inputByte (String message) {
        byte response = 0;
        boolean okey = false;
        do {
            System.out.println(message);
            try {
                response = input.nextByte();
                okey = true;
            } catch (InputMismatchException ex) {
                System.err.println(BYTE_FORMAT_ERR_MSG);
            }
            input.nextLine();
        } while (!okey);
        return response;
    }

    public static int inputInt (String message) {
        int response = 0;
        boolean okey = false;
        do {
            System.out.println(message);
            try {
                response = input.nextInt();
                okey = true;
            } catch (InputMismatchException ex) {
                System.err.println(INT_FORMAT_ERR_MSG);
            }
            input.nextLine();
        } while (!okey);
        return response;
    }

    public static String inputString (String message) {
        String response = "";
        boolean okey = false;
        do {
            System.out.println(message);
            try {
                response = input.nextLine();
                if (response.isEmpty()) {
                    throw new Exception(EMPTY_STRING_ERR_MSG);
                } else {

                    okey = true;
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } while (!okey);
        return response;
    }

    public static double inputDouble (String message) {
        double response = 0.0;
        boolean okey = false;
        do {
            System.out.println(message);
            try {
                response = input.nextDouble();
                okey = true;
            } catch (InputMismatchException ex) {
                System.err.println(DOUBLE_FORMAT_ERR_MSG);
            }
            input.nextLine();
        } while (!okey);
        return response;
    }

    public static float inputFloat (String message) {
        float response = 0.0F;
        boolean okey = false;
        do {
            System.out.println(message);
            try {
                response = input.nextFloat();
                okey = true;
            } catch (InputMismatchException ex) {
                System.err.println(FLOAT_FORMAT_ERR_MSG);
            }
            input.nextLine();
        } while (!okey);
        return response;
    }

    public static boolean inputSiNo (String message) {
        boolean booleanResponse = false;
        boolean okey = false;
        String userResponse = "";

        do {
            System.out.println(message);
            try {
                userResponse = input.nextLine().toUpperCase();
                if (userResponse.charAt(0) == 'S') {
                    booleanResponse = true;
                    okey = true;
                } else if (userResponse.charAt(0) == 'N') {
                    booleanResponse = false;
                    okey = true;
                } else {
                    throw new Exception(YES_NO_ERR_MSG);
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } while (!okey);
        return booleanResponse;
    }
}