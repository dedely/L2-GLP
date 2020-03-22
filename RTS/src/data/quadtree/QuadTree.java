package data.quadtree;

import process.visitor.QuadTreeVisitor;

/**
 * General definition of a QuadTree node.
 * The QuadTree structure is used to store spatial data.
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