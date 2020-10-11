package com.aem.community.core.models;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.ObservationManager;
import java.util.EventListener;

@Component(metatype =true)
@Service
public class EventManagerImple implements Runnable, EventListener, javax.jcr.observation.EventListener {

private Logger log = LoggerFactory.getLogger(this.getClass());
private BundleContext bundleContext;
 @Reference
 private SlingRepository repository;
 private ResourceResolverFactory resolverFactory;
 private Session session;
 private ObservationManager observationManager;



protected void
activate(ComponentContext ctx)
{
this.bundleContext = ctx.getBundleContext();
try
{
session = repository.loginAdministrative(null);
observationManager = session.getWorkspace().getObservationManager();
observationManager.addEventListener(this, Event.NODE_ADDED,"/content", true, null, null, false);
log.info("listining the event");
}catch (Exception e)
{
e.printStackTrace();
}

}

    @Override
    public void run() {
    log.info("Running");
    }


public void onEvent(EventIterator itr)
{
log.info("a new no  de is created");
}
}
