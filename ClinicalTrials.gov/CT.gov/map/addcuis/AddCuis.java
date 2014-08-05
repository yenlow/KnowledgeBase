package map.addcuis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.pitt.coder.NobleCoder;

public class AddCuis {
	
	public AddCuis() {
		
	}
	
	public boolean addCuis(String input, String output) {
		
		
		
		try {
		
			BufferedReader in = new BufferedReader(new FileReader(input));
			ArrayList<String> line = new ArrayList<String>(Arrays.asList(in.readLine().split("\t")));
			insert(line, 7, "MeSH_CUI");
			insert(line, 2, "MedDRA_CUI");
			insert(line, 2, "SNOMED_CUI");
			insert(line, 2, "RxNorm_CUI");
			
			System.out.println(line);
			
			NobleCoder nc = new NobleCoder();
			
			
			
			while(in.ready()) {
				
				insert(line, 7, "MeSH_CUI");
				insert(line, 2, "MedDRA_CUI");
				insert(line, 2, "SNOMED_CUI");
				insert(line, 2, "RxNorm_CUI");
				
			}
			
			in.close();
		
		} catch(IOException e) {
			return false;
		}
			
		return true;
		
	}
	
	private void insert(List<String> line, int index, String add) {
		line.add(index, add);
	}
	
	private String outputString(List<String> string) {
		
		StringBuffer buf = new StringBuffer();
		int lastIndex = string.size() - 1;
		
		for(int i=0;i<string.size();++i) {
			buf.append(string.get(i));
			if(i < lastIndex)
				buf.append("\t");
			else
				return buf.toString();
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		
		final String inputfile = "../Example-CT.gov-data-v3-v011.csv";
		final String outputfile = "../Example-CT.gov-data-v3-v011_CUIs.csv";
		
		AddCuis add = new AddCuis();
		add.addCuis(inputfile, outputfile);
		
	}

}
