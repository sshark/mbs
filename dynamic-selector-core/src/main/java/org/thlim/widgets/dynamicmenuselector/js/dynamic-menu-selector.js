/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the License); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

;(function($) {

    $.widget('ui.dynamicMenuSelector', {
        _init : function() {
            this.element.children('.menu-item-selector').html(this.element.find('.selected a').html());
        }
    })

    $.extend($.ui.dynamicMenuSelector, {});

})(jQuery);

/*
            $('.menu-item').click(function(e) { +
                            $('ul').children('.selected').toggleClass('selected'); +
                            var selected = $(this); +
                            $('.selected-menu-item-name').html(selector.children('a').html()) +
                            $('.menu-item-selector').animate({'top': $(this).position().top - 8}, +
                                'fast', +
                                function() { +
                                    selected.toggleClass('selected'); +
                                    $('.selected').html(selector.children('a').html()) +
                                }););
                */