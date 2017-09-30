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

/**
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
public class Poly implements Cryto
{
    private  String sample;
    private  String cipher;
    private  String decipher;
    private  String key;

    public Poly(String cipher, String key) {
        this.cipher = cipher;
        this.key = key;
    }

    public Poly(String sample, String cipher, String key) {
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

    @Override
    public String getCipher() {
        char[] c ,k ,s;
        c = new char[sample.length()];
        s = sample.toCharArray();
        k = key.toCharArray();
        for(int i=0 ; i<s.length ; i++)
	{
		if(s[i] >= 'a' && s[i] <= 'z')
		{
			c[i] = (char)( ( (int)( (int)( s[i]-'a' ) + ((int)k[i%k.length]-'a') ) % 26 ) + 'a');
		}
		else if(s[i] >= 'A' && s[i] <= 'Z')
		{
			c[i] = (char)( ( (int)( (int)( s[i]-'A' ) + ((int)k[i%k.length]-'a') ) % 26 ) + 'A');
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
    public String getDecipher() {
        char[] d ,k ,c;
        d = new char[cipher.length()];
        c = cipher.toCharArray();
        k = key.toCharArray();
        for(int i=0 ; i<c.length ; i++)
	{
		if(c[i] >= 'a' && c[i] <= 'z')
		{
			d[i] = (char)( ( ( (int)( (int)( c[i]-'a' ) - ((int)k[i%k.length]-'a') )% 26 ) + 26 ) %26 + 'a');
		}
		else if(c[i] >= 'A' && c[i] <= 'Z')
		{
			d[i] = (char)( ( ( (int)( (int)( c[i]-'A' ) - ((int)k[i%k.length]-'A') )% 26 ) + 26 ) %26 + 'A');
		}
		else
		{
			d[i] = '!';
		}
	}
        decipher = String.copyValueOf(d);
        return decipher;
    }

    @Override
    public String toString() {
        return "Poly{" + "sample=" + sample + ", cipher=" + cipher + ", decipher=" + decipher + ", key=" + key + '}';
    }
    

    public String getKey() {
        return key;
    }
}
