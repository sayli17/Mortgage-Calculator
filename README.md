# Mortgage-Calculator

This is a single-activity Android application using a handful of basic controls. 

The view will have the following elements:

1) Amount Borrowed
This will be a EditText into which the user will enter the amount to be borrowed as a floating-point value (e.g., “1000.00”).

2) Interest Rate
This will be a SeekBar ranging from 0.0 to 20.0, indicating the annual percentage rate of the interest. This value
should start at 10.0.

3) Loan Term
This will be a RadioGroup with the choices 15, 20, and 30, representing the number of years of the loan.

4) Taxes and Insurance
This will be a CheckBox that allows the user to select whether taxes and insurance are to be included in the
monthly payment.

5) Calculate
This will be a Button that, when pressed, will calculate the user’s monthly payments based on the values entered.

6) Monthly Payment
This will be a TextView that displays the monthly payment.

Calculation:
For interest rates other than 0%, the monthly payment can be calculated as:

M = (P * (J/1-(I+J)^N)) + T

where:
P = Principal (the amount borrowed)
J = Monthly interest in decimal form (annual interest rate / 1200) 
N = Number of months of the loan
T = Monthly taxes and insurance, if selected (0.1% of the amount borrowed) For interest rates of 0%, the
monthly payment is simply:
M = (P/N)+T;

Other Requirements:
• The app shouldn't crash on user input errors, such as if no values are specified and the user clicks
the Calculate button.

















