# [UK Postcode Checker](https://github.com/agdturner/agdt-java-UKPostcodeChecker/)

A Java tool for checking Strings to see if they might be viable UK unit, sector, district or area postcodes and for returning the type of unit, sector and district postcodes.

Postcodes are comprised of alphanumeric characters and take on one of a number of specific forms or types. This tool will efficiently check if Strings are of the right length, have the digits 0 to 9 and restricted sets of alphabetic characters in viable places, and can also return details of the form or type of a valid postcode.

There are two similar data sets that can be used for further checking UK postcodes:
1. The UK Office for National Statistics Postcode Directory (ONSPD) data - which contains current and terminated postcodes for the UK along with a details of what other geographical areas centroids of these poscodes are within.
2. The UK National Statistics Postcode Lookup (NSPL) data - which is similar to the ONSPD, but uses a different method for attributing which other areas a postcode is within.

Details of the ONSPD and NSPL can be found via:
https://www.ons.gov.uk/methodology/geography/geographicalproducts/postcodeproducts

The developer has engineered another Java library for processing these data:
https://github.com/agdturner/agdt-java-generic-data-UKPostcode

With this other library Strings can effectively be checked against sets of postcodes to not only check if the String is in a viable format, but that it is also in use at specific points in time. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

In the UK, postcodes have been used for around 50 years. Each postcode effectively represents a set of delivery point addresses. The definitions of postcodes can change over time relating to the challenges of delivering mail to these addresses. As the UK and the demands of deivering mail change over time, so do postcodes. New postcodes come into use, old postcodes are retired or terminated, and delivery addresses are added to, removed from and swapped between existing postcodes.

## Usages
1. This tool can check if Strings are in a viable UK unit, sector, district or area postcode format as described on the following Wikipedia article and it's reference documentation: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom. This will check if each given string has the digits 0 to 9 in viable places and restricted sets of alphabetic characters in the right place.
2. This provides a quick check which is usually faster than comparing a String against a list of expected postcodes. A more thorough check of Strings against sets of postcodes can be done using another Java library: 
https://github.com/agdturner/agdt-java-generic-data-UKPostcode. This other library makes it convenient to look up coordinates of centroids of unit postcodes and what other spatial regions that postcode is recorded as being situated in.

## Latest Version
```
<!-- https://mvnrepository.com/artifact/io.github.agdturner/agdt-java-UKPostcodeChecker -->
<dependency>
    <groupId>io.github.agdturner</groupId>
    <artifactId>agdt-java-generic-UKPostcodeChecker</artifactId>
    <version>1.0</version>
</dependency>
```
[JAR](https://repo1.maven.org/maven2/io/github/agdturner/agdt-java-UKPostcodeChecker/1.0/agdt-java-UKPostcodeChecker-1.0.jar)

## Dependencies
- Developed and tested on Java 14.
- There are no third party dependencies.
- There are third party dependencies for testing.
- Please see the [POM](https://github.com/agdturner/agdt-java-generic/blob/master/pom.xml) for details.

## Development Roadmap
- There are no feature requests or issues reported as yet.
- There is no target release date.

## Contributions
- Please report issues in the usual way.
- Please liaise with the developer with regards feature requests and about contributing to development.

## LICENSE
- [APACHE LICENSE, VERSION 2.0](https://www.apache.org/licenses/LICENSE-2.0)
