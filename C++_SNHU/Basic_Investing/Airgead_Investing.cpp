//
//  main.cpp
//  Investing.cpp
//
//  Created by Brandon Petersen on 07/29/21.
//

//Getting necessary headers for program
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main() {
//Instance variables used to store user inputs
    float initialInvestment;
    float annualInterest;
    float monthlyDeposit;
    float months;
    float years;
    float totalAmount;
    float interestAmount;
    float yearInterestAmount;

//Displaying user interfacing
    cout << "********************************\n";
    cout << "********** Data Input **********\n";
    cout << "Initial Investment: \n";
    cout << "Monthly Deposit: \n";
    cout << "Annual Interest: \n";
    cout << "Number of years: \n";
    //cout << "Press any key to continue . . .\n";

//Outputs press any key to continue . . .
    system("PAUSE");

//Getting user input for investing app
    cout << "********************************\n";
    cout << "********** Data Input **********\n";
    cout << "Initial Investment: $";
    cin >> initialInvestment;
    cout << "Monthly Deposit: $";
    cin >> monthlyDeposit;
    cout << "Annual Interest: %";
    cin >> annualInterest;
    cout << "Number of years: ";
    cin >> years;
    //cout << "Press any key to continue . . .\n";

//Setting monnths eaul to number of years
    months = years * 12;

//Outputs press any key to continue . . .
    system("PAUSE");

//Initializing totalAmount to initialInvestment in begining of program
    totalAmount = initialInvestment;

 //Display user input with monthlyDeposit
    cout << "\n\nBalance and interest with additional monthly deposits\n";
    cout << "==============================================================\n";
    cout << "Year\t\tyear end balance\tyear end earned interest\n";
    cout << "--------------------------------------------------------------\n";

    for (int i = 0; i < years; i++) {

//Initializing yearInterestAmount
        yearInterestAmount = 0;

        for (int j = 0; j < 12; j++) {
//Calculating interest amount, year interest, and total amount
            interestAmount = (totalAmount + monthlyDeposit) * ((annualInterest / 100) / 12);
            yearInterestAmount = yearInterestAmount + interestAmount;
            totalAmount = totalAmount + monthlyDeposit + interestAmount;
        }
//Using the table format to display user investing information
        cout << (i + 1) << "\t\t$" << fixed << setprecision(2) << totalAmount << "\t\t\t$" << yearInterestAmount << "\n";

    }

//Initializing totalAmount to initialInvestment for next stage of program
    totalAmount = initialInvestment;

 //Display user input without monthlyDeposit
    cout << "\n\nBalance and interest without additional monthly deposits\n";
    cout << "=================================================================\n";
    cout << "Year\t\tyear end balance\tyear end interest\n";
    cout << "-----------------------------------------------------------------\n";
    //cout << "Press any key to continue . . .\n";

//Intializing yearInterestAnmount
    yearInterestAmount = 0;

    for (int i = 0; i < years; i++) {
//Calculating interest amount, year interest, and total amount
        interestAmount = (totalAmount) * (annualInterest / 100);
        yearInterestAmount = yearInterestAmount + interestAmount;
        totalAmount = totalAmount + interestAmount;

//Using the table format to display user investing information
        cout << (i + 1) << "\t\t$" << fixed << setprecision(2) << totalAmount << "\t\t\t$" << interestAmount << "\n";


    }


    return 0;
}
