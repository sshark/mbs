package org.thlim.demo;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.thlim.widgets.contextmenu.ContextMenu;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/8/11
 * Time: 6:15 PM
 *
 */
public class ContextMenuDemoPage extends WebPage
{
    public ContextMenuDemoPage()
    {
        WebMarkupContainer contextMenu = new WebMarkupContainer("contextMenu");
        add(contextMenu.add(new ContextMenu()));
    }
}
