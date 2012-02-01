package org.thlim.widgets.dynamicmenuselector;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.effects.CoreEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.widget.WidgetJavaScriptResourceReference;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 2/1/12
 * Time: 2:57 PM
 *
 */
public class MenuBehavior extends WiQueryAbstractBehavior
{
    @Override
    public JsStatement statement()
    {
        return new JsQuery(getComponent()).$().chain("dynamicMenuSelector");
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response)
    {
        response.renderCSSReference(new CssResourceReference(getClass(), "css/dynamic-menu-selector.css"));
        response.renderJavaScriptReference(WidgetJavaScriptResourceReference.get());
        response.renderJavaScriptReference(CoreEffectJavaScriptResourceReference.get());
        response.renderJavaScriptReference(new JavaScriptResourceReference(getClass(), "js/dynamic-menu-selector.js"));
    }
}

/*
 $('#project-name').html($('.menu-item-selector').children('a').html());
        $(".project").click(function(e) {
            $("ul").children(".menu-item-selector").toggleClass("menu-item-selector");
            var selector = $(this);

            $('#project-name').html(selector.children('a').html())
            $("#project-selector").animate({'top': $(this).position().top - 8},
                'fast',
                function() {
                    selector.toggleClass("menu-item-selector");
                    $('#project-name').html(selector.children('a').html())
                });
        });

        output
        ------
        $(document).ready(function() {
		$('#multiBoxesSelection1').multiboxesselection({ms_delay: 1000, max_selections: 8});
	$('#multiBoxesSelection2').multiboxesselection({ms_delay: 1000, max_selections: 5});

});
 */
