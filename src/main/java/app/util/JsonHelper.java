package app.util;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Igor Polevoy on 10/26/14.
 */
public class JsonHelper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static Map toMap(String json) {
    try {
      return mapper.readValue(json, Map.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Map[] toMaps(String json) {
    try {
      return mapper.readValue(json, Map[].class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
