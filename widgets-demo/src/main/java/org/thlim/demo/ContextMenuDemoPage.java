package org.thlim.demo;

import org.apache.wicket.markup.html.WebPage;
import org.thlim.widgets.contextmenu.ContextMenu;
import org.thlim.widgets.contextmenu.ContextMenuItem;
import org.thlim.widgets.contextmenu.ContextMenuOptions;

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
        ContextMenu menu = ContextMenu.forClass("contextMenu");
        ContextMenuOptions options = menu.getOptions();
        options.add(new ContextMenuItem("view", "View dashboard"));
        add(menu);
    }
}
