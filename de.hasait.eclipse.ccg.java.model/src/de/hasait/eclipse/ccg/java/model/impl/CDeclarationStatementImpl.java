/**
 * <copyright>
 * </copyright>
 *
 * $Id: CDeclarationStatementImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractCExpression;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeReference;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration;
import de.hasait.eclipse.ccg.java.model.CDeclarationStatement;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CDeclaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CDeclarationStatementImpl extends AbstractCStatementImpl implements CDeclarationStatement {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AbstractMTypeReference type = null;

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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected AbstractCExpression value = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CDeclarationStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CDECLARATION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMTypeReference getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(AbstractMTypeReference newType, NotificationChain msgs) {
		AbstractMTypeReference oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AbstractMTypeReference newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CDECLARATION_STATEMENT__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CDECLARATION_STATEMENT__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__TYPE, newType, newType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(AbstractCExpression newValue, NotificationChain msgs) {
		AbstractCExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(AbstractCExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CDECLARATION_STATEMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CDECLARATION_STATEMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CDECLARATION_STATEMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CDECLARATION_STATEMENT__TYPE:
				return basicSetType(null, msgs);
			case ModelPackage.CDECLARATION_STATEMENT__VALUE:
				return basicSetValue(null, msgs);
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
			case ModelPackage.CDECLARATION_STATEMENT__TYPE:
				return getType();
			case ModelPackage.CDECLARATION_STATEMENT__NAME:
				return getName();
			case ModelPackage.CDECLARATION_STATEMENT__FINAL:
				return isFinal() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.CDECLARATION_STATEMENT__VALUE:
				return getValue();
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
			case ModelPackage.CDECLARATION_STATEMENT__TYPE:
				setType((AbstractMTypeReference)newValue);
				return;
			case ModelPackage.CDECLARATION_STATEMENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CDECLARATION_STATEMENT__FINAL:
				setFinal(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.CDECLARATION_STATEMENT__VALUE:
				setValue((AbstractCExpression)newValue);
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
			case ModelPackage.CDECLARATION_STATEMENT__TYPE:
				setType((AbstractMTypeReference)null);
				return;
			case ModelPackage.CDECLARATION_STATEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CDECLARATION_STATEMENT__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case ModelPackage.CDECLARATION_STATEMENT__VALUE:
				setValue((AbstractCExpression)null);
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
			case ModelPackage.CDECLARATION_STATEMENT__TYPE:
				return type != null;
			case ModelPackage.CDECLARATION_STATEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CDECLARATION_STATEMENT__FINAL:
				return final_ != FINAL_EDEFAULT;
			case ModelPackage.CDECLARATION_STATEMENT__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == AbstractMTypeWithNameDeclaration.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CDECLARATION_STATEMENT__TYPE: return ModelPackage.ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE;
				case ModelPackage.CDECLARATION_STATEMENT__NAME: return ModelPackage.ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME;
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
		if (baseClass == AbstractMTypeWithNameDeclaration.class) {
			switch (baseFeatureID) {
				case ModelPackage.ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE: return ModelPackage.CDECLARATION_STATEMENT__TYPE;
				case ModelPackage.ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME: return ModelPackage.CDECLARATION_STATEMENT__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", final: ");
		result.append(final_);
		result.append(')');
		return result.toString();
	}

} //CDeclarationStatementImpl