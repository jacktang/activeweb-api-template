package app.config;

import org.javalite.activeweb.AbstractRouteConfig;
import org.javalite.activeweb.AppContext;

import app.controllers.APIController;

public class RouteConfig extends AbstractRouteConfig {
  public void init(AppContext appContext) {
    //@formatter:off
    route("/api/ping").to(APIController.class).get().action("ping");
    route("/api/version").to(APIController.class).get().action("version");
    //@formatter:on
  }
}
