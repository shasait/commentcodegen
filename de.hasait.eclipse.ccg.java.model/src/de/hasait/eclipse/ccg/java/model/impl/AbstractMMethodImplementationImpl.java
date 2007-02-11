/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMMethodImplementationImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation;
import de.hasait.eclipse.ccg.java.model.MDeclaredClass;
import de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter;
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
 * An implementation of the model object '<em><b>Abstract MMethod Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractMMethodImplementationImpl extends AbstractMMethodLikeImpl implements AbstractMMethodImplementation {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList parameters = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractMMethodImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_MMETHOD_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredClass getOwner() {
		if (eContainerFeatureID != ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER) return null;
		return (MDeclaredClass)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(MDeclaredClass newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(MDeclaredClass newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID != ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS, MDeclaredClass.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList(MMethodImplementationParameter.class, this, ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS, ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((MDeclaredClass)otherEnd, msgs);
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				return ((InternalEList)getParameters()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				return basicSetOwner(null, msgs);
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				return ((InternalEList)getParameters()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.MDECLARED_CLASS__IMPLEMENTED_METHODS, MDeclaredClass.class, msgs);
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				return getOwner();
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				return getParameters();
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				setOwner((MDeclaredClass)newValue);
				return;
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection)newValue);
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				setOwner((MDeclaredClass)null);
				return;
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				getParameters().clear();
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
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER:
				return getOwner() != null;
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractMMethodImplementationImpl