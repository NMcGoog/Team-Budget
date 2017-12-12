/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibas;

import java.text.Normalizer;
import static org.apache.commons.lang3.StringEscapeUtils.ESCAPE_HTML4;

/**
 *
 * @author Greg
 */
public class SecurityUtil {
    
    // Normalize input to a standard charset
    // Using NFKC: Compatibility Decomposition, followed by Canonical Composition
    public static String normalize(String input) {
        String normalized_input = Normalizer.normalize(input, Normalizer.Form.NFKC);
        return normalized_input;
    }
    
    // Using Apache Commons StringEscapeUtils to strip HTML characters
    public static String sanitize(String input) {
        String sanitized_input = ESCAPE_HTML4.translate(normalize(input));
        return sanitized_input;
    }
    
    
    
}
