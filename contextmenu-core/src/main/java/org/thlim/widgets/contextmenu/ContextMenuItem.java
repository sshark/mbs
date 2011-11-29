package org.thlim.widgets.contextmenu;

import org.apache.wicket.ajax.markup.html.AjaxLink;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/8/11
 * Time: 4:59 PM
 *
 */
public class ContextMenuItem
{
    private String key;
    private String name;
    private AjaxLink callback;

    public ContextMenuItem(String key, String name)
    {
        this.key = key;
        this.name = name;
    }

    public AjaxLink getCallback()
    {
        return callback;
    }

    public void setCallback(AjaxLink callback)
    {
        this.callback = callback;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
