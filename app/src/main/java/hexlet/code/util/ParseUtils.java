package hexlet.code.util;

import org.jsoup.nodes.Element;

public  class ParseUtils {
    public static String getEmptyIfNull(Element element) {
        return (element != null) ? element.toString() : "";
    }

    public static String getEmptyIfNull(String string) {
        return (string != null) ? string : "";
    }
}
