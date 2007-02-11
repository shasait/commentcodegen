/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMImplementableMethodDeclarationImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract MImplementable Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMImplementableMethodDeclarationImpl#getImplementations <em>Implementations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractMImplementableMethodDeclarationImpl extends AbstractMMethodDeclarationImpl implements AbstractMImplementableMethodDeclaration {
	/**
	 * The cached value of the '{@link #getImplementations() <em>Implementations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList implementations = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractMImplementableMethodDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getImplementations() {
		if (implementations == null) {
			implementations = new EObjectWithInverseResolvingEList(MDeclaredMethodImplementation.class, this, ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS, ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION);
		}
		return implementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				return ((InternalEList)getImplementations()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				return ((InternalEList)getImplementations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				return getImplementations();
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
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				getImplementations().clear();
				getImplementations().addAll((Collection)newValue);
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
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				getImplementations().clear();
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
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS:
				return implementations != null && !implementations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractMImplementableMethodDeclarationImpl