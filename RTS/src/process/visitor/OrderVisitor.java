package process.visitor;

import data.order.*;

public interface OrderVisitor<T> {

	T visit(Attack order);

	T visit(AttackBuilding order);

	T visit(AttackPosition order);

	T visit(Build order);

	T visit(CreateUnit order);

	T visit(Defend order);

	T visit(Embark order);

	T visit(MoveToPosition order);

	T visit(MoveToTarget order);
}