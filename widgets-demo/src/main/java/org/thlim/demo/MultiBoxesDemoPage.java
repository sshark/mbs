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

package org.thlim.demo;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.thlim.widgets.multiselection.MultiBoxesSelection;

public class MultiBoxesDemoPage extends WebPage
{
    private int numSelectionBoxes = 3;

    public MultiBoxesDemoPage()
    {
        setDefaultModel(new CompoundPropertyModel(this));

        List<String> numbers = Arrays.asList(new String[]{
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12"});

        final List<String> alphabets = Arrays.asList(new String[]{
            "A", "B", "C", "D",
            "E", "F", "G", "H",
            "I", "J", "K", "L"});

        final MultiBoxesSelection numbersSelectionBoxes = new MultiBoxesSelection("numSelectionBoxes", numbers);
        numbersSelectionBoxes.add(new MultiBoxesSelection.MinimumBoxSelectionValidator(4));

        Form numbersForm = new Form("numbersForm");

        final Component numbersFeedbackPanel =
            new FeedbackPanel("feedback").setFilter(new ComponentFeedbackMessageFilter(numbersForm)).setOutputMarkupId(true);

        numbersForm.add(new AjaxSubmitLink("numbersSubmitLink")
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                StringBuilder buffer = new StringBuilder();
                int selections = numSelectionBoxes;
                for (int i = 0; i < 32; i++)
                {
                    if ((selections & (1 << i)) > 0)
                    {
                        buffer.append((i + 1) + ", ");
                    }
                }
                if (buffer.length() > 0)
                {
                    buffer.setLength(buffer.length() - 2);
                }
                form.info("You have selected boxes " + buffer);
                target.add(numbersFeedbackPanel);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
                form.error(numbersSelectionBoxes.getFeedbackMessage().getMessage());
                numbersSelectionBoxes.getFeedbackMessage().markRendered();
                target.add(numbersFeedbackPanel);
            }
        });
        add(numbersForm);
        numbersForm.add(numbersSelectionBoxes.setMaxSelections(5));
        numbersForm.add(numbersFeedbackPanel);

        final MultiBoxesSelection alphabetsSelectionBoxes = new MultiBoxesSelection("alphaSelectionBoxes", alphabets);
        // to demonstate model can be set after construction and not using CompoundPropertyModel
        final IModel<Integer> alphabetsSelectionModel = new Model<Integer>(9);
        alphabetsSelectionBoxes.setModel(alphabetsSelectionModel);
        alphabetsSelectionBoxes.add(new MultiBoxesSelection.MinimumBoxSelectionValidator(3));

        Form alphabetsForm = new Form("alphabetsForm");

        final Component alphabetsFeedbackPanel =
            new FeedbackPanel("feedback").setFilter(new ComponentFeedbackMessageFilter(alphabetsForm)).setOutputMarkupId(true);

        alphabetsForm.add(new AjaxSubmitLink("alphabetsSubmitLink")
        {
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                StringBuilder buffer = new StringBuilder();
                int selections = alphabetsSelectionModel.getObject();
                int size = alphabets.size();
                for (int i = 0; i < 32; i++)
                {

                    if ((selections & (1 << i)) > 0)
                    {
                        if (i < size)
                        {
                            buffer.append(alphabets.get(i) + ", ");
                        }
                    }
                }
                if (buffer.length() > 0)
                {
                    buffer.setLength(buffer.length() - 2);
                }
                form.info("You have selected boxes " + buffer);
                target.add(alphabetsFeedbackPanel);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
                form.error(alphabetsSelectionBoxes.getFeedbackMessage().getMessage());
                alphabetsSelectionBoxes.getFeedbackMessage().markRendered();
                target.add(alphabetsFeedbackPanel);
            }
        });
        add(alphabetsForm);
        alphabetsForm.add(alphabetsSelectionBoxes.setMaxSelections(8));
        alphabetsForm.add(alphabetsFeedbackPanel);

    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        response.renderCSSReference(new PackageResourceReference(getClass(), "multiboxes-demo.css"));
    }
}
