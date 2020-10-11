package com.aem.community.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Name {
    @Inject
    @Optional
    private String name;
    private String formattedName;

    @PostConstruct
    private void initModel()
    {
        this.formattedName = Character.toUpperCase(this.name.charAt(0))+this.name.substring(1);
    }

    public String getFormattedName() {
        return formattedName;
    }
}
