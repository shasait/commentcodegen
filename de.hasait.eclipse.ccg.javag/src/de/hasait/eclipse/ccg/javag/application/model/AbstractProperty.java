package de.hasait.eclipse.ccg.javag.application.model;

import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public abstract class AbstractProperty {
	/**
	 * Constructor.
	 */
	protected AbstractProperty(final Bean bean, final String name, final String description, final String type,
	      final String backref, final String getterVisibility, final String setterVisibility) {
		super();

		_bean = bean;
		_name = name;
		_description = description;
		_type = type;
		_backref = backref;
		_getterVisibility = getterVisibility;
		_setterVisibility = setterVisibility;

		_varName = "_" + name;
		_capName = StringUtil.capitalize(name);

		_bean.addProperty(this);
	}

	/** Value of property bean. */
	private final Bean _bean;

	/**
	 * Return the value of property bean.
	 * 
	 * @return The value of property bean.
	 */
	public final Bean getBean() {
		return _bean;
	}

	/** Value of property name. */
	private final String _name;

	/**
	 * Return the value of property name.
	 * 
	 * @return The value of property name.
	 */
	public final String getName() {
		return _name;
	}

	/** Value of property varName. */
	private final String _varName;

	/**
	 * Return the value of property varName.
	 * 
	 * @return The value of property varName.
	 */
	public final String getVarName() {
		return _varName;
	}

	/** Value of property capName. */
	private final String _capName;

	/**
	 * Return the value of property capName.
	 * 
	 * @return The value of property capName.
	 */
	public final String getCapName() {
		return _capName;
	}

	/** Value of property description. */
	private final String _description;

	/**
	 * Return the value of property description.
	 * 
	 * @return The value of property description.
	 */
	public final String getDescription() {
		return _description;
	}

	/** Value of property type. */
	private final String _type;

	/**
	 * Return the value of property type.
	 * 
	 * @return The value of property type.
	 */
	public final String getType() {
		return _type;
	}

	/** Value of property backref. */
	private final String _backref;

	/**
	 * Return the value of property backref.
	 * 
	 * @return The value of property backref.
	 */
	public final String getBackref() {
		return _backref;
	}

	/** Value of property backrefProperty. */
	private AbstractProperty _backrefProperty;

	/**
	 * Return the value of property backrefProperty.
	 * 
	 * @return The value of property backrefProperty.
	 */
	public final AbstractProperty getBackrefProperty() {
		return _backrefProperty;
	}

	/** Value of property getterVisibility. */
	private final String _getterVisibility;

	/**
	 * Return the value of property getterVisibility.
	 * 
	 * @return The value of property getterVisibility.
	 */
	public final String getGetterVisibility() {
		return _getterVisibility;
	}

	/** Value of property setterVisibility. */
	private final String _setterVisibility;

	/**
	 * Return the value of property setterVisibility.
	 * 
	 * @return The value of property setterVisibility.
	 */
	public final String getSetterVisibility() {
		return _setterVisibility;
	}

	public final String getNameConstant() {
		return "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_NAME";
	}

	public final String getTypeConstant() {
		return "PROPERTY_" + StringUtil.camelCaseToUpperCase(_name) + "_TYPE";
	}

	public final String getFullName() {
		return _bean.getFullName() + "." + _name;
	}

	public final String getJavaDocFullName() {
		return "{@link " + _bean.getFullName() + "#" + _varName + "}";
	}

	public abstract String getAdderCall(String instance, String value);

	public abstract String getRemoverCall(String instance, String value);

	public void resolve(IProgressMonitor monitor) {
		if (_backref != null) {
			Bean typeBean = _bean.getModel().findBean(_type);
			if (typeBean == null) {
				throw new IllegalArgumentException(getFullName() + "#backref: Cannot find bean " + _type);
			}
			_backrefProperty = typeBean.findProperty(_backref);
			if (_backrefProperty == null) {
				throw new IllegalArgumentException(getFullName() + "#backref: No property " + _backref + " in bean "
				      + typeBean.getFullName());
			}
		}
	}

	public void validate(IProgressMonitor monitor) {
		// if (_backrefProperty != null && _backrefProperty.getBackr)
		// if !@backrefProperty.backrefProperty.nil? and @backrefProperty.backrefProperty != self
		// raise "Backref of backref #{@backref} is not #{@name}, but #{@backrefProperty.backrefProperty.name}"
		// end
		// puts("backref of #{getFullName()} is #{@backrefProperty.getFullName()}")
	}

	public void write(ContentBuffer content, IProgressMonitor monitor) {
		content.p("//");
		content.p("// ########## PROPERTY #{@name} follows ##########");
		content.p("//");

		//
		// constants
		//
		content.pi("/**", " * ");
		content.p("Name of property " + _name + ".");
		content.pu(" */");
		content.p("public static final String " + getNameConstant() + " = \"" + _name + "\";");

		content.pi("/**", " * ");
		content.p("Type of property " + _name + ".");
		content.pu(" */");
		content.p("public static final Class " + getTypeConstant() + " = " + _type + ".class;");
		content.p();
	}
}
