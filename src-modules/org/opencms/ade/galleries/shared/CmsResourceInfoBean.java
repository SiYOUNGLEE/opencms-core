/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/galleries/shared/Attic/CmsResourceInfoBean.java,v $
 * Date   : $Date: 2010/07/05 14:48:07 $
 * Version: $Revision: 1.2 $
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

package org.opencms.ade.galleries.shared;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This bean contains the preview content for the selected item.<p>
 * 
 * @author Polina Smagina
 * 
 * @version $Revision: 1.2 $ 
 * 
 * @since 8.0.0
 */
public class CmsResourceInfoBean implements IsSerializable {

    /** The description of the resource. */
    private String m_description;

    /** The last modification date. */
    private Date m_lastModified;

    /** The main properties. */
    private Map<String, String> m_properties;

    /** The path to the selected resource. */
    private String m_resourcePath;

    /** The resource type name. */
    private String m_resourceType;

    /** The file size. */
    private String m_size;

    /** The title of the resource. */
    private String m_title;

    /**
     * The constructor.<p>
     */
    public CmsResourceInfoBean() {

        m_properties = new LinkedHashMap<String, String>();
    }

    /**
     * Returns the description of the resource.<p>
     *
     * @return the description
     */
    public String getDescription() {

        return m_description;
    }

    /**
     * Returns the last modification date.<p>
     *
     * @return the last modification date
     */
    public Date getLastModified() {

        return m_lastModified;
    }

    /**
     * Returns the properties.<p>
     *
     * @return the properties
     */
    public Map<String, String> getProperties() {

        return m_properties;
    }

    /**
     * Returns the resource path.<p>
     *
     * @return the resource path
     */
    public String getResourcePath() {

        return m_resourcePath;
    }

    /**
     * Returns the resource type name.<p>
     *
     * @return the resource type name
     */
    public String getResourceType() {

        return m_resourceType;
    }

    /**
     * Returns the file size.<p>
     *
     * @return the file size
     */
    public String getSize() {

        return m_size;
    }

    /**
     * Returns the title of the resource.<p>
     *
     * @return the title
     */
    public String getTitle() {

        return m_title;
    }

    /**
     * Sets the description of the resource.<p>
     *
     * @param description the description to set
     */
    public void setDescription(String description) {

        m_description = description;
    }

    /**
     * Sets the last modification date.<p>
     *
     * @param lastModified the last modification date to set
     */
    public void setLastModified(Date lastModified) {

        m_lastModified = lastModified;
    }

    /**
     * Sets the propeties.<p>
     *
     * @param propeties the propeties to set
     */
    public void setProperties(Map<String, String> propeties) {

        m_properties = propeties;
    }

    /**
     * Sets the resource path.<p>
     *
     * @param resourcePath the resource path to set
     */
    public void setResourcePath(String resourcePath) {

        m_resourcePath = resourcePath;
    }

    /**
     * Sets the resource type name.<p>
     *
     * @param resourceType the resource type name to set
     */
    public void setResourceType(String resourceType) {

        m_resourceType = resourceType;
    }

    /**
     * Sets the file size.<p>
     *
     * @param size the file size to set
     */
    public void setSize(String size) {

        m_size = size;
    }

    /**
     * Sets the title of the resource.<p>
     *
     * @param title the title to set
     */
    public void setTitle(String title) {

        m_title = title;
    }
}