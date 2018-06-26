package unesp.rc.creditloan.utils;

/**
 * Classe que contém os utilitários do cálculo do limite de crédito utilizado
 * na regra de negócio
 */
public class CreditLoanUtil {

    public static boolean numberIsBetween(int number, int begin, int end) {

        if (number >= begin && number <= end) {
            return true;
        }

        return false;
    }

    public static boolean isEnumeratedIn(Object object, String text) {

        if (object == null || text == null || text.equals("")) {
            return false;
        }

        for (String value : text.split(",")) {
            if (object.toString().trim().toLowerCase().equals(value.trim().toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
