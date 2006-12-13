package de.hasait.eclipse.ccg.javag.application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.resource.XFile;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class Bean {
	private final Model _model;

	private final String _name;

	private final String _description;

	private final boolean _abstract;

	private final String _extends;

	private Bean _extendsBean;

	private final XFile _targetFile;

	private final java.util.List _property = new java.util.ArrayList();

	private final Map _propertyByName = new HashMap();

	private final List _subBeans = new ArrayList();

	/**
	 * Constructor.
	 */
	public Bean(final Model model, final String name, final String description, final boolean abstractj,
	      final String extendsj) {
		super();

		_model = model;
		_name = name;
		_description = description;
		_abstract = abstractj;
		_extends = extendsj;

		_targetFile = _model.getTargetFolder().getFile(_name + ".java");

		_model.addBean(this);
	}

	/**
	 * Return the value of property model.
	 * 
	 * @return The value of property model.
	 */
	public final Model getModel() {
		return _model;
	}

	/**
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return _description;
	}

	/**
	 * @return the abstract
	 */
	public final boolean isAbstract() {
		return _abstract;
	}

	/**
	 * @return the extends
	 */
	public final String getExtends() {
		return _extends;
	}

	/**
	 * @return the extendsBean
	 */
	public final Bean getExtendsBean() {
		return _extendsBean;
	}

	/**
	 * @return the targetFile
	 */
	public final XFile getTargetFile() {
		return _targetFile;
	}

	/**
	 * The value of property property at the specified index.
	 * 
	 * @param index
	 *           The index, which must be valid.
	 * @return The value of property property at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final AbstractProperty getProperty(int index) {
		return (AbstractProperty) _property.get(index);
	}

	/**
	 * Returns an {@link java.util.Iterator} for all values of property property.
	 * 
	 * @return An {@link java.util.Iterator} for all values of property property.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator propertyIterator() {
		return _property.iterator();
	}

	/**
	 * Returns the number of values of property property.
	 * 
	 * @return The number of values of property property.
	 * @see java.util.List#size()
	 */
	public final int propertySize() {
		return _property.size();
	}

	/**
	 * Add the specified value to property property. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.AbstractProperty#_bean}, which will be updated by this
	 * method.
	 * 
	 * @param property
	 *           The additional value for property property.
	 * @see java.util.List#add(Object)
	 */
	final void addProperty(final AbstractProperty property) {
		if (_property.contains(property)) {
			return;
		}
		String propertyName = property.getName();
		if (_propertyByName.containsKey(propertyName)) {
			throw new IllegalArgumentException("Duplicate property name: " + propertyName);
		}
		_property.add(property);
		_propertyByName.put(propertyName, property);
	}

	/**
	 * Remove the specified value of property property. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.AbstractProperty#_bean}, which will be updated by this
	 * method.
	 * 
	 * @param property
	 *           The value to remove from property property.
	 * @see java.util.List#remove(Object)
	 */
	final void removeProperty(final AbstractProperty property) {
		if (!_property.contains(property)) {
			return;
		}
		_property.remove(property);
		_propertyByName.remove(property.getName());
	}

	public final String getFullName() {
		return _model.getPackage() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + getFullName() + "}";
	}

	public final AbstractProperty findProperty(String name) {
		return (AbstractProperty) _propertyByName.get(name);
	}

	public final void resolve(final IProgressMonitor monitor) {
		if (_extends != null) {
			_extendsBean = _model.findBean(_extends);
			if (_extendsBean != null) {
				_extendsBean._subBeans.add(this);
			}
		}
		for (Iterator propertyI = _property.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.resolve(monitor);
		}
	}

	public final void validate(final IProgressMonitor monitor) {
		for (Iterator propertyI = _property.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.validate(monitor);
		}
	}

	public final void write(final ContentBuffer content, final IProgressMonitor monitor) {
		monitor.subTask("write Bean " + getFullName());
		content.pi("/**", " * ");
		if (_description != null) {
			// TODO handle multi-line descriptions
			content.p(_description);
			content.p();
		}
		if (!_subBeans.isEmpty()) {
			content.pi("Subclasses are:<ul>");
			for (Iterator subBeansI = _subBeans.iterator(); subBeansI.hasNext();) {
				Bean subBean = (Bean) subBeansI.next();
				content.p("<li>" + subBean.getJavaDocFullName() + "</li>");
			}
			content.pu("</ul>");
		}
		content.p("@author CommentCodeGen " + _model.getApplication().getSourceFile().getFullPath().toString());
		content.pu(" */");
		content.a("public ");
		if (_abstract) {
			content.a("abstract ");
		}
		content.a("class " + _name + " ");
		if (_extends != null) {
			content.a("extends " + _extends + " ");
		}
		content.pi("{");
		for (Iterator propertyI = _property.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeConstants(content, monitor);
		}
		for (Iterator propertyI = _property.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeFields(content, monitor);
		}
		for (Iterator propertyI = _property.iterator(); propertyI.hasNext();) {
			AbstractProperty property = (AbstractProperty) propertyI.next();
			property.writeMethods(content, monitor);
		}
		content.pu("}");
	}
}
