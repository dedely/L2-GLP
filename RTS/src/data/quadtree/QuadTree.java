package data.quadtree;

import process.visitor.QuadTreeVisitor;

/**
 * @author Adel
 *
 */
public interface QuadTree {
	QuadTree getNorthWest();

	QuadTree getNorthEast();

	QuadTree getSouthWest();

	QuadTree getSouthEast();

	<T> T accept(QuadTreeVisitor<T> visitor);

}