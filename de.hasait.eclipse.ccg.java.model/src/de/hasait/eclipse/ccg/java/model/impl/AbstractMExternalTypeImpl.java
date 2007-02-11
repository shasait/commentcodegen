/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMExternalTypeImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMExternalType;
import de.hasait.eclipse.ccg.java.model.MRoot;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract MExternal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl#getFullQualifiedName <em>Full Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractMExternalTypeImpl extends EObjectImpl implements AbstractMExternalType {
	/**
	 * The default value of the '{@link #getFullQualifiedName() <em>Full Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullQualifiedName() <em>Full Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String fullQualifiedName = FULL_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractMExternalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_MEXTERNAL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MRoot getRoot() {
		if (eContainerFeatureID != ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT) return null;
		return (MRoot)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(MRoot newRoot, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRoot, ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(MRoot newRoot) {
		if (newRoot != eInternalContainer() || (eContainerFeatureID != ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT && newRoot != null)) {
			if (EcoreUtil.isAncestor(this, newRoot))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, ModelPackage.MROOT__EXTERNAL_TYPES, MRoot.class, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullQualifiedName() {
		return fullQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullQualifiedName(String newFullQualifiedName) {
		String oldFullQualifiedName = fullQualifiedName;
		fullQualifiedName = newFullQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME, oldFullQualifiedName, fullQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRoot((MRoot)otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				return basicSetRoot(null, msgs);
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MROOT__EXTERNAL_TYPES, MRoot.class, msgs);
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				return getRoot();
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME:
				return getFullQualifiedName();
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				setRoot((MRoot)newValue);
				return;
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME:
				setFullQualifiedName((String)newValue);
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				setRoot((MRoot)null);
				return;
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME:
				setFullQualifiedName(FULL_QUALIFIED_NAME_EDEFAULT);
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
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__ROOT:
				return getRoot() != null;
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME:
				return FULL_QUALIFIED_NAME_EDEFAULT == null ? fullQualifiedName != null : !FULL_QUALIFIED_NAME_EDEFAULT.equals(fullQualifiedName);
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
		result.append(" (fullQualifiedName: ");
		result.append(fullQualifiedName);
		result.append(')');
		return result.toString();
	}

} //AbstractMExternalTypeImpl