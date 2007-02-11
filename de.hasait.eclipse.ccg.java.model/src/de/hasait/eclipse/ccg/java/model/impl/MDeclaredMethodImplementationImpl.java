/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredMethodImplementationImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDeclared Method Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredMethodImplementationImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDeclaredMethodImplementationImpl extends AbstractMMethodImplementationImpl implements MDeclaredMethodImplementation {
	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected AbstractMImplementableMethodDeclaration declaration = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MDeclaredMethodImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MDECLARED_METHOD_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMImplementableMethodDeclaration getDeclaration() {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject)declaration;
			declaration = (AbstractMImplementableMethodDeclaration)eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMImplementableMethodDeclaration basicGetDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(AbstractMImplementableMethodDeclaration newDeclaration, NotificationChain msgs) {
		AbstractMImplementableMethodDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(AbstractMImplementableMethodDeclaration newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS, AbstractMImplementableMethodDeclaration.class, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS, AbstractMImplementableMethodDeclaration.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				if (declaration != null)
					msgs = ((InternalEObject)declaration).eInverseRemove(this, ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS, AbstractMImplementableMethodDeclaration.class, msgs);
				return basicSetDeclaration((AbstractMImplementableMethodDeclaration)otherEnd, msgs);
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
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				return basicSetDeclaration(null, msgs);
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
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				if (resolve) return getDeclaration();
				return basicGetDeclaration();
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
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				setDeclaration((AbstractMImplementableMethodDeclaration)newValue);
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
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				setDeclaration((AbstractMImplementableMethodDeclaration)null);
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
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION__DECLARATION:
				return declaration != null;
		}
		return super.eIsSet(featureID);
	}

} //MDeclaredMethodImplementationImpl