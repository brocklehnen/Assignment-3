/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3.pkg232;

/**
 *
 * @author Britt
 */
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Vector;

class Edge implements Comparable<Edge>
{
    int vertexA, vertexB;
    int weight;

    public Edge(int vertexA, int vertexB, int weight)
    {

        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;

    }
    public char getVertexA()
    {
        return (char)(vertexA+65);
    }
    public int getVertexB()
    {
        return (char)(vertexA+65);
    }
    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "(" + (char)(vertexA + 65) + ", " + (char)(vertexB + 65) + ") : Weight = " + weight;
    }

    @Override
    public int compareTo(Edge edge)
    {
        return this.weight < edge.weight ? -1: 1;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Edge)) return false;
        Edge e = (Edge) other;
        return weight == e.weight && vertexA == e.vertexA && vertexB == e.vertexB;
    }
}

class KruskalEdges
{
    Vector<HashSet<String>> vertexGroups;
    TreeSet<Edge> kruskalEdges = new TreeSet<>();

    KruskalEdges()
    {
        this.vertexGroups = new Vector<>();
    }

    public TreeSet<Edge> getEdges()
    {
        return kruskalEdges;
    }

    HashSet<String> getVertexGroup(String vertex)
    {
        for (HashSet<String> vertexGroup : vertexGroups)
        {
            if (vertexGroup.contains(vertex)) 
            {
                return vertexGroup;
            }
        }
        return null;
    }

    public void insertEdge(Edge edge)
    {
        String vertexA = "" + edge.getVertexA();
        String vertexB = "" + edge.getVertexB();

        if (edge.getWeight() <= 0) return;

        HashSet<String> vertexGroupA = getVertexGroup(vertexA);
        HashSet<String> vertexGroupB = getVertexGroup(vertexB);

        if (vertexGroupA == null) 
        {
            if (vertexGroupB == null) 
            {
                HashSet<String> htNewVertexGroup = new HashSet<>();
                htNewVertexGroup.add(vertexA);
                htNewVertexGroup.add(vertexB);
                vertexGroups.add(htNewVertexGroup);
                kruskalEdges.add(edge);
            } 
            else 
            {
                vertexGroupB.add(vertexA);
                kruskalEdges.add(edge);
            }
        } 
        else 
        {
            if (vertexGroupB == null)
            {
                vertexGroupA.add(vertexB);
                kruskalEdges.add(edge);
            } 
            else if (!vertexGroupA.equals(vertexGroupB))
            {
                vertexGroupA.addAll(vertexGroupB);
                vertexGroups.remove(vertexGroupB);
                kruskalEdges.add(edge);
            }
        }
    }
}
