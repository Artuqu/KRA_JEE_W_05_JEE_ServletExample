package pl.coderslab.web.post;

public class Censor {
    private final static String[] SWEAR_WORDS = {"cholera", "kurde", "motyla noga", "kurza twarz"};

    public static String doCensor(String toCensor) {
        for(String swear : SWEAR_WORDS){
            toCensor = toCensor.replaceAll(swear, "*".repeat(swear.length()));
        }

        return toCensor;
    }
}
