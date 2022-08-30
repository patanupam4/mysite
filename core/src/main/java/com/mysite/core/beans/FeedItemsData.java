package com.mysite.core.beans;

import org.apache.commons.lang3.StringUtils;

public class FeedItemsData {



    /** The style. */
    private String style;

    /** The property. */
    private String property;

    /** The url. */
    private String url;

    /** The has url. */
    private boolean hasUrl;

    /**
     * Instantiates a new feed items data.
     */
    public FeedItemsData() {

    }

    /**
     * Instantiates a new feed items data.
     *
     * @param style the style
     * @param property the property
     * @param url the url
     */
    public FeedItemsData(String style,String property,String url) {
        this.style = style;
        this.property = property;
        this.url = url;
        this.hasUrl = StringUtils.isNoneBlank(url);
    }

    /**
     * Gets the style.
     *
     * @return the style
     */
    public String getStyle() {
        return style;
    }

    /**
     * Gets the property.
     *
     * @return the property
     */
    public String getProperty() {
        return property;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Checks if is checks for url.
     *
     * @return true, if is checks for url
     */
    public boolean isHasUrl() {
        return hasUrl;
    }


}
