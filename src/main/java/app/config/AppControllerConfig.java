package app.config;

import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;

import app.controllers.CatchAllFilter;

public class AppControllerConfig extends AbstractControllerConfig {

  public void init(AppContext context) {
    add(new CatchAllFilter());
//    add(new DBConnectionFilter());
  }
}
