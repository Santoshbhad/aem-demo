package com.aem.community.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;


@SlingServlet(paths="/bin/slingmodel", methods="GET")
public class SlingModels extends SlingSafeMethodsServlet {

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().print("this is response of the servlet get Model");

    }
}