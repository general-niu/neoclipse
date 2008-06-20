/*
 * NeoPropertyDescriptor.java
 */
package org.neo4j.neoclipse.view;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * Describes a single property of a Neo node or relationship.
 * @author Peter H&auml;nsgen
 */
public class NeoPropertyDescriptor implements IPropertyDescriptor
{
    /**
     * The key for identifying the value of the property.
     */
    private Object key;
    /**
     * The name of the property.
     */
    private String name;
    /**
     * The category of the property.
     */
    private String category;
    /**
     * If we allow edit on this cell or not.
     */
    private boolean allowEdit = false;

    /**
     * Create a Neo property cell.
     * @param key the key of the property
     * @param name the name of the property
     * @param category the category of the property
     * @param allowEdit choose if this cell should be possible to edit
     */
    public NeoPropertyDescriptor( Object key, String name, String category,
        boolean allowEdit )
    {
        this.key = key;
        this.name = name;
        this.category = category;
        this.allowEdit = allowEdit;
    }

    /**
     * Create a Neo property cell without editing capabilities.
     * Use this for id and relationship types "fake properties".
     * @param key the key of the property
     * @param name the name of the property
     * @param category the category of the property
     * @param allowEdit choose if this cell should be possible to edit
     */
    public NeoPropertyDescriptor( Object key, String name, String category )
    {
        this.key = key;
        this.name = name;
        this.category = category;
    }

    public CellEditor createPropertyEditor( Composite parent )
    {
        return allowEdit ? new TextCellEditor( parent ) : null;
    }

    public String getCategory()
    {
        return category;
    }

    public String getDescription()
    {
        return "The property with the name '" + key + "'.";
    }

    public String getDisplayName()
    {
        return name;
    }

    public String[] getFilterFlags()
    {
        return null;
    }

    public Object getHelpContextIds()
    {
        return null;
    }

    public Object getId()
    {
        return key;
    }

    public ILabelProvider getLabelProvider()
    {
        return null;
    }

    public boolean isCompatibleWith( IPropertyDescriptor anotherProperty )
    {
        return false;
    }
}
