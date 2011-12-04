package org.thlim.demo;

import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.accordion.Accordion;
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
        Accordion catalog = new Accordion("catalog");
        add(catalog);

        ContextMenu menu = ContextMenu.forClass("contextMenu");
        ContextMenuOptions options = menu.getOptions();
        options.setTrigger(ContextMenuOptions.Trigger.HOVER);
        options.setAutoHide();
        options.add(new ContextMenuItem("view",
            "View all group links",
            new JsStatement().append(" $('#' + opt.$trigger[0].id + '_menuitems').children('a').each(function() { window.open($(this).attr('href'))});")));
        options.add(new ContextMenuItem("edit",
            "View all links",
            new JsStatement().append("$(\"div[id$='_menuitems']\").children('a').each(function() {window.open($(this).attr('href'))})")));
        catalog.add(menu);

    }
}
