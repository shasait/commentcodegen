/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredInterfaceImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType;
import de.hasait.eclipse.ccg.java.model.AbstractMInterface;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer;
import de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.MDeclaredInterface;
import de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration;
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
 * An implementation of the model object '<em><b>MDeclared Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getTypeContainer <em>Type Container</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDeclaredInterfaceImpl extends AbstractMInterfaceImpl implements MDeclaredInterface {
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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList extends_ = null;

	/**
	 * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstants()
	 * @generated
	 * @ordered
	 */
	protected EList constants = null;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList methods = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MDeclaredInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MDECLARED_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTypes() {
		if (types == null) {
			types = new EObjectContainmentWithInverseEList(AbstractMDeclaredType.class, this, ModelPackage.MDECLARED_INTERFACE__TYPES, ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMTypeContainer getTypeContainer() {
		if (eContainerFeatureID != ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER) return null;
		return (AbstractMTypeContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeContainer(AbstractMTypeContainer newTypeContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTypeContainer, ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeContainer(AbstractMTypeContainer newTypeContainer) {
		if (newTypeContainer != eInternalContainer() || (eContainerFeatureID != ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER && newTypeContainer != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER, newTypeContainer, newTypeContainer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_INTERFACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectResolvingEList(AbstractMInterface.class, this, ModelPackage.MDECLARED_INTERFACE__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConstants() {
		if (constants == null) {
			constants = new EObjectContainmentWithInverseEList(MConstantInterfaceFieldDeclaration.class, this, ModelPackage.MDECLARED_INTERFACE__CONSTANTS, ModelPackage.MCONSTANT_INTERFACE_FIELD_DECLARATION__OWNER);
		}
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentWithInverseEList(MInterfaceMethodDeclaration.class, this, ModelPackage.MDECLARED_INTERFACE__METHODS, ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				return ((InternalEList)getTypes()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTypeContainer((AbstractMTypeContainer)otherEnd, msgs);
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				return ((InternalEList)getConstants()).basicAdd(otherEnd, msgs);
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				return ((InternalEList)getMethods()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				return ((InternalEList)getTypes()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				return basicSetTypeContainer(null, msgs);
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				return ((InternalEList)getConstants()).basicRemove(otherEnd, msgs);
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				return ((InternalEList)getMethods()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
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
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				return getTypes();
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				return getTypeContainer();
			case ModelPackage.MDECLARED_INTERFACE__NAME:
				return getName();
			case ModelPackage.MDECLARED_INTERFACE__EXTENDS:
				return getExtends();
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				return getConstants();
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				return getMethods();
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
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				setTypeContainer((AbstractMTypeContainer)newValue);
				return;
			case ModelPackage.MDECLARED_INTERFACE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.MDECLARED_INTERFACE__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				getConstants().clear();
				getConstants().addAll((Collection)newValue);
				return;
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection)newValue);
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
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				getTypes().clear();
				return;
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				setTypeContainer((AbstractMTypeContainer)null);
				return;
			case ModelPackage.MDECLARED_INTERFACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.MDECLARED_INTERFACE__EXTENDS:
				getExtends().clear();
				return;
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				getConstants().clear();
				return;
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				getMethods().clear();
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
			case ModelPackage.MDECLARED_INTERFACE__TYPES:
				return types != null && !types.isEmpty();
			case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER:
				return getTypeContainer() != null;
			case ModelPackage.MDECLARED_INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.MDECLARED_INTERFACE__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ModelPackage.MDECLARED_INTERFACE__CONSTANTS:
				return constants != null && !constants.isEmpty();
			case ModelPackage.MDECLARED_INTERFACE__METHODS:
				return methods != null && !methods.isEmpty();
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
				case ModelPackage.MDECLARED_INTERFACE__TYPES: return ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES;
				default: return -1;
			}
		}
		if (baseClass == AbstractMDeclaredType.class) {
			switch (derivedFeatureID) {
				case ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER: return ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER;
				case ModelPackage.MDECLARED_INTERFACE__NAME: return ModelPackage.ABSTRACT_MDECLARED_TYPE__NAME;
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
				case ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES: return ModelPackage.MDECLARED_INTERFACE__TYPES;
				default: return -1;
			}
		}
		if (baseClass == AbstractMDeclaredType.class) {
			switch (baseFeatureID) {
				case ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER: return ModelPackage.MDECLARED_INTERFACE__TYPE_CONTAINER;
				case ModelPackage.ABSTRACT_MDECLARED_TYPE__NAME: return ModelPackage.MDECLARED_INTERFACE__NAME;
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

} //MDeclaredInterfaceImpl