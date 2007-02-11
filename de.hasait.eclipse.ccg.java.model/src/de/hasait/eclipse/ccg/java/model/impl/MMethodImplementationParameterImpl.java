/**
 * <copyright>
 * </copyright>
 *
 * $Id: MMethodImplementationParameterImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation;
import de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter;
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
 * An implementation of the model object '<em><b>MMethod Implementation Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl#getMethodImplementation <em>Method Implementation</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMethodImplementationParameterImpl extends EObjectImpl implements MMethodImplementationParameter {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMethodImplementationParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MMETHOD_IMPLEMENTATION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMMethodImplementation getMethodImplementation() {
		if (eContainerFeatureID != ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION) return null;
		return (AbstractMMethodImplementation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodImplementation(AbstractMMethodImplementation newMethodImplementation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMethodImplementation, ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodImplementation(AbstractMMethodImplementation newMethodImplementation) {
		if (newMethodImplementation != eInternalContainer() || (eContainerFeatureID != ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION && newMethodImplementation != null)) {
			if (EcoreUtil.isAncestor(this, newMethodImplementation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMethodImplementation != null)
				msgs = ((InternalEObject)newMethodImplementation).eInverseAdd(this, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS, AbstractMMethodImplementation.class, msgs);
			msgs = basicSetMethodImplementation(newMethodImplementation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION, newMethodImplementation, newMethodImplementation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__FINAL, oldFinal, final_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMethodImplementation((AbstractMMethodImplementation)otherEnd, msgs);
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				return basicSetMethodImplementation(null, msgs);
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				return eInternalContainer().eInverseRemove(this, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS, AbstractMMethodImplementation.class, msgs);
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				return getMethodImplementation();
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__FINAL:
				return isFinal() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__NAME:
				return getName();
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				setMethodImplementation((AbstractMMethodImplementation)newValue);
				return;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__FINAL:
				setFinal(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__NAME:
				setName((String)newValue);
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				setMethodImplementation((AbstractMMethodImplementation)null);
				return;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
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
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION:
				return getMethodImplementation() != null;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__FINAL:
				return final_ != FINAL_EDEFAULT;
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MMethodImplementationParameterImpl