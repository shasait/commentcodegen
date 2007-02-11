/**
 * <copyright>
 * </copyright>
 *
 * $Id: MAbstractClassMethodDeclarationImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass;
import de.hasait.eclipse.ccg.java.model.MVisibility;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAbstract Class Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAbstractClassMethodDeclarationImpl extends AbstractMImplementableMethodDeclarationImpl implements MAbstractClassMethodDeclaration {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final MVisibility VISIBILITY_EDEFAULT = MVisibility.PROTECTED_LITERAL;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected MVisibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAbstractClassMethodDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MABSTRACT_CLASS_METHOD_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAbstractDeclaredClass getOwner() {
		if (eContainerFeatureID != ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER) return null;
		return (MAbstractDeclaredClass)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(MAbstractDeclaredClass newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(MAbstractDeclaredClass newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID != ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS, MAbstractDeclaredClass.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MVisibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(MVisibility newVisibility) {
		MVisibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((MAbstractDeclaredClass)otherEnd, msgs);
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS, MAbstractDeclaredClass.class, msgs);
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				return getOwner();
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY:
				return getVisibility();
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				setOwner((MAbstractDeclaredClass)newValue);
				return;
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY:
				setVisibility((MVisibility)newValue);
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				setOwner((MAbstractDeclaredClass)null);
				return;
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
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
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER:
				return getOwner() != null;
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
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
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //MAbstractClassMethodDeclarationImpl