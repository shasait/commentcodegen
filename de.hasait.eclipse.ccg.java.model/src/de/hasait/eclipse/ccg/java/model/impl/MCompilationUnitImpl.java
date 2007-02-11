/**
 * <copyright>
 * </copyright>
 *
 * $Id: MCompilationUnitImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType;
import de.hasait.eclipse.ccg.java.model.AbstractMType;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer;
import de.hasait.eclipse.ccg.java.model.MCompilationUnit;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MCompilation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MCompilationUnitImpl extends AbstractMResourceImpl implements MCompilationUnit {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList types = null;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList imports = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MCompilationUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MCOMPILATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTypes() {
		if (types == null) {
			types = new EObjectContainmentWithInverseEList(AbstractMDeclaredType.class, this, ModelPackage.MCOMPILATION_UNIT__TYPES, ModelPackage.ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList(AbstractMType.class, this, ModelPackage.MCOMPILATION_UNIT__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				return ((InternalEList)getTypes()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				return ((InternalEList)getTypes()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				return getTypes();
			case ModelPackage.MCOMPILATION_UNIT__IMPORTS:
				return getImports();
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
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection)newValue);
				return;
			case ModelPackage.MCOMPILATION_UNIT__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection)newValue);
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
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				getTypes().clear();
				return;
			case ModelPackage.MCOMPILATION_UNIT__IMPORTS:
				getImports().clear();
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
			case ModelPackage.MCOMPILATION_UNIT__TYPES:
				return types != null && !types.isEmpty();
			case ModelPackage.MCOMPILATION_UNIT__IMPORTS:
				return imports != null && !imports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == AbstractMTypeContainer.class) {
			switch (derivedFeatureID) {
				case ModelPackage.MCOMPILATION_UNIT__TYPES: return ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == AbstractMTypeContainer.class) {
			switch (baseFeatureID) {
				case ModelPackage.ABSTRACT_MTYPE_CONTAINER__TYPES: return ModelPackage.MCOMPILATION_UNIT__TYPES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //MCompilationUnitImpl