# UK Postcode Checker

https://github.com/agdturner/agdt-java-generic-UKPostcodeChecker/

A Java tool for checking Strings to see if they are in the format of a UK Postcode.

The UK National Statistics Postcode Lookup (NSPL) contains current and terminated postcodes for the UK. As of 2019, it has been updated usually four times per year for perhaps a decade. Another library has been developed for processing these data:
https://github.com/agdturner/agdt-java-generic-data-ONSPD

With this other library Strings can be checked against active and terminated postcodes (for a given time) to check not only if the String is in the correct format, but also if it represents a postcode. In addition this other library makes it convenient in Java to look up from a unit postcode what other spatial regions that postcode is recorded as being situated in. Postcodes change over time and are effectively a set of delivery point addresses. This set of points can for the most part be used to classify the UK into distict simple non-overlapping contiguous areas. Others have done this work and have released a dataset demarking these unit postcode areas.

## Usages
1. This tool is simply for checking if a given String is in a postcode format as described on the following Wikipedia article and it's reference documentation: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom

## Code status and development roadmap
Version 1.0.0 of this code is available. It is unclear if another version of this code is needed.

## Dependencies
No third party libraries.
Please see the pom.xml for details.

## Contributions
Please raise issues and submit pull requests in the usual way. Contributions will be acknowledged.

## LICENCE
Please see the standard Apache 2.0 open source LICENCE.
