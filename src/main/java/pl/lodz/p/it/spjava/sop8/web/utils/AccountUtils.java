package pl.lodz.p.it.spjava.sop8.web.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 *
 */
public class AccountUtils {

    public static String calculateHashPassword(String passwordVisible) {
        String output
                = Hashing.sha256()
                .hashString(passwordVisible, Charsets.UTF_8).toString();
        return output;
    }
}
