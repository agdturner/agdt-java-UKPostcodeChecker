# UK Postcode Checker

https://github.com/agdturner/agdt-java-generic-UKPostcodeChecker/

A Java tool for checking Strings to see if they might be viable UK unit, sector, district or area postcodes and for returning the type of unit, sector and district postcodes.

Postcodes take various forms comprised of alphanumeric characters. This tool will efficiently check if Strings are of the right length and have the digits 0 to 9 and restricted sets of alphabetic characters in viable places.

The UK National Statistics Postcode Lookup (NSPL) contains current and terminated postcodes for the UK. As of 2019, it has been updated usually four times per year and been made openly available for around a decade. Another Java library has been developed for processing these data:
https://github.com/agdturner/agdt-java-generic-data-ONSPD

With this other library Strings can effectively be checked against sets of active and terminated postcodes to not only check if the String is in a viable format, but that it also represents an active or terminated postcode at specific points in time. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

In the UK, postcodes have been used for around 50 years. They change over time and are effectively sets of delivery point addresses. These sets can for the most part be used to classify the UK into distict simple non-overlapping contiguous areas. Others have done this work and have released data demarking these unit, sector, district and area postcodes.

## Usages
1. This tool can check if Strings are in a viable UK unit, sector, district or area postcode format as described on the following Wikipedia article and it's reference documentation: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom. This will check if each given string has the digits 0 to 9 in viable places and restricted sets of alphabetic characters in the right place.
2. This provides a quick check which is usually faster than comparing a String against a list of expected postcodes. A more thorough check of Strings against sets of known and terminated postcodes can be done using another Java library: 
https://github.com/agdturner/agdt-java-generic-data-ONSPD. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

## Code status and development roadmap
Version 1.0.0 of this code is available.
There are no known issues, but another version of this code might be wanted in future - especially if there are changes to the format of UK postcodes which are under the control of Royal Mail and are primarily used for delivering post.

## Platform requirements
Whilst built using Java 11, this only uses basic and long standing Java functionality so it should be possible to compile the source using very early versions of the Java Standard Development Kit and run it on very early versions of the Java Runtime Environment.

## Dependencies
The compiled library requires nothing beyond a Java Runtime Environment.
The unit tests are written using JUnit 5. So there is a dependency on that for a fully tested build, but otherwise no other libraries are required.
Please see the pom.xml for details.

## Contributions
Please raise issues and submit pull requests in the usual way. Contributions will be acknowledged.

## LICENCE
Please see the standard Apache 2.0 open source LICENCE.
