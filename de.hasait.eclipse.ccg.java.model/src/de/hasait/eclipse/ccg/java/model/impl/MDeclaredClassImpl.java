/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredClassImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMClass;
import de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType;
import de.hasait.eclipse.ccg.java.model.AbstractMInterface;
import de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer;
import de.hasait.eclipse.ccg.java.model.MConstructor;
import de.hasait.eclipse.ccg.java.model.MDeclaredClass;
import de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDeclared Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getTypeContainer <em>Type Container</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getStaticFields <em>Static Fields</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getInstanceFields <em>Instance Fields</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getImplementedMethods <em>Implemented Methods</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl#getNativeMethods <em>Native Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDeclaredClassImpl extends AbstractMClassImpl implements MDeclaredClass {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList types = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected AbstractMClass extends_ = null;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList implements_ = null;

	/**
	 * The cached value of the '{@link #getStaticFields() <em>Static Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticFields()
	 * @generated
	 * @ordered
	 */
	protected EList staticFields = null;

	/**
	 * The cached value of the '{@link #getInstanceFields() <em>Instance Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceFields()
	 * @generated
	 * @ordered
	 */
	protected EList instanceFields = null;

	/**
	 * The cached value of the '{@link #getConstructors() <em>Constructors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructors()
	 * @generated
	 * @ordered
	 */
	protected EList constructors = null;

	/**
	 * The cached value of the '{@link #getImplementedMethods() <em>Implemented Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedMethods()
	 * @generated
	 * @ordered
	 */
	protected EList implementedMethods = null;

	/**
	 * The cached value of the '{@link #getNativeMethods() <em>Native Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeMethods()
	 * @generated
	 * @ordered
	 */
	protected EList nativeMethods = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MDeclaredClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MDECLARED_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTypes() {
		if (types == null) {
			types = new EObjectContainmentWithInverseEList(AbstractMDeclaredType.class, this, ModelPackage.MDECLARED_CLASS__TYPES, ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMTypeContainer getTypeContainer() {
		if (eContainerFeatureID != ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER) return null;
		return (AbstractMTypeContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeContainer(AbstractMTypeContainer newTypeContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTypeContainer, ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeContainer(AbstractMTypeContainer newTypeContainer) {
		if (newTypeContainer != eInternalContainer() || (eContainerFeatureID != ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER && newTypeContainer != null)) {
			if (EcoreUtil.isAncestor(this, newTypeContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTypeContainer != null)
				msgs = ((InternalEObject)newTypeContainer).eInverseAdd(this, ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES, AbstractMTypeContainer.class, msgs);
			msgs = basicSetTypeContainer(newTypeContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER, newTypeContainer, newTypeContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMClass getExtends() {
		if (extends_ != null && extends_.eIsProxy()) {
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (AbstractMClass)eResolveProxy(oldExtends);
			if (extends_ != oldExtends) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.MDECLARED_CLASS__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMClass basicGetExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(AbstractMClass newExtends) {
		AbstractMClass oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_CLASS__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectResolvingEList(AbstractMInterface.class, this, ModelPackage.MDECLARED_CLASS__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStaticFields() {
		if (staticFields == null) {
			staticFields = new EObjectContainmentWithInverseEList(MStaticClassFieldDeclaration.class, this, ModelPackage.MDECLARED_CLASS__STATIC_FIELDS, ModelPackage.MSTATIC_CLASS_FIELD_DECLARATION__OWNER);
		}
		return staticFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInstanceFields() {
		if (instanceFields == null) {
			instanceFields = new EObjectContainmentWithInverseEList(MInstanceClassFieldDeclaration.class, this, ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS, ModelPackage.MINSTANCE_CLASS_FIELD_DECLARATION__OWNER);
		}
		return instanceFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConstructors() {
		if (constructors == null) {
			constructors = new EObjectContainmentWithInverseEList(MConstructor.class, this, ModelPackage.MDECLARED_CLASS__CONSTRUCTORS, ModelPackage.MCONSTRUCTOR__OWNER);
		}
		return constructors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getImplementedMethods() {
		if (implementedMethods == null) {
			implementedMethods = new EObjectContainmentWithInverseEList(AbstractMMethodImplementation.class, this, ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER);
		}
		return implementedMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNativeMethods() {
		if (nativeMethods == null) {
			nativeMethods = new EObjectContainmentWithInverseEList(MNativeMethodDeclaration.class, this, ModelPackage.MDECLARED_CLASS__NATIVE_METHODS, ModelPackage.MNATIVE_METHOD_DECLARATION__OWNER);
		}
		return nativeMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				return ((InternalEList)getTypes()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTypeContainer((AbstractMTypeContainer)otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				return ((InternalEList)getStaticFields()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				return ((InternalEList)getInstanceFields()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				return ((InternalEList)getConstructors()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				return ((InternalEList)getImplementedMethods()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				return ((InternalEList)getNativeMethods()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				return ((InternalEList)getTypes()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				return basicSetTypeContainer(null, msgs);
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				return ((InternalEList)getStaticFields()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				return ((InternalEList)getInstanceFields()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				return ((InternalEList)getConstructors()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				return ((InternalEList)getImplementedMethods()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				return ((InternalEList)getNativeMethods()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES, AbstractMTypeContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				return getTypes();
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				return getTypeContainer();
			case ModelPackage.MDECLARED_CLASS__NAME:
				return getName();
			case ModelPackage.MDECLARED_CLASS__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTS:
				return getImplements();
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				return getStaticFields();
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				return getInstanceFields();
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				return getConstructors();
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				return getImplementedMethods();
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				return getNativeMethods();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				setTypeContainer((AbstractMTypeContainer)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__EXTENDS:
				setExtends((AbstractMClass)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				getStaticFields().clear();
				getStaticFields().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				getInstanceFields().clear();
				getInstanceFields().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				getConstructors().clear();
				getConstructors().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				getImplementedMethods().clear();
				getImplementedMethods().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				getNativeMethods().clear();
				getNativeMethods().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				getTypes().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				setTypeContainer((AbstractMTypeContainer)null);
				return;
			case ModelPackage.MDECLARED_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.MDECLARED_CLASS__EXTENDS:
				setExtends((AbstractMClass)null);
				return;
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTS:
				getImplements().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				getStaticFields().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				getInstanceFields().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				getConstructors().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				getImplementedMethods().clear();
				return;
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				getNativeMethods().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.MDECLARED_CLASS__TYPES:
				return types != null && !types.isEmpty();
			case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER:
				return getTypeContainer() != null;
			case ModelPackage.MDECLARED_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.MDECLARED_CLASS__EXTENDS:
				return extends_ != null;
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case ModelPackage.MDECLARED_CLASS__STATIC_FIELDS:
				return staticFields != null && !staticFields.isEmpty();
			case ModelPackage.MDECLARED_CLASS__INSTANCE_FIELDS:
				return instanceFields != null && !instanceFields.isEmpty();
			case ModelPackage.MDECLARED_CLASS__CONSTRUCTORS:
				return constructors != null && !constructors.isEmpty();
			case ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS:
				return implementedMethods != null && !implementedMethods.isEmpty();
			case ModelPackage.MDECLARED_CLASS__NATIVE_METHODS:
				return nativeMethods != null && !nativeMethods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == AbstractMTypeContainer.class) {
			switch (derivedFeatureID) {
				case ModelPackage.MDECLARED_CLASS__TYPES: return ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES;
				default: return -1;
			}
		}
		if (baseClass == AbstractMDeclaredType.class) {
			switch (derivedFeatureID) {
				case ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER: return ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER;
				case ModelPackage.MDECLARED_CLASS__NAME: return ModelPackage.ABSTRACT_MDECLARED_TYPE__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == AbstractMTypeContainer.class) {
			switch (baseFeatureID) {
				case ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES: return ModelPackage.MDECLARED_CLASS__TYPES;
				default: return -1;
			}
		}
		if (baseClass == AbstractMDeclaredType.class) {
			switch (baseFeatureID) {
				case ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER: return ModelPackage.MDECLARED_CLASS__TYPE_CONTAINER;
				case ModelPackage.ABSTRACT_MDECLARED_TYPE__NAME: return ModelPackage.MDECLARED_CLASS__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MDeclaredClassImpl