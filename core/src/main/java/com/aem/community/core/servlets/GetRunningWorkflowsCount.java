package com.aem.community.core.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.ServerException;
import java.util.Dictionary;

//DS Annotations
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.osgi.OsgiUtil;
import org.apache.sling.jcr.api.SlingRepository;

import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;

import org.osgi.framework.Constants;
import org.apache.sling.api.servlets.HttpConstants;

import org.osgi.service.component.ComponentContext;
import javax.jcr.Session;
import javax.jcr.Node;
import java.util.UUID;
import java.util.Set;

//import MBean API
import javax.management.MBeanServerConnection;
import javax.management.MBeanServer ;
import java.lang.management.ManagementFactory ;
import javax.management.ObjectName;


@Component(service=Servlet.class,
        property={
                Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.resourceTypes="+ "AEMMaven13/components/structure/page",
                "sling.servlet.selectors=" + "en.html"
        })
public class GetRunningWorkflowsCount extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
    private static final long serialVersionUID = 2598426539166789515L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

        try
        {

            //Create a MBeanServer class
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();

            ObjectName workflowMBean = getWorkflowMBean(server);

            //Get the number of stale workflowitems from AEM
            Object staleWorkflowCount = server.invoke(workflowMBean, "countRunningWorkflows", new Object[]{null}, new String[] {String.class.getName()});

            int mystaleCount = (Integer)staleWorkflowCount;

            //Return the number of stale items
            response.getWriter().write("There are "+mystaleCount +"  running workflows");

            // response.getWriter().write("The Servlet works");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static ObjectName getWorkflowMBean(MBeanServerConnection server)
    {
        try
        {
            Set<ObjectName> names = server.queryNames(new ObjectName("com.adobe.granite.workflow:type=Maintenance,*"), null);

            if (names.isEmpty()) {
                return null;
            }

            return names.iterator().next();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


}