package demo;

public class DemoCreatingStrings {
    public static void main(String[] args) {
        // Sample int and double values
        int intValue = 42;
        double doubleValue = 3.14159;
        
        System.out.println("=== Creating Strings from int and double types ===\n");
        
        // Method 1: String concatenation with the + operator
        System.out.println("1. String concatenation with + operator:");
        String str1 = "The integer value is: " + intValue;
        String str2 = "The double value is: " + doubleValue;
        String str3 = "Combined: " + intValue + " and " + doubleValue;
        
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println();
        
        // Method 2: Using String.valueOf() for explicit conversion
        System.out.println("2. Using String.valueOf() for explicit conversion:");
        String str4 = String.valueOf(intValue);
        String str5 = String.valueOf(doubleValue);
        String str6 = "Values: " + String.valueOf(intValue) + ", " + String.valueOf(doubleValue);
        
        System.out.println("Int as string: '" + str4 + "'");
        System.out.println("Double as string: '" + str5 + "'");
        System.out.println(str6);
        System.out.println();
        
        // Method 3: Using Integer.toString() and Double.toString()
        System.out.println("3. Using wrapper class toString() methods:");
        String str7 = Integer.toString(intValue);
        String str8 = Double.toString(doubleValue);
        String str9 = "Using toString(): " + Integer.toString(intValue) + " & " + Double.toString(doubleValue);
        
        System.out.println("Int using Integer.toString(): '" + str7 + "'");
        System.out.println("Double using Double.toString(): '" + str8 + "'");
        System.out.println(str9);
        System.out.println();
        
        // Method 4: Using String.format() for formatted strings
        // System.out.println("4. Using String.format() for formatted output:");
        // String str10 = String.format("Integer: %d, Double: %.2f", intValue, doubleValue);
        // String str11 = String.format("Scientific notation: %e", doubleValue);
        // String str12 = String.format("Padded integer: %05d", intValue);
        
        // System.out.println(str10);
        // System.out.println(str11);
        // System.out.println(str12);
        // System.out.println();
        
        // Method 5: Using StringBuilder for efficient concatenation
        // System.out.println("5. Using StringBuilder for efficient concatenation:");
        // StringBuilder sb = new StringBuilder();
        // sb.append("Building string: ");
        // sb.append(intValue);
        // sb.append(" + ");
        // sb.append(doubleValue);
        // sb.append(" = ");
        // sb.append(intValue + doubleValue);
        // String str13 = sb.toString();
        
        // System.out.println(str13);
        // System.out.println();
        
        // Method 6: Demonstrating type precedence in concatenation
        System.out.println("6. Type precedence in concatenation:");
        String str14 = intValue + doubleValue + " is the sum";  // Addition first, then concatenation
        String str15 = "The sum is " + intValue + doubleValue;  // Concatenation from left to right
        String str16 = "The sum is " + (intValue + doubleValue); // Parentheses force addition first
        
        System.out.println("Addition first: " + str14);
        System.out.println("Left to right concatenation: " + str15);
        System.out.println("Parentheses force addition: " + str16);
        System.out.println();
        
        // Method 7: Using DecimalFormat for custom double formatting
        // System.out.println("7. Custom formatting with DecimalFormat:");
        // java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        // String str17 = "Formatted double: " + df.format(doubleValue);
        
        // System.out.println(str17);
        // System.out.println();
        
        // Method 8: Converting to different number bases (for integers)
        // System.out.println("8. Converting integers to different bases:");
        // String str18 = "Binary: " + Integer.toBinaryString(intValue);
        // String str19 = "Octal: " + Integer.toOctalString(intValue);
        // String str20 = "Hexadecimal: " + Integer.toHexString(intValue);
        
        // System.out.println(str18);
        // System.out.println(str19);
        // System.out.println(str20);

    }
}
