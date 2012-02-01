package org.thlim.widgets.dynamicmenuselector;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 2/1/12
 * Time: 1:34 PM
 *
 */
public class DynamicMenuSelector extends Panel
{
    public DynamicMenuSelector(String id, IModel<List<MenuLinkItem>> menuItemsLinkModel)
    {
        super(id);

        WebMarkupContainer dynamicMenuSelector = new WebMarkupContainer("dynamicMenuSelector");
        add(dynamicMenuSelector);

        ListView<MenuLinkItem> menu = new ListView<MenuLinkItem>("menu", menuItemsLinkModel)
        {
            @Override
            protected void populateItem(ListItem<MenuLinkItem> item)
            {
                final MenuLinkItem linkItem = item.getModelObject();
                AjaxLink link = new AjaxLink("menuItemLink")
                {
                    @Override
                    public void onClick(AjaxRequestTarget target)
                    {
                        linkItem.execute(target);
                    }
                };
                item.add(link);
                if (item.getIndex() == 0)
                {
                    item.add(new AttributeAppender("class", " selected"));
                }
                link.add(new Label("menuItemName", linkItem.getName()));
            }
        };
        dynamicMenuSelector.add(menu).add(new MenuBehavior());
    }
}
