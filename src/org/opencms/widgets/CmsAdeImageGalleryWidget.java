/*
 * File   : $Source: /alkacon/cvs/opencms/src/org/opencms/widgets/CmsAdeImageGalleryWidget.java,v $
 * Date   : $Date: 2010/07/05 14:48:06 $
 * Version: $Revision: 1.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.widgets;

import org.opencms.file.CmsObject;
import org.opencms.file.types.CmsResourceTypeImage;
import org.opencms.json.JSONObject;
import org.opencms.main.OpenCms;

/**
 * ADE image gallery widget implementations.<p>
 *
 * @author Tobias Herrmann 
 * 
 * @version $Revision: 1.1 $ 
 * 
 * @since 8.0.0 
 */
public class CmsAdeImageGalleryWidget extends A_CmsAdeGalleryWidget {

    /** The gallery name. */
    private static final String GALLERY_NAME = "image";

    /**
     * Constructor.<p>
     */
    public CmsAdeImageGalleryWidget() {

        this("");
    }

    /**
     * Creates a new gallery widget with the given configuration.<p>
     * 
     * @param configuration the configuration to use
     */
    protected CmsAdeImageGalleryWidget(String configuration) {

        super(configuration);
    }

    /**
     * @see org.opencms.widgets.A_CmsAdeGalleryWidget#getGalleryName()
     */
    @Override
    public String getGalleryName() {

        return GALLERY_NAME;
    }

    /**
     * @see org.opencms.widgets.I_CmsWidget#newInstance()
     */
    public I_CmsWidget newInstance() {

        return new CmsAdeImageGalleryWidget(getConfiguration());
    }

    /**
     * @see org.opencms.widgets.A_CmsAdeGalleryWidget#getAdditionalGalleryInfo(org.opencms.file.CmsObject, org.opencms.widgets.I_CmsWidgetDialog, org.opencms.widgets.I_CmsWidgetParameter)
     */
    @Override
    protected JSONObject getAdditionalGalleryInfo(
        CmsObject cms,
        I_CmsWidgetDialog widgetDialog,
        I_CmsWidgetParameter param) {

        // no additional info needed
        return null;
    }

    /**
     * @see org.opencms.widgets.A_CmsAdeGalleryWidget#getGalleryTypes()
     */
    @Override
    protected String getGalleryTypes() {

        return CmsResourceTypeImage.getStaticTypeName();
    }

    /**
     * @see org.opencms.widgets.A_CmsAdeGalleryWidget#getOpenPreviewCall(java.lang.String)
     */
    @Override
    protected String getOpenPreviewCall(String id) {

        // using the 'cmsOptenImagePreview' function instead of 'cmsOpenPreview'
        StringBuffer sb = new StringBuffer(64);
        // using the 'cmsOptenImagePreview' function instead of 'cmsOpenPreview'
        sb.append("javascript:cmsOpenImagePreview('").append(Messages.GUI_BUTTON_PREVIEW_0);
        sb.append("', '").append(OpenCms.getSystemInfo().getOpenCmsContext());
        sb.append("', document.getElementById('").append(id);
        sb.append("').getAttribute('value')); return false;");
        return sb.toString();
    }
}
