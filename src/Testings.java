//import java.util.Scanner;
//
//public class Testings {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int passkey;
//        boolean flag = true;
//
//        do {
//            passkey = sc.nextInt();
//            String psk = Integer.toString(passkey);
//            System.out.print("\n");
//            if (psk.length() < 6) {
//                System.out.print("");
//                System.out.print("!!! passkey must contain at-least 6 characters...\n$ Enter passkey again: ");
//            } else {
//                flag = false;
//            }
//        } while (flag);
//
//        System.out.println(passkey);
//
//        sc.close();
//    }
//}
//
//

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Testings {
    private static final int MAX_ATTEMPTS = 3;
    private static String storedPinHash = null;  // Stores hashed PIN

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Set your 4-digit PIN: ");
        String newPin = sc.nextLine();

        if (!isValidPin(newPin)) {
            System.out.println("❌ Weak or invalid PIN! Try again.");
            return;
        }

        storedPinHash = hashPin(newPin);
        System.out.println("✅ PIN set successfully and securely stored!");

        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("\nEnter your PIN to access: ");
            String enteredPin = sc.nextLine();

            if (checkPin(enteredPin)) {
                System.out.println("✅ Access granted!");
                break;
            } else {
                attempts++;
                System.out.println("❌ Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("⛔ Account locked. Too many failed attempts.");
            }
        }
        sc.close();
    }

    // ✅ Check if PIN is 4 digits and not weak
    public static boolean isValidPin(String pin) {
        if (!pin.matches("\\d{4}")) return false;  // Must be exactly 4 digits

        // Check for common weak patterns
        return !(
                pin.equals("1234") ||
                        pin.equals("0000") ||
                        pin.equals("1111") ||
                        pin.matches("(\\d)\\1{3}")  // e.g., 2222, 9999
        );
    }

    // 🔐 Hash PIN using SHA-256
    public static String hashPin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }

    // 🔎 Check entered PIN against stored hash
    public static boolean checkPin(String enteredPin) {
        String hashedInput = hashPin(enteredPin);
        return hashedInput.equals(storedPinHash);
    }
}
