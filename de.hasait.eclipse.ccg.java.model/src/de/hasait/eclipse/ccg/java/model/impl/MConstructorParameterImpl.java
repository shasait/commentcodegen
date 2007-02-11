/**
 * <copyright>
 * </copyright>
 *
 * $Id: MConstructorParameterImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.MConstructor;
import de.hasait.eclipse.ccg.java.model.MConstructorParameter;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MConstructor Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MConstructorParameterImpl extends AbstractMTypeWithNameDeclarationImpl implements MConstructorParameter {
	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean final_ = FINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MConstructorParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MCONSTRUCTOR_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MConstructor getConstructor() {
		if (eContainerFeatureID != ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR) return null;
		return (MConstructor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstructor(MConstructor newConstructor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConstructor, ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructor(MConstructor newConstructor) {
		if (newConstructor != eInternalContainer() || (eContainerFeatureID != ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR && newConstructor != null)) {
			if (EcoreUtil.isAncestor(this, newConstructor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConstructor != null)
				msgs = ((InternalEObject)newConstructor).eInverseAdd(this, ModelPackage.MCONSTRUCTOR__PARAMETERS, MConstructor.class, msgs);
			msgs = basicSetConstructor(newConstructor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR, newConstructor, newConstructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFinal() {
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinal(boolean newFinal) {
		boolean oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MCONSTRUCTOR_PARAMETER__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConstructor((MConstructor)otherEnd, msgs);
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				return basicSetConstructor(null, msgs);
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MCONSTRUCTOR__PARAMETERS, MConstructor.class, msgs);
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				return getConstructor();
			case ModelPackage.MCONSTRUCTOR_PARAMETER__FINAL:
				return isFinal() ? Boolean.TRUE : Boolean.FALSE;
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				setConstructor((MConstructor)newValue);
				return;
			case ModelPackage.MCONSTRUCTOR_PARAMETER__FINAL:
				setFinal(((Boolean)newValue).booleanValue());
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				setConstructor((MConstructor)null);
				return;
			case ModelPackage.MCONSTRUCTOR_PARAMETER__FINAL:
				setFinal(FINAL_EDEFAULT);
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
			case ModelPackage.MCONSTRUCTOR_PARAMETER__CONSTRUCTOR:
				return getConstructor() != null;
			case ModelPackage.MCONSTRUCTOR_PARAMETER__FINAL:
				return final_ != FINAL_EDEFAULT;
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
		result.append(" (final: ");
		result.append(final_);
		result.append(')');
		return result.toString();
	}

} //MConstructorParameterImpl