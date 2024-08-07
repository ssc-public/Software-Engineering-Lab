package MiniJava.scanner;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;
import MiniJava.scanner.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexicalAnalyzer {
    private Matcher matcher;

    public lexicalAnalyzer(java.util.Scanner sc) {
        StringBuilder input = new StringBuilder();
        while (sc.hasNext()) {
            input.append(sc.nextLine());
        }
        StringBuilder tokenPattern = new StringBuilder();
        for (Type tokenType : Type.values())
            tokenPattern.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        Pattern expression = Pattern.compile(tokenPattern.substring(1));
        matcher = expression.matcher(input.toString());
    }

    public Token getNextToken() {

        while (matcher.find()) {
            for (Type t : Type.values()) {

                if (matcher.group(t.name()) != null) {
                    if (matcher.group(Type.COMMENT.name()) != null) {
                        break;

                    }
                    if (matcher.group(Type.ErrorID.name()) != null) {
                        ErrorHandler.printError("The id must start with character");
                        break;
                    }

                    return new Token(t, matcher.group(t.name()));
                }
            }
        }
        return new Token(Type.EOF, "$");
    }
}
