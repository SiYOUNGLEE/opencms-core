/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/containerpage/client/ui/Attic/A_CmsToolbarMenu.java,v $
 * Date   : $Date: 2010/05/31 09:15:22 $
 * Version: $Revision: 1.9 $
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

package org.opencms.ade.containerpage.client.ui;

import org.opencms.ade.containerpage.client.CmsContainerpageHandler;
import org.opencms.gwt.client.ui.CmsMenuButton;
import org.opencms.gwt.client.ui.I_CmsButton;

/**
 * Abstract button class implementing common methods of {@link org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton} 
 * for all container-page tool-bar menu buttons.<p>
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.9 $
 * 
 * @since 8.0.0
 */
public abstract class A_CmsToolbarMenu extends CmsMenuButton implements I_CmsToolbarButton {

    private CmsContainerpageHandler m_handler;

    /** The CSS class responsible for displaying the proper icon. */
    private String m_iconClass;

    /**
     * Constructor.<p>
     * 
     * @param buttonData the tool-bar button data
     * @param handler the container-page handler
     */
    public A_CmsToolbarMenu(I_CmsButton.ButtonData buttonData, CmsContainerpageHandler handler) {

        super(buttonData.getTitle(), buttonData.getIconClass());
        m_handler = handler;
        setTitle(buttonData.getTitle());
        m_iconClass = buttonData.getIconClass();
    }

    /**
     * @see org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton#getIconClass()
     */
    public String getIconClass() {

        return m_iconClass;
    }

    /**
     * @see org.opencms.gwt.client.ui.CmsMenuButton#hideMenu()
     */
    @Override
    public void hideMenu() {

        super.hideMenu();
    }

    /**
     * @see org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton#isActive()
     */
    public boolean isActive() {

        return isOpen();
    }

    /**
     * @see org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton#onToolbarClick()
     */
    public void onToolbarClick() {

        boolean active = isActive();

        setActive(!active);

    }

    /**
     * @see org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton#setActive(boolean)
     */
    public void setActive(boolean active) {

        if (active) {
            m_handler.deactivateCurrentButton();
            m_handler.setActiveButton(this);
            onToolbarActivate();
            openMenu();

        } else {
            onToolbarDeactivate();
            closeMenu();
            m_handler.setActiveButton(null);
            m_handler.activateSelection();
        }
    }

    /**
     * @see org.opencms.ade.containerpage.client.ui.I_CmsToolbarButton#setButtonEnabled(boolean)
     */
    public void setButtonEnabled(boolean enabled) {

        setEnabled(true);
    }

    /**
     * @see org.opencms.gwt.client.ui.CmsMenuButton#autoClose()
     */
    @Override
    protected void autoClose() {

        super.autoClose();
        onToolbarDeactivate();
        m_handler.setActiveButton(null);
        m_handler.activateSelection();
    }

    /**
     * Returns the container-page handler.<p>
     * 
     * @return the container-page handler
     */
    protected CmsContainerpageHandler getHandler() {

        return m_handler;
    }
}
