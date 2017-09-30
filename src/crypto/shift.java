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
public class shift implements Cryto
{
    private  String sample;
    private  String cipher;
    private  String decipher;
    private  int key;
   
    public shift() {
    
    }
    
    public shift(String sample, String cipher, int key) {
        this.sample = sample;
        this.cipher = cipher;
        this.key = key;
    }
    
    public shift(String cipher, int key) {
        this.cipher = cipher;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Crypto{" + "sample=" + sample + ", cipher=" + cipher + ", decipher=" + decipher + ", key=" + key + '}';
    }
    

    @Override
    public String getSample() {
        return sample;
    }

    @Override
    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String getCipher() {
        char[] c;
        c = new char[sample.length()];
        char[] s = sample.toCharArray();
        for(int i=0 ; i<s.length ; i++)
	{
		if(s[i] >= 'a' && s[i] <= 'z')
		{
			c[i] = (char) ((((s[i]-'a')+key)%26)+'a');
		}
		else if(s[i] >= 'A' && s[i] <= 'Z')
		{
			c[i] = (char) ((((s[i]-'A')+key)%26)+'A');
		}
		else
		{
			c[i] = '!';
		}
	}
        cipher = String.copyValueOf(c);
        return cipher;
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    @Override
    public String getDecipher() {
        char[] d;
        d = new char[cipher.length()];
        char[] c = cipher.toCharArray();
        for(int i=0 ; i<c.length ; i++)
	{
		if(c[i] >= 'a' && c[i] <= 'z')
		{
			c[i] = (char)( ( ( ( ( c[i]-'a' ) -key ) % 26 ) + 26 ) %26 + 'a');
		}
		else if(c[i] >= 'A' && c[i] <= 'Z')
		{
			c[i] = (char)( ( ( ( ( c[i]-'A' ) -key ) % 26 ) + 26 ) %26 + 'A');
		}
		else
		{
			c[i] = '!';
		}
	}
        decipher = String.copyValueOf(c);
        return decipher;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
