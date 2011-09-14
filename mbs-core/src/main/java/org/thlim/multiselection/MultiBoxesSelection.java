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

package org.thlim.multiselection;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class MultiBoxesSelection<T> extends FormComponentPanel<Integer>
{
    private MultiBoxesSelectionBehavior behavior = new MultiBoxesSelectionBehavior();
    private WebMarkupContainer container = new WebMarkupContainer("multiBoxesSelection");
    private HiddenField<Integer> selections = new HiddenField<Integer>("selections", Integer.class);

    IModel<? extends List<? extends T>> labelsModel;

    public MultiBoxesSelection(String id, List<? extends T> labels)
    {
        this(id, Model.ofList(labels));
    }

    public MultiBoxesSelection(String id,
        final IModel<? extends List<? extends T>> labelsModel)
    {
        super(id);

        this.labelsModel = labelsModel;

        add(container.setOutputMarkupId(true).add());

        @SuppressWarnings("unchecked")
        ListView<T> tile = new ListView<T>("selectionBox", labelsModel)
        {
            protected void populateItem(ListItem listItem)
            {
                listItem.add(new Label("selectionLabel", listItem.getDefaultModel()).setOutputMarkupId(true));
            }
        };
        container.add(tile);

        behavior.setMillisDelay(1000);

        add(selections);
    }

    public MultiBoxesSelection setMaxSelections(int max)
    {
        behavior.setMaxSelections(max);
        return this;
    }

    public MultiBoxesSelection setMillisDelay(int msDelay)
    {
        behavior.setMillisDelay(msDelay);
        return this;
    }

    @Override
    protected void onBeforeRender()
    {
        container.add(behavior);

        // CompoundPropertyModel does not popular parents Model during construction so it has to be
        // done here.
        selections.setModel(getModel());

        super.onBeforeRender();
    }

    /**
     * Though selections field and its parent share the same model, we must override parent's convertInput()
     * to set parents convertedInput to selections value (non-null). Otherwise, Wicket will throw a null exception
     * when it sets the parent's model value with parent's covertedInput value.
     *
     */
    @Override
    protected void convertInput()
    {
        setConvertedInput(selections.getConvertedInput());
    }

    @Override
    public String getInput()
    {
        return selections.getInput();
    }


    public static class MinimumBoxSelectionValidator implements IValidator<Integer>
    {
        private int minSelection;

        public MinimumBoxSelectionValidator(int minSelection)
        {
            this.minSelection = minSelection;
        }

        public void validate(IValidatable<Integer> validatable)
        {
            int selections = validatable.getValue();
            if (count(selections) < minSelection)
            {
                ValidationError error = new ValidationError();
                error.addMessageKey("MinimumBoxSelectionValidator");
                error.setVariable("minSelection", minSelection);
                validatable.error(error);
            }
        }

        private int count(int selections)
        {
            int bitCounter = 0;
            for (int i = 0; i < 32; i++)
            {
                if ((selections & (1 << i)) > 0)
                {
                    bitCounter++;
                }
            }
            return bitCounter;
        }

        public void setMinSelection(int minSelection)
        {
            this.minSelection = minSelection;
        }

        public int getMinSelection()
        {
            return minSelection;
        }
    }
}
