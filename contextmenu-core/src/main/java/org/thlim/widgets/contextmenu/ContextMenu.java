package org.thlim.widgets.contextmenu;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/4/11
 * Time: 3:25 PM
 *
 */

public class ContextMenu extends WiQueryAbstractBehavior
{

    static public enum Trigger {
        HOVER("'hover'"),
        LEFT("'left'"),
        RIGHT("'right'");

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

    private List<ContextMenuItem> menuItems = new ArrayList<ContextMenuItem>();
    private Options options = new Options();

    @Override
    public JsStatement statement()
    {
        JsStatement statement;
        if (options.getJavaScriptOptions().length() > 2)
        {
            statement = new JsQuery(this.getComponent()).$().chain("contextMenu", options.getJavaScriptOptions());
        }
        else
        {
            statement = new JsQuery(this.getComponent()).$().chain("contextMenu");
        }
        return statement;
    }

    public ContextMenu() {
        options.put("trigger", Trigger.RIGHT.toString());
    };

    public ContextMenu(Options options)
    {
        this.options = options;
    }

    public ContextMenu setTrigger(Trigger trigger)
    {
        options.put("trigger", trigger.toString());
        return this;
    }

    public ContextMenu addItem(ContextMenuItem item)
    {
        menuItems.add(item);
        return this;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response)
    {
        response.renderJavaScriptReference(new PackageResourceReference(getClass(), "jquery.ui.position.js"));
        response.renderJavaScriptReference(new PackageResourceReference(getClass(), "jquery.contextMenu.js"));
        response.renderCSSReference(new CssResourceReference(getClass(), "jquery.contextMenu.css"));
    }
}
