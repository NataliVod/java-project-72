package hexlet.code.util;

import org.jsoup.nodes.Element;

public  class parseUtils {
    public static String getEmptyIfNull(Element element) {
        String result = (element != null) ? element.toString() : "";
        return result;
    }
}
