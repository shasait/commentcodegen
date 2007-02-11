/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractModifiersImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractModifiers;
import de.hasait.eclipse.ccg.java.model.MVisibility;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Modifiers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl#isSynchronized <em>Synchronized</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractModifiersImpl extends EObjectImpl implements AbstractModifiers {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final MVisibility VISIBILITY_EDEFAULT = MVisibility.PUBLIC_LITERAL;

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
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

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
	 * The default value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected boolean synchronized_ = SYNCHRONIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractModifiersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_MODIFIERS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MODIFIERS__VISIBILITY, oldVisibility, visibility));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MODIFIERS__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSynchronized() {
		return synchronized_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronized(boolean newSynchronized) {
		boolean oldSynchronized = synchronized_;
		synchronized_ = newSynchronized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MODIFIERS__SYNCHRONIZED, oldSynchronized, synchronized_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MODIFIERS__VISIBILITY:
				return getVisibility();
			case ModelPackage.ABSTRACT_MODIFIERS__FINAL:
				return isFinal() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ABSTRACT_MODIFIERS__SYNCHRONIZED:
				return isSynchronized() ? Boolean.TRUE : Boolean.FALSE;
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
			case ModelPackage.ABSTRACT_MODIFIERS__VISIBILITY:
				setVisibility((MVisibility)newValue);
				return;
			case ModelPackage.ABSTRACT_MODIFIERS__FINAL:
				setFinal(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ABSTRACT_MODIFIERS__SYNCHRONIZED:
				setSynchronized(((Boolean)newValue).booleanValue());
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
			case ModelPackage.ABSTRACT_MODIFIERS__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case ModelPackage.ABSTRACT_MODIFIERS__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case ModelPackage.ABSTRACT_MODIFIERS__SYNCHRONIZED:
				setSynchronized(SYNCHRONIZED_EDEFAULT);
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
			case ModelPackage.ABSTRACT_MODIFIERS__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case ModelPackage.ABSTRACT_MODIFIERS__FINAL:
				return final_ != FINAL_EDEFAULT;
			case ModelPackage.ABSTRACT_MODIFIERS__SYNCHRONIZED:
				return synchronized_ != SYNCHRONIZED_EDEFAULT;
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
		result.append(", final: ");
		result.append(final_);
		result.append(", synchronized: ");
		result.append(synchronized_);
		result.append(')');
		return result.toString();
	}

} //AbstractModifiersImpl