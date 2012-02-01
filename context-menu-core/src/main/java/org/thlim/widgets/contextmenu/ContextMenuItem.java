package org.thlim.widgets.contextmenu;

import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.IListItemOption;

/**
 *
 * User: Lim, Teck Hooi
 * Date: 11/8/11
 * Time: 4:59 PM
 *
 * This widget is based on a jQuery contextMenu located in
 *
 * http://medialize.github.com/jQuery-contextMenu/
 *
 * For settings and options available for callback function please refer to its document
 *
 * http://medialize.github.com/jQuery-contextMenu/docs.html
 *
 */
public class ContextMenuItem implements IListItemOption
{
    private String key;
    private String name;
    private JsStatement callback;

    public ContextMenuItem(String key, String name)
    {
        this(key, name, null);
    }

    public ContextMenuItem(String key, String name, JsStatement callback)
    {
        this.key = key;
        this.name = name;
        this.callback = callback;
    }

    /**
     *
     *
     * It includes key of the command and options to the customized Javascript . Please refer to
     * http://medialize.github.com/jQuery-contextMenu/docs.html for the properties inside options
     *
     * @return
     */

    public CharSequence getJavascriptOption()
    {
        StringBuilder buffer = new StringBuilder(key).append(":{").append("name:'").append(name).append("',");

        if (callback != null)
        {
            //buffer.append("callback:function(key,opt){window.location='http://www.ibm.com'}");
            buffer.append("callback:function(key,opt) {" + callback.render() + "}");
        }
        buffer.append("}");
        return buffer.toString();
    }

    public JsStatement getCallback()
    {
        return callback;
    }

    public void setAction(JsStatement callback)
    {
        this.callback = callback;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
