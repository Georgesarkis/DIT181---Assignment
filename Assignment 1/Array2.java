package assignment1;

class Array2 {
  private final int max_elements = 200;
  private int size = 0;
  private int[] arr;

  public Array2(int n) {
    if (n < 0 || n > max_elements)
      throw new IllegalArgumentException("Array size must be non-negative");
    arr = new int[max_elements];
    size = n;
  }

  public int size() {
    return size;
  }

  // Set the i-th element to x
  // We are not checking whether the index is
  // in bounds, because dereferencing the array
  // element does it for us.
  public void set(int i, int x) {
    arr[i] = x;
  }

  // Get the i-th element
  // Again, we are not checking if the index
  // is in bounds.
  public int get(int i) {
    return arr[i];
  }

  // Reverse the array
  public void reverse() { // the complexity of it is n/2 big O notation is O(n/2)
	  for(int i = 0; i < size/2 ; i++) {
		  int temp = arr[i]; 
		  arr[i] = arr[size -i -1]; 
		  arr[size -i -1] = temp;
	  }
  }

  // Find the maximum odd number in the array. Return -1
  // if there are no odd numbers.
  public int maxOdd() { //the complexity is O(n)
	  int oddnum = 0;
	  for(int i = 0 ; i < arr.length; i++) {
		  if(arr[i] % 2 != 0) {
			  oddnum++;
		  }
	  } 
	  return oddnum;
  }

  // Remove the element of index i from the array.
  public void remove(int i) { // the complexity of the method is n-1-i and big O notation is O(n)
	  for(int j = i; j < arr.length -1 ; j++) {
			arr[j] = arr[j+1];
		  }
	  this.size = size -1;
  }

  // Remove the element of index i from the array.
  // This method may change the order of the other
  // elements of the array.
  public void remove2(int i) {// in this way we made the last element the element that we want to remove and complexity of this is O(1)
	  arr[i] = arr[size-1];
	  this.size = size-1;
  }

  // Return the index of the first occurrence of x in the array,
  // or -1 if x does not occur.
  public int find(int x) {// the complexity of the method is O(n) and it cant be more officiant since the array is not sorted and we have to go throw all array to find it
    for(int i = 0 ; i < size ; i++) {
    	if(arr[i]== x) {
    		return i;
    	}
    }
    return -1;
  }

  // Find the length of the longest palindrome that is
  // a contiguous subsequence of the array. A palindrome
  // is a word of the form ABCBA (length 5) or ABCCBA
  // (length 6).
  public int maxPalindrome() {
	  int count = 0;
	  for(int i = 1; i < size-1;i++) {
		  int incount = 0;
		  int ilow = i-1;
		  int ihig = i+1;
		  try {
			  
			  if(arr[i]==arr[ilow]) {
				  int jlow = ilow;
				  int jhig = i;
				  while(jhig < size) {
					  if(arr[jlow] == arr[jhig]) {
						  incount++;
					  }
					  jhig++;
					  jlow--;
				  }
				  if(count < incount) {
					  count = incount;
				  }
			  }
			  
			  else if(arr[i]==arr[ihig]) {
				  int jlow = i;
				  int jhig = ihig;
				  while(jhig < size) {
					  if(arr[jlow] == arr[jhig]) {
						  incount++;
					  }
					  jhig++;
					  jlow--;
				  }
				  if(count < incount) {
					  count = incount;
				  }
			  }
			  
			  else if(arr[ihig]== arr[ilow]) {
				  incount++;
				  int jlow = ilow;
				  int jhig = ihig;
				  while(jhig < size) {
					  if(arr[jlow] == arr[jhig]) {
						  incount++;
					  }
					  jhig++;
					  jlow--;
				  }
				  if(count < incount) {
					  count = incount;
				  }
			  }
			  
			  else {
				  if(incount > count) {
					  count = incount;
				  }
			  }
		  }catch(Exception e){
			  if(incount > count) {
				  count = incount;
			  }
		  }
	  }
                  	  return count;
  }
  


 /*
  This is Done my Majed Dalain 
  Return the maximum sum of all contiguous subarrays of the array.
  */
  public int maxInterval() {

  	     int l = arr[0];

  	     int h = arr[arr.length-1];

  	
  	    if(l == h) return a[l]; // base case where the array has only one element. 

  		int mid = (l + h) / 2;

  		int leftMaxSum = maxInterval(a,l,mid); // recursive call for the left side or the array.
  		int rihgtMaxSum = maxInterval(a,mid+1,h); // recursice call for the right side of tha array. 

  		int sum = 0;
  		int leftBorderSum = 0;
  		for(int i = mid; i>= l; i--){
  			sum += a[i];
  			if(sum>leftBorderSum)
  				leftBorderSum= sum;
  		}
  		int sum1 = 0;
  		int rightBorderSum= 0;
  		for (int i = mid+1; i<=h;i++){
  			sum1+= a[i];
  			if(sum1 > rightBorderSum)
  				rightBorderSum = sum1;
  		}

  		return Math.max(Math.max(leftMaxSum,rihgtMaxSum),leftBorderSum+rightBorderSum);
  }
  

  // Return the index of the lowest element of the array,
  // assuming that the array contains a cyclic shift of
  // a non-decreasing sequence.
  public int findSplice() {

  	     int l = arr[0];
  	     int h = arr[arr.length-1];

  	    if (h < l)  return 0;
 
        // If there is only one element left
        if (h == l) return l;
 
        // Find mid
        int mid = l + (h - l)/2; /*(low + high)/2;*/
 
        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < h && arr[mid+1] < arr[mid])
            return mid+1;
 
        // Check if mid itself is minimum element
        if (mid > l && arr[mid] < arr[mid - 1])
            return mid;
 
        // Decide whether we need to go to left half or right half
        if (arr[h] > arr[mid])
            return findSplice(arr, l, mid-1);
        return findSplice(arr, mid+1, h);
        
  }

  // Return the median value of an array.
  public int median() {
	  int median = 0;
	  int pivot = arr[0];
	  
	  for(int i = 0; i < size ; i++) {
		  if(arr[i] < pivot) {
			  int temp = arr[i];
			  arr[i] = arr[size-1];
			  arr[size-1] = temp;
		  }
	  }
	  
	  int position = find(pivot);
	  
	  
	  if(position== size/2 ) {
		  median = position;
	  }
	  
	  
	  else if(position < size/2) {
		   for(int i = position ; i < size ; i++) {
			   if(arr[i] < arr[i+1]) {
					  int temp = arr[i];
					  arr[i] = arr[i+1];
					  arr[i+1] = temp;
				  } 
		   }
		   median = arr[size/2];
	  }
	  
	  
	  else if(position > size/2) {
		  for(int i = 0 ; i < size - position ; i++) {
			  if(arr[i] < arr[i+1]) {
				  int temp = arr[i];
				  arr[i] = arr[i+1];
				  arr[i+1] = temp;
			  } 
		   }
		  median = arr[size/2];
	  }
	  return median;
  }
  
}
