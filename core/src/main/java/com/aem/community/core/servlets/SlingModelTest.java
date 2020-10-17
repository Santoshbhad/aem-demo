package com.aem.community.core.servlets;

import com.aem.community.core.models.UserModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;

/**
 * @author Anirudh Sharma
 *
 * Servlet to consume the Sling Model
 */
/* PATH METHOD */
@Component(service = Servlet.class,
        property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/test" })

/* RESOURCE TYPE METHOD
@Component(service = Servlet.class,
        property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.resourceTypes=" + "AEMMaven13/components/structure/page",
        "sling.servlet.selectors ="  +"sample"
})
*/

public class SlingModelTest extends SlingSafeMethodsServlet {

    /**
     * Generated serialVersionUID
     */



    private static final long serialVersionUID = 7558680464517017317L;

    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(SlingModelTest.class);

    /**
     * Overridden method
     */
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {

            log.info("----------< Processing starts >----------");

            /**
             * Getting the instance of resource resolver
             */

            final JSONObject jsonObject = new JSONObject();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ResourceResolver resourceResolver = request.getResourceResolver();

            /*
             * Getting the resource which has the data stored
            */
            Resource resource = resourceResolver
                    .getResource("/content/AEMMaven13/en/jcr:content/root/responsivegrid/modaltest");

            /**
             * Adapting the resource to the UserModel class
             */
            UserModel model = resource.adaptTo(UserModel.class);

            /**


            response.getWriter()
                    .print("This is test servlet " );
             */
            /* SENDING RESPONSE AS JSON */
            jsonObject.put("success", model.getFirstName());
            jsonObject.put("surname", model.getLastName());
            jsonObject.put("list", model.ret());
            jsonObject.put("map ", model.mapRet());
            jsonObject.put("request ", request.getRequestURL());


            response.getWriter().write(jsonObject.toString());
            response.setStatus(SlingHttpServletResponse.SC_OK);

            /**
             * Closing the resource resolver
             */
            resourceResolver.close();

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }

    }

}
