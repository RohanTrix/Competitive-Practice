package Leetcode.Miscellaneous;

public class HTML_Entity_Parser {
    public String entityParser(String text) {
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&frasl;", "/");
        text = text.replaceAll("&amp;", "&");
        return text;
    }
}
