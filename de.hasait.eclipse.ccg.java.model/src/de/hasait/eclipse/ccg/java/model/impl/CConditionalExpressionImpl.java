/**
 * <copyright>
 * </copyright>
 *
 * $Id: CConditionalExpressionImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractCExpression;
import de.hasait.eclipse.ccg.java.model.CConditionalExpression;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CConditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl#getTrueExpression <em>True Expression</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl#getFalseExpression <em>False Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CConditionalExpressionImpl extends AbstractCExpressionImpl implements CConditionalExpression {
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
	 * The cached value of the '{@link #getTrueExpression() <em>True Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueExpression()
	 * @generated
	 * @ordered
	 */
	protected AbstractCExpression trueExpression = null;

	/**
	 * The cached value of the '{@link #getFalseExpression() <em>False Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseExpression()
	 * @generated
	 * @ordered
	 */
	protected AbstractCExpression falseExpression = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CConditionalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CCONDITIONAL_EXPRESSION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCExpression getTrueExpression() {
		return trueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueExpression(AbstractCExpression newTrueExpression, NotificationChain msgs) {
		AbstractCExpression oldTrueExpression = trueExpression;
		trueExpression = newTrueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION, oldTrueExpression, newTrueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueExpression(AbstractCExpression newTrueExpression) {
		if (newTrueExpression != trueExpression) {
			NotificationChain msgs = null;
			if (trueExpression != null)
				msgs = ((InternalEObject)trueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION, null, msgs);
			if (newTrueExpression != null)
				msgs = ((InternalEObject)newTrueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION, null, msgs);
			msgs = basicSetTrueExpression(newTrueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION, newTrueExpression, newTrueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCExpression getFalseExpression() {
		return falseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseExpression(AbstractCExpression newFalseExpression, NotificationChain msgs) {
		AbstractCExpression oldFalseExpression = falseExpression;
		falseExpression = newFalseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION, oldFalseExpression, newFalseExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseExpression(AbstractCExpression newFalseExpression) {
		if (newFalseExpression != falseExpression) {
			NotificationChain msgs = null;
			if (falseExpression != null)
				msgs = ((InternalEObject)falseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION, null, msgs);
			if (newFalseExpression != null)
				msgs = ((InternalEObject)newFalseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION, null, msgs);
			msgs = basicSetFalseExpression(newFalseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION, newFalseExpression, newFalseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION:
				return basicSetCondition(null, msgs);
			case ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION:
				return basicSetTrueExpression(null, msgs);
			case ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION:
				return basicSetFalseExpression(null, msgs);
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
			case ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION:
				return getCondition();
			case ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION:
				return getTrueExpression();
			case ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION:
				return getFalseExpression();
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
			case ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION:
				setCondition((AbstractCExpression)newValue);
				return;
			case ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION:
				setTrueExpression((AbstractCExpression)newValue);
				return;
			case ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION:
				setFalseExpression((AbstractCExpression)newValue);
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
			case ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION:
				setCondition((AbstractCExpression)null);
				return;
			case ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION:
				setTrueExpression((AbstractCExpression)null);
				return;
			case ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION:
				setFalseExpression((AbstractCExpression)null);
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
			case ModelPackage.CCONDITIONAL_EXPRESSION__CONDITION:
				return condition != null;
			case ModelPackage.CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION:
				return trueExpression != null;
			case ModelPackage.CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION:
				return falseExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //CConditionalExpressionImpl