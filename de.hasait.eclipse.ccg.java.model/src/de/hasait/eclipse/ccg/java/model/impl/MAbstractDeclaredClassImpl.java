/**
 * <copyright>
 * </copyright>
 *
 * $Id: MAbstractDeclaredClassImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAbstract Declared Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractDeclaredClassImpl#getAbstractMethods <em>Abstract Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAbstractDeclaredClassImpl extends MDeclaredClassImpl implements MAbstractDeclaredClass {
	/**
	 * The cached value of the '{@link #getAbstractMethods() <em>Abstract Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractMethods()
	 * @generated
	 * @ordered
	 */
	protected EList abstractMethods = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAbstractDeclaredClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MABSTRACT_DECLARED_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAbstractMethods() {
		if (abstractMethods == null) {
			abstractMethods = new EObjectContainmentWithInverseEList(MAbstractClassMethodDeclaration.class, this, ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS, ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION__OWNER);
		}
		return abstractMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				return ((InternalEList)getAbstractMethods()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				return ((InternalEList)getAbstractMethods()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				return getAbstractMethods();
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
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				getAbstractMethods().clear();
				getAbstractMethods().addAll((Collection)newValue);
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
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				getAbstractMethods().clear();
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
			case ModelPackage.MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS:
				return abstractMethods != null && !abstractMethods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MAbstractDeclaredClassImpl