package org.thlim.demo;

import java.util.ArrayList;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.thlim.widgets.dynamicmenuselector.DynamicMenuSelector;
import org.thlim.widgets.dynamicmenuselector.MenuLinkItem;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 2/1/12
 * Time: 3:23 PM
 *
 */
public class DynamicMenuSelectorDemoPage extends WebPage
{
    public DynamicMenuSelectorDemoPage()
    {
        Component content = new Label("content", "Laco").setOutputMarkupId(true);
        add(new DynamicMenuSelector("menu", new Model(createLinkItem(content))));
        add(content);
    }

    private ArrayList<MenuLinkItem> createLinkItem(final Component component)
    {
        ArrayList<MenuLinkItem> items = new ArrayList<MenuLinkItem>();
        items.add(new MenuLinkItem("Laco")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                IModel<String> model = (IModel<String>) component.getDefaultModel();
                model.setObject("Laco");
            }
        });

        items.add(new MenuLinkItem("Sinn")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                IModel<String> model = (IModel<String>) component.getDefaultModel();
                model.setObject("Sinn");
            }
        });

        items.add(new MenuLinkItem("Wempe")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                IModel<String> model = (IModel<String>) component.getDefaultModel();
                model.setObject("Wempe");
            }
        });

        items.add(new MenuLinkItem("Lange")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                IModel<String> model = (IModel<String>) component.getDefaultModel();
                model.setObject("Lange");
            }
        });

        items.add(new MenuLinkItem("Glashutte")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                IModel<String> model = (IModel<String>) component.getDefaultModel();
                model.setObject("Glashutte");
            }
        });
        return items;
    }
}
