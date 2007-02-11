/**
 * <copyright>
 * </copyright>
 *
 * $Id: MMethodDeclarationParameterImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MMethod Declaration Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MMethodDeclarationParameterImpl#getMethodDeclaration <em>Method Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMethodDeclarationParameterImpl extends AbstractMTypeWithNameDeclarationImpl implements MMethodDeclarationParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMethodDeclarationParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MMETHOD_DECLARATION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMMethodDeclaration getMethodDeclaration() {
		if (eContainerFeatureID != ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION) return null;
		return (AbstractMMethodDeclaration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodDeclaration(AbstractMMethodDeclaration newMethodDeclaration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMethodDeclaration, ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodDeclaration(AbstractMMethodDeclaration newMethodDeclaration) {
		if (newMethodDeclaration != eInternalContainer() || (eContainerFeatureID != ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION && newMethodDeclaration != null)) {
			if (EcoreUtil.isAncestor(this, newMethodDeclaration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMethodDeclaration != null)
				msgs = ((InternalEObject)newMethodDeclaration).eInverseAdd(this, ModelPackage.ABSTRACT_MMETHOD_DECLARATION__PARAMETERS, AbstractMMethodDeclaration.class, msgs);
			msgs = basicSetMethodDeclaration(newMethodDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION, newMethodDeclaration, newMethodDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMethodDeclaration((AbstractMMethodDeclaration)otherEnd, msgs);
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				return basicSetMethodDeclaration(null, msgs);
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				return eInternalContainer().eInverseRemove(this, ModelPackage.ABSTRACT_MMETHOD_DECLARATION__PARAMETERS, AbstractMMethodDeclaration.class, msgs);
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				return getMethodDeclaration();
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				setMethodDeclaration((AbstractMMethodDeclaration)newValue);
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				setMethodDeclaration((AbstractMMethodDeclaration)null);
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
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION:
				return getMethodDeclaration() != null;
		}
		return super.eIsSet(featureID);
	}

} //MMethodDeclarationParameterImpl