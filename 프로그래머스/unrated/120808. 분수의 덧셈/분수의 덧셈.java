class Solution {
    
    public int gcd(int n1, int n2){
	    if(n1 % n2 == 0) {
		    return n2;
	    }
	    return gcd(n2, n1 % n2);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0, 0};
        
        int newNumer = numer1 * denom2 + numer2 * denom1;
        int newDenom = denom1 * denom2;
        
        int n = gcd(newNumer, newDenom);
        
        answer[0] = newNumer / n;
        answer[1] = newDenom / n;

        return answer;
    }
}