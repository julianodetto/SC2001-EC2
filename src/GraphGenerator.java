public class GraphGenerator {
    public static void Generate(int Vertices, int Edges) {
        // Add Class Object to the parameter to run addEdge Function

        int [] edgeCount = new int[Vertices];
        double probability = (double) Edges / (double) (Vertices * (Vertices - 1) / 2);

        for ( int i = 0; i < Vertices; i++){
            if (Edges == 0) break;
            for ( int j = i+1; j < Vertices; j++){
                if (Edges == 0) break;
                if (Math.random() < probability){
                    // Create Edge

                    Edge newEdge = new Edge(i,j,10); // Generate random weight

                    // Run addEdge function on both class

                    edgeCount[i]++;
                    edgeCount[j]++;
                    Edges--;
                }
            }
        }

        // Check for isolated vertex

        for ( int i = 0; i < Vertices; i++) {
            if (edgeCount[i] == 0) {
                // Add a random edge so that it is not isolated
                int terminalVertex;
                do {
                    terminalVertex = (int) (Math.random() * Vertices);
                } while (terminalVertex == i);

                Edge newEdge = new Edge(i,terminalVertex,10); // Generate random weight

                // Run addEdge function on both class

                edgeCount[i]++;
                edgeCount[terminalVertex]++;

            }
        }

    }
}
