/**
 * <copyright>
 * </copyright>
 *
 * $Id: CIfStatementImpl.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractCExpression;
import de.hasait.eclipse.ccg.java.model.AbstractCStatement;
import de.hasait.eclipse.ccg.java.model.CIfStatement;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CIf Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl#getTrueStatement <em>True Statement</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl#getFalseStatement <em>False Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CIfStatementImpl extends AbstractCStatementImpl implements CIfStatement {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected AbstractCExpression condition = null;

	/**
	 * The cached value of the '{@link #getTrueStatement() <em>True Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueStatement()
	 * @generated
	 * @ordered
	 */
	protected AbstractCStatement trueStatement = null;

	/**
	 * The cached value of the '{@link #getFalseStatement() <em>False Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseStatement()
	 * @generated
	 * @ordered
	 */
	protected AbstractCStatement falseStatement = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CIfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CIF_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(AbstractCExpression newCondition, NotificationChain msgs) {
		AbstractCExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(AbstractCExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCStatement getTrueStatement() {
		return trueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueStatement(AbstractCStatement newTrueStatement, NotificationChain msgs) {
		AbstractCStatement oldTrueStatement = trueStatement;
		trueStatement = newTrueStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__TRUE_STATEMENT, oldTrueStatement, newTrueStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueStatement(AbstractCStatement newTrueStatement) {
		if (newTrueStatement != trueStatement) {
			NotificationChain msgs = null;
			if (trueStatement != null)
				msgs = ((InternalEObject)trueStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__TRUE_STATEMENT, null, msgs);
			if (newTrueStatement != null)
				msgs = ((InternalEObject)newTrueStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__TRUE_STATEMENT, null, msgs);
			msgs = basicSetTrueStatement(newTrueStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__TRUE_STATEMENT, newTrueStatement, newTrueStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCStatement getFalseStatement() {
		return falseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseStatement(AbstractCStatement newFalseStatement, NotificationChain msgs) {
		AbstractCStatement oldFalseStatement = falseStatement;
		falseStatement = newFalseStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__FALSE_STATEMENT, oldFalseStatement, newFalseStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseStatement(AbstractCStatement newFalseStatement) {
		if (newFalseStatement != falseStatement) {
			NotificationChain msgs = null;
			if (falseStatement != null)
				msgs = ((InternalEObject)falseStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__FALSE_STATEMENT, null, msgs);
			if (newFalseStatement != null)
				msgs = ((InternalEObject)newFalseStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CIF_STATEMENT__FALSE_STATEMENT, null, msgs);
			msgs = basicSetFalseStatement(newFalseStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CIF_STATEMENT__FALSE_STATEMENT, newFalseStatement, newFalseStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CIF_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case ModelPackage.CIF_STATEMENT__TRUE_STATEMENT:
				return basicSetTrueStatement(null, msgs);
			case ModelPackage.CIF_STATEMENT__FALSE_STATEMENT:
				return basicSetFalseStatement(null, msgs);
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
			case ModelPackage.CIF_STATEMENT__CONDITION:
				return getCondition();
			case ModelPackage.CIF_STATEMENT__TRUE_STATEMENT:
				return getTrueStatement();
			case ModelPackage.CIF_STATEMENT__FALSE_STATEMENT:
				return getFalseStatement();
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
			case ModelPackage.CIF_STATEMENT__CONDITION:
				setCondition((AbstractCExpression)newValue);
				return;
			case ModelPackage.CIF_STATEMENT__TRUE_STATEMENT:
				setTrueStatement((AbstractCStatement)newValue);
				return;
			case ModelPackage.CIF_STATEMENT__FALSE_STATEMENT:
				setFalseStatement((AbstractCStatement)newValue);
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
			case ModelPackage.CIF_STATEMENT__CONDITION:
				setCondition((AbstractCExpression)null);
				return;
			case ModelPackage.CIF_STATEMENT__TRUE_STATEMENT:
				setTrueStatement((AbstractCStatement)null);
				return;
			case ModelPackage.CIF_STATEMENT__FALSE_STATEMENT:
				setFalseStatement((AbstractCStatement)null);
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
			case ModelPackage.CIF_STATEMENT__CONDITION:
				return condition != null;
			case ModelPackage.CIF_STATEMENT__TRUE_STATEMENT:
				return trueStatement != null;
			case ModelPackage.CIF_STATEMENT__FALSE_STATEMENT:
				return falseStatement != null;
		}
		return super.eIsSet(featureID);
	}

} //CIfStatementImpl