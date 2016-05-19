/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contentspam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Maheswari
 */
public class features_from_dataset {    
    static float HST_1=0,HST_2=0,HST_3=0,HST_4=0,HST_5=0,HST_6 = 0;

    public  void retun(String url) throws FileNotFoundException, IOException
    {
         String csvFile ="C:\\Users\\ANANDRAJ\\Documents\\NetBeansProjects\\Webspam\\sample2006.csv" ;
	BufferedReader br = null;
    String line = "";
	String cvsSplitBy = ",";
    
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
                {    
			String[] s = line.split(cvsSplitBy);
                        if(s[1].equals(url))
                        {   
                            HST_1=Float.parseFloat(s[3]);       //from the training set
                            HST_2=Float.parseFloat(s[4]);
                            HST_3=Float.parseFloat(s[5]);
                            HST_4=Float.parseFloat(s[6]);
                            HST_5=Float.parseFloat(s[7]);
                            HST_6=Float.parseFloat(s[8]);
                        }
                }
     
  br.close();   
    }
    
}
