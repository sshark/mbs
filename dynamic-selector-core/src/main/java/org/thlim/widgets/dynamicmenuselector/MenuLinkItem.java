package org.thlim.widgets.dynamicmenuselector;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 2/1/12
 * Time: 2:30 PM
 *
 */
abstract public class MenuLinkItem implements Serializable
{
    private String name;

    abstract protected void execute(AjaxRequestTarget target);

    public MenuLinkItem(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
