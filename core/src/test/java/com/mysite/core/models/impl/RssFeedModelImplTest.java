package com.mysite.core.models.impl;

import com.mysite.core.services.FeedFetchService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class RssFeedModelImplTest {

    private final AemContext aemContext = new AemContext();
    private RssFeedModelImpl rssFeedModel;

    @Mock FeedFetchService feedFetchService;

    @BeforeEach void setUp() {
        aemContext.addModelsForClasses(RssFeedModelImpl.class);
        aemContext.load().json("/com/mysite/core/models/impl/rssfeed.json", "/content");
        aemContext.currentResource("/content");
        feedFetchService = aemContext.registerService(FeedFetchService.class, feedFetchService);
        rssFeedModel = aemContext.request().adaptTo(RssFeedModelImpl.class);
    }

    @Test void getExportedType() {
        assertEquals(RssFeedModelImpl.RESOURCE_TYPE, rssFeedModel.getExportedType());
    }

    @Test void getFeedData() {
        assertEquals(3, rssFeedModel.getFeedData().size());
    }
}
