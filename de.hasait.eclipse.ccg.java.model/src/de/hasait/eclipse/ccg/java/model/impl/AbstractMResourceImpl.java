/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMResourceImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMResource;
import de.hasait.eclipse.ccg.java.model.MPackage;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract MResource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl#getSuperOf <em>Super Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractMResourceImpl extends EObjectImpl implements AbstractMResource {
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
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedFrom()
	 * @generated
	 * @ordered
	 */
	protected EList derivedFrom = null;

	/**
	 * The cached value of the '{@link #getSuperOf() <em>Super Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperOf()
	 * @generated
	 * @ordered
	 */
	protected EList superOf = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractMResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_MRESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage getPackage() {
		if (eContainerFeatureID != ModelPackage.ABSTRACT_MRESOURCE__PACKAGE) return null;
		return (MPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackage(MPackage newPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackage, ModelPackage.ABSTRACT_MRESOURCE__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(MPackage newPackage) {
		if (newPackage != eInternalContainer() || (eContainerFeatureID != ModelPackage.ABSTRACT_MRESOURCE__PACKAGE && newPackage != null)) {
			if (EcoreUtil.isAncestor(this, newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject)newPackage).eInverseAdd(this, ModelPackage.MPACKAGE__RESOURCES, MPackage.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MRESOURCE__PACKAGE, newPackage, newPackage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MRESOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MRESOURCE__DERIVED, oldDerived, derived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDerivedFrom() {
		if (derivedFrom == null) {
			derivedFrom = new EObjectWithInverseResolvingEList.ManyInverse(AbstractMResource.class, this, ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM, ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF);
		}
		return derivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuperOf() {
		if (superOf == null) {
			superOf = new EObjectWithInverseResolvingEList.ManyInverse(AbstractMResource.class, this, ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF, ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM);
		}
		return superOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((MPackage)otherEnd, msgs);
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				return ((InternalEList)getDerivedFrom()).basicAdd(otherEnd, msgs);
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				return ((InternalEList)getSuperOf()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				return basicSetPackage(null, msgs);
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				return ((InternalEList)getDerivedFrom()).basicRemove(otherEnd, msgs);
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				return ((InternalEList)getSuperOf()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MPACKAGE__RESOURCES, MPackage.class, msgs);
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				return getPackage();
			case ModelPackage.ABSTRACT_MRESOURCE__NAME:
				return getName();
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED:
				return isDerived() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				return getDerivedFrom();
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				return getSuperOf();
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				setPackage((MPackage)newValue);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED:
				setDerived(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				getDerivedFrom().clear();
				getDerivedFrom().addAll((Collection)newValue);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				getSuperOf().clear();
				getSuperOf().addAll((Collection)newValue);
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				setPackage((MPackage)null);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED:
				setDerived(DERIVED_EDEFAULT);
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				getDerivedFrom().clear();
				return;
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				getSuperOf().clear();
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
			case ModelPackage.ABSTRACT_MRESOURCE__PACKAGE:
				return getPackage() != null;
			case ModelPackage.ABSTRACT_MRESOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED:
				return derived != DERIVED_EDEFAULT;
			case ModelPackage.ABSTRACT_MRESOURCE__DERIVED_FROM:
				return derivedFrom != null && !derivedFrom.isEmpty();
			case ModelPackage.ABSTRACT_MRESOURCE__SUPER_OF:
				return superOf != null && !superOf.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(", derived: ");
		result.append(derived);
		result.append(')');
		return result.toString();
	}

} //AbstractMResourceImpl