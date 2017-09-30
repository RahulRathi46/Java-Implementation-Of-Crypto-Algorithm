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
public class DiffieHellman implements Cryto {
    
    private  String sample;
    private  String cipher;
    private  String decipher;
    private  int key_p,key_base,key_Secret;

    public DiffieHellman() {
    }

    public DiffieHellman(int key_p, int key_base, int key_Secret) {
        this.key_p = key_p;
        this.key_base = key_base;
        this.key_Secret = key_Secret;
    }

    public DiffieHellman(String cipher, int key_p, int key_Secret) {
        this.cipher = cipher;
        this.key_p = key_p;
        this.key_Secret = key_Secret;
    }

    @Override
    public String toString() {
        return "DiffieHellman{" + "sample=" + sample + ", cipher=" + cipher + ", decipher=" + decipher + ", key_p=" + key_p + ", key_base=" + key_base + ", key_Secret=" + key_Secret + '}';
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
        int A = (int) (pow(key_base,key_Secret)%key_p);
        cipher = String.valueOf(A);
        return cipher;
    }

    @Override
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    @Override
    public String getDecipher() {
        int A = (int) (pow(Integer.parseInt(cipher),key_Secret)%key_p);
        decipher = String.valueOf(A);
        return decipher;
    }

    public int getKey_p() {
        return key_p;
    }

    public int getKey_base() {
        return key_base;
    }

    public int getKey_Secret() {
        return key_Secret;
    }
    
    

}
