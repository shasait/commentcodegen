/**
 * <copyright>
 * </copyright>
 *
 * $Id: MInterfaceMethodDeclarationImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.MDeclaredInterface;
import de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MInterface Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MInterfaceMethodDeclarationImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MInterfaceMethodDeclarationImpl extends AbstractMImplementableMethodDeclarationImpl implements MInterfaceMethodDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MInterfaceMethodDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MINTERFACE_METHOD_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredInterface getOwner() {
		if (eContainerFeatureID != ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER) return null;
		return (MDeclaredInterface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(MDeclaredInterface newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(MDeclaredInterface newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID != ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, ModelPackage.MDECLARED_INTERFACE__METHODS, MDeclaredInterface.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((MDeclaredInterface)otherEnd, msgs);
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				return basicSetOwner(null, msgs);
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MDECLARED_INTERFACE__METHODS, MDeclaredInterface.class, msgs);
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				return getOwner();
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				setOwner((MDeclaredInterface)newValue);
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				setOwner((MDeclaredInterface)null);
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
			case ModelPackage.MINTERFACE_METHOD_DECLARATION__OWNER:
				return getOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //MInterfaceMethodDeclarationImpl