import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author Abdallah
 *
 */
public class TraversalGraph {

	private List<Character> vertices;
	private int[][] adjacencyMatrix;
	private Set<Character> visitedVertices;
	private Stack<Integer> verticesStack;
	private Queue<Integer> verticesQueue;
	private int componentCounter;

	public TraversalGraph(List<Character> vertices) {
		this.vertices = vertices;
		adjacencyMatrix = new int[vertices.size()][vertices.size()];
		visitedVertices = new HashSet<>();
		verticesStack = new Stack<>();
		verticesQueue = new LinkedList<>();
		componentCounter = 0;
	}

	private void clearSharedVariables() {
		visitedVertices.clear();
		componentCounter = 0;
	}

	/**
	 * Add edges to the adjacencyMatrix from vertex index i to vertex index j and
	 * vice versa
	 * 
	 * @param i
	 * @param j
	 */
	private void addEdges(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	/**
	 * Apply depth first search on the given graph
	 */
	private void applyDFS() {
		clearSharedVariables();
		visitedVertices.add(vertices.get(0));
		verticesStack.push(0);
		componentCounter++;
		System.out.println("Component[" + componentCounter + "]:");
		System.out.println(vertices.get(0));
		while (!verticesStack.isEmpty()) {
			int newVertexToExplore = -1;
			for (int i = 0; i < vertices.size(); i++) {
				if (adjacencyMatrix[verticesStack.peek()][i] == 1 && !visitedVertices.contains(vertices.get(i))) {
					newVertexToExplore = i;
					break;
				}
			}
			if (newVertexToExplore != -1) {
				visitedVertices.add(vertices.get(newVertexToExplore));
				verticesStack.push(newVertexToExplore);
				System.out.println(vertices.get(newVertexToExplore));
			} else {
				verticesStack.pop();
				checkForOtherComponentForDFS();
			}
		}
	}

	private void checkForOtherComponentForDFS() {
		if (verticesStack.isEmpty() && visitedVertices.size() != vertices.size()) {
			for (int i = 0; i < vertices.size(); i++) {
				if (!visitedVertices.contains(vertices.get(i))) {
					visitedVertices.add(vertices.get(i));
					verticesStack.push(i);
					componentCounter++;
					System.out.println("Component[" + componentCounter + "]:");
					System.out.println(vertices.get(i));
					break;
				}
			}
		}
	}

	/**
	 * Apply breadth first search on the given graph
	 */
	private void applyBFS() {
		clearSharedVariables();
		visitedVertices.add(vertices.get(0));
		verticesQueue.add(0);
		componentCounter++;
		System.out.println("Component[" + componentCounter + "]:");
		while (!verticesQueue.isEmpty()) {
			int queueHead = verticesQueue.poll();
			System.out.println(vertices.get(queueHead));
			for (int i = 0; i < vertices.size(); i++) {
				if (adjacencyMatrix[queueHead][i] == 1 && !visitedVertices.contains(vertices.get(i))) {
					visitedVertices.add(vertices.get(i));
					verticesQueue.add(i);
				}
			}
			if (verticesQueue.isEmpty()) {
				checkForOtherComponentForBFS();
			}
		}
	}

	private void checkForOtherComponentForBFS() {
		if (verticesQueue.isEmpty()) {
			for (int i = 0; i < vertices.size(); i++) {
				if (!visitedVertices.contains(vertices.get(i))) {
					visitedVertices.add(vertices.get(i));
					verticesQueue.add(i);
					componentCounter++;
					System.out.println("Component[" + componentCounter + "]:");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Character> vertices = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'));

		TraversalGraph traversalGraph = new TraversalGraph(vertices);
		// A - B
		traversalGraph.addEdges(0, 1);
		// A - C
		traversalGraph.addEdges(0, 2);
		// A - F
		traversalGraph.addEdges(0, 5);
		// B - F
		traversalGraph.addEdges(1, 5);
		// C - F
		traversalGraph.addEdges(2, 5);
		// C - G
		traversalGraph.addEdges(2, 6);
		// B - F
		traversalGraph.addEdges(1, 5);
		// D - E
		traversalGraph.addEdges(3, 4);
		// D - I
		traversalGraph.addEdges(3, 8);
		// E - I
		traversalGraph.addEdges(4, 8);
		// F - H
		traversalGraph.addEdges(5, 7);
		// G - H
		traversalGraph.addEdges(6, 7);

		System.out.println("********* Depth First Search (DFS) for our Graph *********");
		traversalGraph.applyDFS();
		System.out.println("\n\n********* Breadth First Search (BFS) for our Graph *********");
		traversalGraph.applyBFS();
	}
}
