
typedef struct AdjacencyMatrix {
    int **matrix;
    int numberVertices;
    int numberEdges;
    int directed;
} AdjacencyMatrix;

AdjacencyMatrix *init_adjacency_matrix(int numberVetices, int isDirected);

void insert(AdjacencyMatrix *adjacencyMatrix, int source, int destination);

void remover(AdjacencyMatrix *adjacencyMatrix, int source, int destination);

void print_graph(AdjacencyMatrix adjacencyMatrix);