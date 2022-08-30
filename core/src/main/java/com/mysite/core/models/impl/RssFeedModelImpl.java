package com.mysite.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.mysite.core.models.RssFeedBean;
import com.mysite.core.models.RssFeedModel;
import com.mysite.core.services.FeedFetchService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, adapters = { RssFeedModel.class,
        ComponentExporter.class }, resourceType = {
        RssFeedModelImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class RssFeedModelImpl implements RssFeedModel {

    @OSGiService private FeedFetchService feedFetchService;

    public static final String RESOURCE_TYPE = "mysite/components/content/rssfeed";

    @Override public String getExportedType() {
        return RESOURCE_TYPE;
    }

    /**
     * The options.
     */
    @ChildResource(name = "options") private List<RssFeedBean> options;

    /**
     * The count.
     */
    @ValueMapValue @Default(values = "0") private String count;

    /**
     * The feedpath.
     */
    @ValueMapValue private String feedPath;

    @Override public List<RssFeedBean> getFeedData() {
        if (!feedFetchService.getFeedData(feedPath, Integer.parseInt(count)).isEmpty()) {
            return feedFetchService.getFeedData(feedPath, Integer.parseInt(count));
        } else {
            return options;
        }
    }
}
