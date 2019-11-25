# UK Postcode Checker

https://github.com/agdturner/agdt-java-generic-UKPostcodeChecker/

A Java tool for checking Strings to see if they might be viable UK unit, sector, district or area postcodes and for returning the type of unit, sector and district postcodes.

Postcodes are comprised of alphanumeric characters and take on one of a number of specific forms or types. This tool will efficiently check if Strings are of the right length, have the digits 0 to 9 and restricted sets of alphabetic characters in viable places, and can also return details of the form or type of a valid postcode.

There are two similar data sets that can be used for further checking UK postcodes:
1. The UK Office for National Statistics Postcode Directory (ONSPD) data - which contains current and terminated postcodes for the UK along with a details of what other geographical areas centroids of these poscodes are within.
2. The UK National Statistics Postcode Lookup (NSPL) data - which is similar to the ONSPD, but uses a different method for attributing which other areas a postcode is within.

Details of the ONSPD and NSPL can be found via:
https://www.ons.gov.uk/methodology/geography/geographicalproducts/postcodeproducts

Another Java library has been developed for processing these data:
https://github.com/agdturner/agdt-java-generic-data-UKPostcode

With this other library Strings can effectively be checked against sets of postcodes to not only check if the String is in a viable format, but that it is also in use at specific points in time. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

In the UK, postcodes have been used for around 50 years. Each postcode effectively represents a set of delivery point addresses. The definitions of postcodes can change over time relating to the challenges of delivering mail to these addresses. As the UK and the demands of deivering mail change over time, so do postcodes. New postcodes come into use, old postcodes are retired or terminated, and delivery addresses are added, removed and swapped between existing postcodes. Given the addresses, for the most part, the UK can be classified into distict simple non-overlapping contiguous regions. Others have done this work and have released data demarking these unit, sector, district and area postcodes regions.

## Usages
1. This tool can check if Strings are in a viable UK unit, sector, district or area postcode format as described on the following Wikipedia article and it's reference documentation: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom. This will check if each given string has the digits 0 to 9 in viable places and restricted sets of alphabetic characters in the right place.
2. This provides a quick check which is usually faster than comparing a String against a list of expected postcodes. A more thorough check of Strings against sets of postcodes can be done using another Java library: 
https://github.com/agdturner/agdt-java-generic-data-UKPostcode. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

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
