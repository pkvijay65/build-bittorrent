import com.google.gson.Gson;
import com.dampcake.bencode.Bencode;

public class Main {
  private static final BencodeDecoder DECODER = new BencodeDecoder();
  private static final Gson gson = new Gson();

  public static void main(String[] args) throws Exception {
    String command = args[0];
    if ("decode".equals(command)) {
      String bencodedValue = args[1];
      Object decode = DECODER.decode(bencodedValue);
      System.out.println(gson.toJson(decode));
    }

  }
}
