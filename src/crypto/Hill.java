/*
 * Copyright (C) 2017 Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package crypto;

import java.util.Arrays;

/**
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
public class Hill implements Cryto
{
    private  String sample;
    private  String cipher;
    private  String decipher;
    private  String key;
    private  int[][] matrix_inv = new int[2][2];
    private  int[][] matrix = new int[2][2];

    public Hill(String cipher, String key) {
        this.cipher = cipher;
        this.key = key;
    }

    public Hill(String sample, String cipher, String key) {
        this.sample = sample;
        this.cipher = cipher;
        this.key = key;
    }
    

    @Override
    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getSample() {
        return sample;
    }
    
    private void Matrix()
    {
        char[] k = key.toCharArray();
        // Matrix
	matrix[0][0] = k[0] - 'a';
	matrix[0][1] = k[1] - 'a';
	matrix[1][0] = k[2] - 'a';
	matrix[1][1] = k[3] - 'a';
	
	
	// Matrix Inverse
	int det = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
	for(int i=0 ; i<26 ; i++ )
	{
		if( det*i%26 == 1 ) 
		{
			det = i;
			break;
		}
	}
	matrix_inv[0][0] =    ( det*matrix[1][1])%26;
	matrix_inv[0][1] =  (-(det*matrix[0][1]))%26;
	matrix_inv[1][0] =  (-(det*matrix[1][0]))%26;
	matrix_inv[1][1] =    ( det*matrix[0][0])%26;
    }
    
    @Override
    public String getCipher() {
        int [] c , s; 
        c = new int[2];
        s = new int[sample.length()];
        for(int i=0 ; i< 2 ; i++)
        {
            s[i] = sample.charAt(i);
            s[i] = (s[i] - 'a');
        }
        Matrix();
        c[0]=(s[0]*matrix[0][0] + s[1]*matrix[1][0])%26 ; 
	c[1]=(s[0]*matrix[0][1] + s[1]*matrix[1][1])%26 ; 
        cipher = Arrays.toString(c);
        return cipher;
    }

    @Override
    public String getDecipher() {
        int [] d , c ;
        char [] a = new char[2];
        c = new int[cipher.length()];
        d = new int[cipher.length()];
        String[] items = cipher.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] results = new int[items.length];
        for (int i = 0; i < items.length; i++) {
                try {
                        results[i] = Integer.parseInt(items[i]);
                    } 
                catch (NumberFormatException nfe) {

                    };
        }
        c[0] = results[0];
        c[1] = results[1];
        Matrix();
        d[0]=(c[0]*matrix_inv[0][0] + c[1]*matrix_inv[1][0])%26 ; 
	d[1]=(c[0]*matrix_inv[0][1] + c[1]*matrix_inv[1][1])%26 ;
        a[0] = (char) (d[0]+'a');
        a[1] = (char) (d[1]+'a');
        decipher = String.copyValueOf(a);
        return decipher;
    }

    @Override
    public String toString() {
        return "Hill{" + "sample=" + sample + ", cipher=" + cipher + ", decipher=" + decipher + ", key=" + key + '}';
    }

    public String getKey() {
        return key;
    }
    
}
