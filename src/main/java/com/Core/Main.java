package com.Core;


import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

import javax.xml.namespace.QName;


public class Main {

    public static void main(String[] args) throws Exception {

        var webApp = new WebAppContext();
        webApp.setResourceBase("src/main/webapp");
        webApp.setContextPath("/");

        webApp.setConfigurations(new Configuration[]
                {
                        new AnnotationConfiguration(),
                        new WebInfConfiguration(),
                        new WebXmlConfiguration(),
                        new MetaInfConfiguration(),
                        new FragmentConfiguration(),
                        new EnvConfiguration(),
                        new PlusConfiguration(),
                        new JettyWebXmlConfiguration()
                });
        webApp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
//        webApp.addServlet(Servlett.class,"/api/*");


        var server = new Server(8080);
        server.setHandler(webApp);

        server.start();
        server.join();


    }

}
