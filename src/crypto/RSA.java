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

import static java.lang.Math.pow;

/**
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
public class RSA implements Cryto
{
    private  String sample;
    private  String cipher;
    private  String decipher;
    private  int key_d , key_e , key_n , key_k;
     
    public RSA() {
    
    }

    public RSA(String sample, String cipher, int key_d, int key_e, int key_n, int key_k) {
        this.sample = sample;
        this.cipher = cipher;
        this.key_d = key_d;
        this.key_e = key_e;
        this.key_n = key_n;
        this.key_k = key_k;
    }

    public RSA(String cipher, int key_d, int key_n) {
        this.cipher = cipher;
        this.key_d = key_d;
        this.key_n = key_n;
    }

    @Override
    public String toString() {
        return "RSA{" + "sample=" + sample + ", cipher=" + cipher + ", decipher=" + decipher + ", key_d=" + key_d + ", key_e=" + key_e + ", key_n=" + key_n + ", key_k=" + key_k + '}';
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
        int c;
        c = (int)((pow(sample.charAt(0)-'a',key_e))%key_n);
        cipher = String.valueOf((c));
        return cipher;
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    @Override
    public String getDecipher() 
    {
        int d;
	d = (int) (pow(cipher.charAt(0),key_d)%key_n);
        decipher = String.valueOf((char)(d+'a'));
        return decipher;
    }
    
    
    public int getKey_d() {
        return key_d;
    }

    public void setKey_d(int key_d) {
        this.key_d = key_d;
    }

    public int getKey_e() {
        return key_e;
    }

    public void setKey_e(int key_e) {
        this.key_e = key_e;
    }

    public int getKey_n() {
        return key_n;
    }

    public void setKey_n(int key_n) {
        this.key_n = key_n;
    }

    public int getKey_k() {
        return key_k;
    }

    public void setKey_k(int key_k) {
        this.key_k = key_k;
    }
    
    
}
