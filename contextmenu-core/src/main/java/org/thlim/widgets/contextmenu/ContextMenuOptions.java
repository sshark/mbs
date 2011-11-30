package org.thlim.widgets.contextmenu;

import org.odlabs.wiquery.core.options.ListItemOptions;
import org.odlabs.wiquery.core.options.Options;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/30/11
 * Time: 3:48 PM
 *
 */
public class ContextMenuOptions
{
    private Options options = new Options();

    static public enum Trigger
    {
        HOVER("hover"),
        LEFT("left"),
        RIGHT("right");

        private final String value;

        Trigger(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return value;
        }
    }

    public ContextMenuOptions(String selector)
    {
        options.put("selector", singleQuote(selector));
    }

    public ContextMenuOptions setAutoHide()
    {
        options.put("autoHide", true);
        return this;
    }

    public ContextMenuOptions removeAutoHide()
    {
        options.put("autoHide", false);
        return this;
    }

    public CharSequence getJavaScriptOptions()
    {
        return options.getJavaScriptOptions();
    }

    public ContextMenuOptions setTrigger(Trigger trigger)
    {
        options.put("trigger", singleQuote(trigger.toString()));
        return this;
    }

    private String singleQuote(String value)
    {
        return "'" + value + "'";
    }
    public ContextMenuOptions add(ContextMenuItem menuItem)
    {
        ListItemOptions menuItems = (ListItemOptions) options.getListItemOptions("items");
        if (menuItems == null)
        {
            menuItems = new ListItemOptions<ContextMenuItem>();
        }
        menuItems.add(menuItem);
        options.put("items", menuItems);
        return this;
    }
}
