import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;



public class Scanner {
    private BufferedReader reader;
    private String extraCharRead;
    private final List<String> reservedIdentifiers = Arrays
      .asList(new String[] { "let", "in", "within", "fn", "where", "aug", "or",
          "not", "gr", "ge", "ls", "le", "eq", "ne", "true",
          "false", "nil", "dummy", "rec", "and" });

    public Token readNextToken(){
        Token nextToken  = null;
        String nextChar;
        if (extraCharRead != null) {
            nextChar = extraCharRead;
            extraCharRead = null;
          } else
            nextChar = readNextChar();
          if (nextChar != null)
            nextToken = buildToken(nextChar);
          return nextToken;
    }

    private String readNextChar() {
        String nextChar = null;
        try {
          int c = buffer.read();
          if (c != -1) {
            nextChar = Character.toString((char) c);
          } else
            buffer.close();
        } catch (IOException e) {
        }
        return nextChar;
      }

      private Token buildToken(String currentChar) {
        Token nextToken = null;
        if (LexRegex.LetterPattern.matcher(currentChar).matches()) {
          nextToken = buildIdentifierToken(currentChar);
        } else if (LexRegex.DigitPattern.matcher(currentChar).matches()) {
          nextToken = buildIntegerToken(currentChar);
        } else if (LexRegex.OpSymbolPattern.matcher(currentChar).matches()) { 
          nextToken = buildOperatorToken(currentChar);
        } else if (currentChar.equals("\'")) {
          nextToken = buildStringToken(currentChar);
        } else if (LexRegex.SpacePattern.matcher(currentChar).matches()) {
          nextToken = buildSpaceToken(currentChar);
        } else if (LexRegex.PunctuationPattern.matcher(currentChar).matches()) {
          nextToken = buildPunctuationPattern(currentChar);
        }
        return nextToken;
      }

      



    
}
