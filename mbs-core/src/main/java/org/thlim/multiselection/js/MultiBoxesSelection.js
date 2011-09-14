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

;(function($) {

$.widget("ui.multiboxesselection", {
    _init: function() {
		var choices = new Array();
		var maxSelections = this.options.max_selections;
		//var ms_delay = this.options.ms_delay;
		var ms_delay = this.options.ms_delay;

		this.element.children("li").click(function() {
			if ($(this).is(":animated"))
			{
				return;
			}

            /*
                ui-selected-marker is a workaround marker for toggleClass(...) since
                the element will not be marked with ui-selected until the animation
                has completed. This will cause problem while the element being
                animated in a separate thread, the selected funtion will not able to
                determine if the element being selected or not.
             */

            if ($(this).hasClass("ui-selected-marker")) {
                $(this).removeClass("ui-selected-marker");
            } else {
                $(this).addClass("ui-selected-marker");
            }

			$(this).toggleClass('ui-selected', ms_delay);

			ndx = $.inArray(this, choices);
			if (ndx >= 0) {
				choices.splice(ndx, 1);
                $(this).parent().next(":hidden").attr("value", selected($(this).parent()));
				return;
			}
			if (choices.length == maxSelections) {
				$(choices[0]).toggleClass('ui-selected', ms_delay);
				$(choices[0]).removeClass("ui-selected-marker");
				choices.splice(0, 1);
			}
			choices[choices.length] = this;

            $(this).parent().next(":hidden").attr("value", selected($(this).parent()));

			return false;
		});

        preSelect(choices, this.element.children("li"), this.element.next(":hidden").attr("value"));

	},
	selected : function() {
		var selectionBit = 0;
		var parent = this.element;
		this.element.children("li.ui-selected.marker").each(function()
		{
			/**
			 * parent replaces $(this).parent()
			 */
			selectionBit |= (1 << parent.children("li").index(this));
		});
		return selectionBit;
	}
});

function selected(parent) {
    var selectionBit = 0;
    parent.children("li.ui-selected-marker").each(function()
    {
        /**
         * parent replaces $(this).parent()
         */
        selectionBit |= (1 << parent.children("li").index(this));
    });
    return selectionBit;
}

function preSelect(choices, elements, preSelect) {
    var j = 0;
    for (i = 0; i < elements.length; i++) {
        if ((preSelect & (1 << i)) > 0) {
            $(elements[i]).addClass("ui-selected-marker");
            $(elements[i]).addClass("ui-selected");
            choices[j++] = elements[i];
        }
    }
}


$.extend($.ui.multiboxesselection, {
	getter : "selected",
   	defaults :
	{
		max_selections : 3,
		ms_delay : 1000,
        pre_selected : 0
   	}
})

})(jQuery);

