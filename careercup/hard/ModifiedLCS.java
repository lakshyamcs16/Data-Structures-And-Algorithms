package careercup.hard;


public class ModifiedLCS {

	class SubseqCounter {

	    String seq, subseq;
	    int[][] tbl;

	    public SubseqCounter(String seq, String subseq) {
	        this.seq = seq;
	        this.subseq = subseq;
	    }

	    public int countMatches() {
	        tbl = new int[seq.length() + 1][subseq.length() + 1];
	        int col = 0;
	        for (int row = 0; row < tbl.length; row++) 
	            for ( col = 0; col < tbl[row].length; col++) 
	                tbl[row][col] = countMatchesFor(row, col);
	                

	        return tbl[seq.length()][subseq.length()];
	    }

	    private int countMatchesFor(int seqDigitsLeft, int subseqDigitsLeft) {
	        if (subseqDigitsLeft == 0)
	            return 1;

	        if (seqDigitsLeft == 0)
	            return 0;

	        char currSeqDigit = seq.charAt(seq.length()-seqDigitsLeft);
	        char currSubseqDigit = subseq.charAt(subseq.length()-subseqDigitsLeft);

	        int result = 0;

	        if (currSeqDigit == currSubseqDigit) {
	            result += tbl[seqDigitsLeft - 1][subseqDigitsLeft - 1];
	        }

	        result += tbl[seqDigitsLeft - 1][subseqDigitsLeft];

	        return result;
	    }
	}
	
	public static void main(String[] args) {
		ModifiedLCS lcs = new ModifiedLCS();
		String parent = "ABABDCAD";
		String child  = "ABD";
		
		System.out.println(lcs.new SubseqCounter(parent, child).countMatches());
				
	}
	
	
}
