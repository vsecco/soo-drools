package unesp.rc.creditloan.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class StringEncoder {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private StringEncoder() {
    }

    /**
     * Realiza a criptografia de senha através do BCryptPasswordEncoder do
     * SpringFramework
     *
     * @param term
     * @return
     */
    public static String encodeString(final String term) {
        return Objects.nonNull(term) ? passwordEncoder.encode(term) : null;
    }
}
