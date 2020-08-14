## Java-Implementation-Of-Crypto-Algorithm

Motivation for this project is describe by the my faculty for end semester submitions. This project contains shift , Poly , Hill and Rsa crypto algos.

## Usage

``` 

            // ------------------------------------------------------------------ //
        
            System.out.println("\n1. Monoalphabtic Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto mono_alice = new shift("rahulrathi", "n/a", 3);
            sample = mono_alice.getCipher();
            System.out.println("Alice : " + mono_alice.toString()+ "\n");
            Cryto mono_bob = new shift(sample, 3);
            sample = mono_bob.getDecipher();
            System.out.println("Bob : "  + mono_bob.toString() + "\n");
        

            // ------------------------------------------------------------------ //
        
            System.out.println("\n2. Polyalphabtic Massage Exchange\n");

            // ------------------------------------------------------------------ //

            Cryto poly_alice = new Poly("rahulrathi", "n/a", "aaabc");
            sample = poly_alice.getCipher();
            System.out.println("Alice : " + poly_alice.toString()+ "\n");
            Cryto poly_bob = new Poly(sample,"aaabc");
            sample = poly_bob.getDecipher();
            System.out.println("Bob : "  + poly_bob.toString() + "\n");
   
```
