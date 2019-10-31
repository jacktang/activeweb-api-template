package app.controllers;

import java.util.Map;

import org.javalite.activeweb.AppIntegrationSpec;
import org.javalite.common.Util;
import org.junit.Test;

import app.util.JsonHelper;

/**
 * @author Igor Polevoy on 10/28/14.
 */
public class CatchAllFilterSpec extends AppIntegrationSpec {

  @Test
  public void shouldReturnErrorMessageIfPersonNotFound() {
    // lets ask for a person with ID that does not exist:
    controller("people").id("blah").integrateViews().get("show");
    Map response = JsonHelper.toMap(responseContent());
    a(response.get("code")).shouldBeEqual(500);
    a(response.get("message")).shouldBeEqual("could not find person with id: blah");
  }

  @Test
  public void shouldReturnErrorMessageIfBadJSONPosted() {

    String json = Util.readResource("/bad.json");
    controller("people").content(json.getBytes()).contentType("application/json").integrateViews().post("create");
    Map response = JsonHelper.toMap(responseContent());
    a(response.get("code")).shouldBeEqual(500);
    a(response.get("message")).shouldBeEqual("malformed JSON format");
  }
}
