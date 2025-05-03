
// Melhor Caso: Ω(1)
// Pior Caso: O(log n)
int binarySearchIterative(int array[], int size, int key) {

    int low = 0;
    int height = size - 1;

    while (low <= height) {
        
        int mid = (low + height) / 2;

        if (key == array[mid])
            return mid;
        
        if (key < array[mid]) 
            height = mid - 1;
        
        if (key > array[mid])
            low = mid + 1; 
    }
    return -1;
}