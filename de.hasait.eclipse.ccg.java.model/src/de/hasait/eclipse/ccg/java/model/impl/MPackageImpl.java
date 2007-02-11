/**
 * <copyright>
 * </copyright>
 *
 * $Id: MPackageImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MPackageImpl#getPackageContainer <em>Package Container</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MPackageImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MPackageImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPackageImpl extends AbstractMPackageContainerImpl implements MPackage {
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
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList resources = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MPACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMPackageContainer getPackageContainer() {
		if (eContainerFeatureID != ModelPackage.MPACKAGE__PACKAGE_CONTAINER) return null;
		return (AbstractMPackageContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackageContainer(AbstractMPackageContainer newPackageContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackageContainer, ModelPackage.MPACKAGE__PACKAGE_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageContainer(AbstractMPackageContainer newPackageContainer) {
		if (newPackageContainer != eInternalContainer() || (eContainerFeatureID != ModelPackage.MPACKAGE__PACKAGE_CONTAINER && newPackageContainer != null)) {
			if (EcoreUtil.isAncestor(this, newPackageContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackageContainer != null)
				msgs = ((InternalEObject)newPackageContainer).eInverseAdd(this, ModelPackage.ABSTRACT_MPACKAGE_CONTAINER__PACKAGES, AbstractMPackageContainer.class, msgs);
			msgs = basicSetPackageContainer(newPackageContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MPACKAGE__PACKAGE_CONTAINER, newPackageContainer, newPackageContainer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MPACKAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResources() {
		if (resources == null) {
			resources = new EObjectContainmentWithInverseEList(AbstractMResource.class, this, ModelPackage.MPACKAGE__RESOURCES, ModelPackage.ABSTRACT_MRESOURCE__PACKAGE);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackageContainer((AbstractMPackageContainer)otherEnd, msgs);
			case ModelPackage.MPACKAGE__RESOURCES:
				return ((InternalEList)getResources()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				return basicSetPackageContainer(null, msgs);
			case ModelPackage.MPACKAGE__RESOURCES:
				return ((InternalEList)getResources()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.ABSTRACT_MPACKAGE_CONTAINER__PACKAGES, AbstractMPackageContainer.class, msgs);
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				return getPackageContainer();
			case ModelPackage.MPACKAGE__NAME:
				return getName();
			case ModelPackage.MPACKAGE__RESOURCES:
				return getResources();
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				setPackageContainer((AbstractMPackageContainer)newValue);
				return;
			case ModelPackage.MPACKAGE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.MPACKAGE__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection)newValue);
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				setPackageContainer((AbstractMPackageContainer)null);
				return;
			case ModelPackage.MPACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.MPACKAGE__RESOURCES:
				getResources().clear();
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
			case ModelPackage.MPACKAGE__PACKAGE_CONTAINER:
				return getPackageContainer() != null;
			case ModelPackage.MPACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.MPACKAGE__RESOURCES:
				return resources != null && !resources.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MPackageImpl