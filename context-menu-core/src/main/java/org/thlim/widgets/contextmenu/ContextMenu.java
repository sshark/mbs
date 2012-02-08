package org.thlim.widgets.contextmenu;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/4/11
 * Time: 3:25 PM
 *
 */

@WiQueryUIPlugin
public class ContextMenu extends WiQueryAbstractBehavior
{
    private ContextMenuOptions options;

    @Override
    public JsStatement statement()
    {
        return new JsStatement().$().chain("contextMenu", options.getJavaScriptOptions());
    }

    public ContextMenu(String selector) {
        this(selector, ContextMenuOptions.Trigger.RIGHT);
    }

    public ContextMenu(String selector, ContextMenuOptions.Trigger trigger)
    {
        options = new ContextMenuOptions(selector);
        options.setTrigger(trigger);
    }

    public ContextMenu(ContextMenuOptions options)
    {
        this.options = options;
    }

    public ContextMenuOptions getOptions()
    {
        return options;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response)
    {
        response.renderJavaScriptReference(new PackageResourceReference(getClass(), "js/jquery.ui.position.js"));
        response.renderJavaScriptReference(new PackageResourceReference(getClass(), "js/jquery.contextMenu.js"));
        response.renderCSSReference(new CssResourceReference(getClass(), "css/jquery.contextMenu.css"));
    }

    public static ContextMenu forClass(String selector)
    {
        return new ContextMenu("." + selector);
    }

    public static ContextMenu forId(String selector)
    {
        return new ContextMenu("#" + selector);
    }
}
