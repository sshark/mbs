/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.thlim.widgets.multiselection;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.effects.CoreEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.widget.WidgetJavaScriptResourceReference;

public class MultiBoxesSelectionBehavior extends WiQueryAbstractBehavior
{
    private Options options = new Options();

    public MultiBoxesSelectionBehavior setMaxSelections(int max)
    {
        options.put("max_selections", max);
        return this;
    }

    public MultiBoxesSelectionBehavior setMillisDelay(int msDelay)
    {
        options.put("ms_delay", msDelay);
        return this;
    }

    public JsStatement statement()
    {
        JsStatement statement;
        if (options.getJavaScriptOptions().length() > 2)
        {
            statement = new JsQuery(this.getComponent()).$().chain("multiboxesselection", options.getJavaScriptOptions());
        }
        else
        {
            statement = new JsQuery(this.getComponent()).$().chain("multiboxesselection");
        }
        return statement;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response)
    {
        response.renderCSSReference(new CssResourceReference(getClass(), "css/multiboxes-selection.css"));
        response.renderJavaScriptReference(WidgetJavaScriptResourceReference.get());
        response.renderJavaScriptReference(CoreEffectJavaScriptResourceReference.get());
        response.renderJavaScriptReference(new PackageResourceReference(getClass(), "js/multiboxes.selection.js"));
    }
}
