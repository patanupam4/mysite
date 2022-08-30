package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Date;

/**
 * The Class RssFeedBeanModel.
 */
@Model(adaptables = {Resource.class} ,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RssFeedBeanModel {
	
	/** The feed property. */
	@ValueMapValue
	private String feedTitle;
	
	/** The property url. */
	@ValueMapValue
	private String feedDescription;
	
	/** The style. */
	@ValueMapValue
	private Date updatedDate;

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public String getFeedDescription() {
		return feedDescription;
	}

	public void setFeedDescription(String feedDescription) {
		this.feedDescription = feedDescription;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
