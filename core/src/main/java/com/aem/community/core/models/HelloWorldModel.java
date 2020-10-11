/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.community.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import org.apache.sling.api.SlingHttpServletRequest;


@Model(adaptables={Resource.class, SlingHttpServletRequest.class})
public class HelloWorldModel {

    @Inject
    private SlingSettingsService settings;

    @Inject @Named("sling:resourceType") @Default(values="THIS IS DEFAULT is Default value  resourceType")
    protected String resourceType;


    @Inject  @Default(values="sdfsdfsadf")
    private String text;

    private String message;



    @PostConstruct
    protected void init() {
        message = "\t This is post construct Hello World! \n";
        message += "\tThis is instance this is post construct: " + settings.getSlingId() + "\n";
        message += "\tResource type is: " + resourceType + "\n";

    }

    public String getText() {
        return text;
    }


    @Inject
    private Page resourcePage;

    public Page getResourcePage() {
        return resourcePage;
    }

}
