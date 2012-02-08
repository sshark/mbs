package org.thlim.demo;

import java.util.ArrayList;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
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
    IModel<String> urlModel = new Model<String>("http://www.steinhartwatches.de/");

    public DynamicMenuSelectorDemoPage()
    {
        Component content = new WebMarkupContainer("content")
            .add(new AttributeModifier("src", urlModel))
            .setOutputMarkupId(true);
        add(new DynamicMenuSelector("menu", new Model(createLinkItem(content))));
        add(content);
    }

    private ArrayList<MenuLinkItem> createLinkItem(final Component component)
    {
        ArrayList<MenuLinkItem> items = new ArrayList<MenuLinkItem>();
        items.add(new MenuLinkItem("Steinhart")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                urlModel.setObject("http://www.steinhartwatches.de/");
            }
        });

        items.add(new MenuLinkItem("Sinn")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                urlModel.setObject("http://www.sinn.de/en/");
            }
        });

        items.add(new MenuLinkItem("Wempe")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                urlModel.setObject("http://www.wempe.de/index.htm");
            }
        });

        items.add(new MenuLinkItem("Lange")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                urlModel.setObject("http://www.alange-soehne.com/cms/en/index.html");
            }
        });

        items.add(new MenuLinkItem("Patek Philippe")
        {
            @Override
            protected void execute(AjaxRequestTarget target)
            {
                target.add(component);
                urlModel.setObject("http://www.patek.com/");
            }
        });
        return items;
    }
}
