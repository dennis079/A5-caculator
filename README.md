# A5-caculator:

the function:
this calculator can do +-*/
it also can identify the signal "(" and ")"
The calculator's display automatically adjusts to font size.

something about test or other file:

the test result is in the file test_result.docx
if you want test again, you can use A.java to test it, it contain servel case.
the apk is in caculator\simple_calculator\app\build\outputs\apk\debug
also include a vide that I introduce the calculator

commont:

I am not sure what does the requirement of design diagram want.
I know how to do it for the states machine, but for a calculator I am refused.

architecture of my project:

This calculator is divided into three cases: the first input, not the first input, empty
"First Input" initializes the screen and displays the results of the last calculation.
"Non-first Input" will record what needs to be calculated, and "first input" will be returned after clearing or calculating results.
"Empty" will clear all content.

The algorithm is recursive.
This algorithm breaks down formulas with any "()" into smaller formulas.
When calculating an operation, he checks the first number of the formula, the first operation symbol and the second number.
It skips the "+-" operation until the "*/" operation is complete.
