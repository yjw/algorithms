public class BinaryRepresentation {
    public String binaryRepresentation(String n) {
        if (n == null || n.length() < 1) {
            return null;
        }
        String[] array = n.split(".");
        if (array.length > 2) {
            return "ERROR";
        }
        if (array.length < 2) {
            return itob(Integer.parseInt(n));
        }
        String left = array[0];
        String right = array[1];
        if (right.charAt(right.length() - 1) != '5') {
            return "ERROR";
        }
        return "ERROR";
    }
    
    private String itob (int x) {
        return Integer.toBinaryString(x);
    }
}
