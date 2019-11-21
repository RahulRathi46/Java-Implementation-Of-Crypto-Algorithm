## Java-Implementation-Of-Crypto-Algorithm
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)


This is where your description should go. Try and limit it to a paragraph or two, and maybe throw in a mention of what
PSRs you support to avoid any confusion with users and contributors.

This is where your any motivation description should go. Try and limit it to a paragraph or two, and maybe some discription
on the objective of the project.


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

## Changelog

Please see [CHANGELOG](CHANGELOG.md) for more information on what has changed recently.

## Contributing

Please see [CONTRIBUTING](CONTRIBUTING.md)

## Security

If you discover any security related issues, please email :author_email instead of using the issue tracker.

## Credits

- [:author_name][link-author]
- [All Contributors][link-contributors]
