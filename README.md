# UK Postcode Checker

https://github.com/agdturner/agdt-java-generic-UKPostcodeChecker/

A Java tool for checking Strings to see if they are in the format of a UK Postcode.

The UK National Statistics Postcode Lookup (NSPL) contains current and terminated postcodes for the UK. As of 2019, it has been updated usually four times per year for perhaps a decade. Another library has been developed for processing these data:
https://github.com/agdturner/agdt-java-generic-data-ONSPD

With this other library it is possible to check if a String is a current or terminated postcodes and to look up from a unit postcode to a range of other spatial regions. Postcodes change over time and are effectively a set of delivery point addresses, but these can be used to classify areas into distict simple non-overlapping polygons covering the UK.

## Usages
1. This tool is simply for checking if a given String is in a postcode format as described on the following Wikipedia article and in the refernece documentation: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom

## Code status and development roadmap
Version 1.0.0 of this code is available. It is unclear if another version of this code is needed.

## Dependencies
Please see the pom.xml for details.

## Contributions
Please raise issues and submit pull requests in the usual way. Contributions will be acknowledged.

## LICENCE
Please see the standard Apache 2.0 open source LICENCE.
