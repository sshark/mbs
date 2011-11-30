package org.thlim.widgets.contextmenu;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.odlabs.wiquery.core.options.IListItemOption;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/8/11
 * Time: 4:59 PM
 *
 */
public class ContextMenuItem implements IListItemOption
{
    private String key;
    private String name;
    private AjaxLink callback;

    public ContextMenuItem(String key, String name)
    {
        this.key = key;
        this.name = name;
    }

    public CharSequence getJavascriptOption()
    {
        StringBuilder buffer = new StringBuilder(key).append(":{")
            .append("name:'").append(name).append("',")
            .append("callback:function(key,opt){window.location='http://www.ibm.com'}")
            .append("}");
        return buffer.toString();
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
