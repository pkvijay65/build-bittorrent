import com.dampcake.bencode.Bencode;
import com.dampcake.bencode.Type;

public class BencodeDecoder {
    private static final Bencode DECODER = new Bencode();

    public Object decode(String bencodedString) {
        return DECODER.decode(bencodedString.getBytes(), getType(bencodedString));
    }

    private Type<?> getType(String bencodedString) {
        if (Character.isDigit(bencodedString.charAt(0))) {
            return Type.STRING;
        } else if (bencodedString.startsWith("i")) {
            return Type.NUMBER;
        } else if (bencodedString.startsWith("l")) {
            return Type.LIST;
        } else {
            throw new RuntimeException("Only strings are supported at the moment");
        }
    }
}
