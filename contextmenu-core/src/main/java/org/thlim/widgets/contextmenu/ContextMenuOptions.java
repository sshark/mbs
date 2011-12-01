package org.thlim.widgets.contextmenu;

import java.io.Serializable;

import org.odlabs.wiquery.core.javascript.JsUtils;
import org.odlabs.wiquery.core.options.ICollectionItemOptions;
import org.odlabs.wiquery.core.options.ListItemOptions;
import org.odlabs.wiquery.core.options.Options;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/30/11
 * Time: 3:48 PM
 *
 * events, position and determinePosition options are not implemented. Will implemented if needed.
 *
 */
public class ContextMenuOptions implements Serializable
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
        options.put("selector", JsUtils.quotes(selector));
    }

    public ContextMenuOptions appendTo(String domElement)
    {
        options.put("appendTo", domElement);
        return this;
    }

    public ContextMenuOptions setAutoHide()
    {
        options.put("autoHide", true);
        return this;
    }

    public ContextMenuOptions ignoreRightClick(boolean ignore)
    {
        options.put("ignoreRightClick", ignore);
        return this;
    }

    public ContextMenuOptions delay(int timeInMillis)
    {
        options.put("delay", timeInMillis);
        return this;
    }

    public ContextMenuOptions zIndex(int index)
    {
        options.put("zIndex", index);
        return this;
    }

    public ContextMenuOptions additionalClassName(String className)
    {
        options.put("className", className);
        return this;
    }

    public ContextMenuOptions animation(ICollectionItemOptions animationOptions)
    {
        options.put("animation", animationOptions);
        return this;
    }

    public ContextMenuOptions removeAutoHide()
    {
        options.put("autoHide", false);
        return this;
    }

    /**
     * Get options set for context menu.
     *
     * @return JSON formatted options
     */
    public CharSequence getJavaScriptOptions()
    {
        return options.getJavaScriptOptions();
    }

    public ContextMenuOptions setTrigger(Trigger trigger)
    {
        options.put("trigger", JsUtils.quotes(trigger.toString()));
        return this;
    }

    /**
     * Add menu item and action to the context menu
     * @param menuItem menu key, name and action
     * @return this options for chaining purpose
     */
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
