package app.controllers;

import static org.javalite.common.Collections.map;

import org.codehaus.jackson.JsonParseException;
import org.javalite.activeweb.controller_filters.HttpSupportFilter;

/**
 * @author Igor Polevoy on 10/28/14.
 */
public class CatchAllFilter extends HttpSupportFilter {
  @Override
  public void onException(Exception e) {
    if (e.getCause() instanceof JsonParseException) {
      render("/commons/error", map("message", "malformed JSON format", "code", 500));
    } else {
      // this is an exception thrown from any controller on purpose.
      render("/commons/error", map("message", e.getMessage(), "code", 500));
    }
  }
}
