
import java.io.IOException;


public class Main {

    // call the scanner
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner("input.txt");
            Token token = scanner.readNextToken();
            while (token != null) {
                System.out.println(token.getType() + " " + token.getValue() );
                token = scanner.readNextToken();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}  
        
        
    

