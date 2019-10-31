package app.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.javalite.activeweb.AppController;

import app.util.JsonHelper;

/**
 * @author Jack Tang
 */
public class APIController extends AppController {

  public void version() {
    Map<String, String> props = readGitProperties();
    String gitBranch = props.get("git.branch");
    String gitBuildVersion = props.get("git.build.version");
    String gitCommitAbbrev = props.get("git.commit.id.abbrev");
    view("git_branch", gitBranch, "git_build_version", gitBuildVersion, "git_commit_abbrev", gitCommitAbbrev);
    renderOk("current version info", "/api/version");
  }

  public void ping() {
    view("echo", "pong");
    renderOk("hb", "/api/ping");
  }

  @Override
  protected String getContentType() {
    return "application/json";
  }

  @Override
  protected String getLayout() {
    return "/layouts/api_layout";
  }

  protected void renderOk() {
    view("success", true);
    render();
  }

  protected void renderOk(String msg, String view) {
    view("success", true, "message", msg);
    render(view);
  }

  protected void renderErr(String code, String msg) {
    view("success", false, "message", msg, "code", code);
    render("/commons/error");
  }

  private Map<String, String> readGitProperties() {
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("git.properties");
    try {
      String json = readFromInputStream(inputStream);
      inputStream.close();

      return JsonHelper.toMap(json);
    } catch (IOException e) {
      logError(e.getMessage(), e);
      return null;
    }
  }

  private String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
    }
    return sb.toString();
  }
}
