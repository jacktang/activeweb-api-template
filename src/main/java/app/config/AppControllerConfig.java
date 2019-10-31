package app.config;

import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;

import app.controllers.CatchAllFilter;
import app.controllers.VersionController;

public class AppControllerConfig extends AbstractControllerConfig {

  public void init(AppContext context) {
    add(new CatchAllFilter());
    add(new DBConnectionFilter()).to(VersionController.class);
  }
}
