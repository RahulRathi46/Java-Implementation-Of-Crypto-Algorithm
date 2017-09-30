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
public class Demo5cryptotool {
    
    
        public String sample;
        private int option;

        public Demo5cryptotool() {
        }

    public Demo5cryptotool(int option) {
        if(option == 1)
        {
            introduction();
            shift();
            Poly();
            Hill();
            RSA();
            Diffiehellman();
        }
        else
        {
            System.out.println("\nDemo5Cryptotool :  This constructor design to all all function itself");
            System.out.println("\nDemo5Cryptotool :  You can call each demo sepraely by this call ");
            System.out.println("\nDemo5Cryptotool :  but this is not the best way. Use dafualt constructor insted");  
        }
    }
        
        
        
        public void introduction()
        {
            // ------------------------------------------------------------------ //

            System.out.println("\nIntroduction to the FiveCryptotool");
            System.out.println("\nDemonstration & Documentation included with jar");
            System.out.println("\nWritten by : Group No. 12 \nFor Subject : INS ( SEM 7 ) \n");

            // ------------------------------------------------------------------ //
        }
        
        public void shift()
        {
            // ------------------------------------------------------------------ //
        
            System.out.println("\n1. Monoalphabtic Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto mono_alice = new shift("rahulrathi", "n/a", 3);
            sample = mono_alice.getCipher();
            System.out.println("Alice : " + mono_alice.toString()+ "\n");
            Cryto mono_bob = new shift(sample, 3);
            sample = mono_bob.getDecipher();
            System.out.println("Bob : "  + mono_bob.toString() + "\n");
        }
        
        public void Poly()
        {
            // ------------------------------------------------------------------ //
        
            System.out.println("\n2. Polyalphabtic Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto poly_alice = new Poly("rahulrathi", "n/a", "aaabc");
            sample = poly_alice.getCipher();
            System.out.println("Alice : " + poly_alice.toString()+ "\n");
            Cryto poly_bob = new Poly(sample,"aaabc");
            sample = poly_bob.getDecipher();
            System.out.println("Bob : "  + poly_bob.toString() + "\n");
        }
        
        public void Hill()
        {
            // ------------------------------------------------------------------ //

            System.out.println("\n3. Hill Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto hill_alice = new Hill("bc","n/a","ddcf");
            sample = hill_alice.getCipher();
            System.out.println("Alice : " + hill_alice.toString()+ "\n");
            Cryto hill_bob = new Hill(sample,"ddcf");
            sample = hill_bob.getDecipher();
            System.out.println("Bob : "  + hill_bob.toString() + "\n");            
        }
        
        public void RSA()
        {
            // ------------------------------------------------------------------ //
        
            System.out.println("\n4. RSA Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto rsa_alice = new RSA("c", "n/a", 23, 7, 186, 160);
            sample = rsa_alice.getCipher();
            System.out.println("Alice : " + rsa_alice.toString()+ "\n");
            Cryto rsa_bob = new RSA(sample,23,186);
            sample = rsa_bob.getDecipher();
            System.out.println("Bob : "  + rsa_bob.toString() + "\n");            
        }
        
        public void Diffiehellman()
        {
            // ------------------------------------------------------------------ //

            System.out.println("\n5. Diffie-Hellman Exchange\n");

            // ------------------------------------------------------------------ //

            // Creating Objects as Init 
            Cryto alice = new DiffieHellman(23, 9, 4);
            Cryto bob = new DiffieHellman(23, 9, 3);
            String s_alice,s_bob; 
            s_bob = bob.getCipher();
            s_alice = alice.getCipher();
            System.out.println("Alice : " + alice.toString() + "\n");
            System.out.println("Bob : " + bob.toString() + "\n");

            // Creating Objects as reverse compute
            alice = new DiffieHellman(s_bob,23,4);
            bob = new DiffieHellman(s_alice,23,3);
            s_bob = alice.getDecipher();
            s_alice = bob.getDecipher();
            System.out.println("S compute by Alice : " + alice.toString() + "\n");
            System.out.println("S compute by Bob : " + bob.toString() + "\n");            
        }
}

