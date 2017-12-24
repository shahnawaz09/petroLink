package com.petrolink.app;

import com.petrolink.app.api.PetrolinkResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Launcher extends Application<LauncherConfiguration> {

    public static void main(String[] args) throws Exception {
        new Launcher().run(args);
    }

    @Override
    public String getName() {
        return "hello-world-application";
    }

    @Override
    public void initialize(Bootstrap<LauncherConfiguration> bootstrap) {
        //Before running the app, this method is used
        //For adding bundles, adding configurations
    }

    @Override
    public void run(LauncherConfiguration configuration, Environment environment) {

        final PetrolinkResource resource = new PetrolinkResource();
        environment.jersey().register(resource);
    }
}
