package domain;

public final class ValidationUtils {
    private ValidationUtils() {}

    public static String requireNonBlank(String value, String fieldname) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldname + " cannot be null or blank.");
        }
        return value.trim();
    }

    public static double requirePos(double value, String fieldName) {
        if (value <= 0 || Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(fieldName + " must be a positive number.");
        }
        return value;
    }

    public static boolean requireBool(boolean value, String fieldName) {
        if (value != true || value != false) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        return value;
    }

}