//
//  clock.cpp
//
//  Created by Brandon Petersen on 7/13/21.
//

//Getting necessary headfiles for user-friendly readable code
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;


int main() {
//initializing varibles for hours, minutes, and seconds that will be changed by the user later
    int hours = 1;
    int minutes = 1;
    int seconds = 1;
    char answer;

//Creating an initial time to display for user to change later
    int defaultClock(int, int, int);
    defaultClock(0, 0, 0);

    void menuDisplay();

//User's selection when in menuDisplay
    int menuSelection = 0;

//Creating a while loop that will dictate the User's Selection
    while (menuSelection != 4) {
        if (menuSelection == 1) {
            defaultClock(hours, 0, 0);
            cout << "You have added one hour to the time." << endl;
            cout << "The time is now " << hours << ":" << minutes << ":" << seconds << endl;
            cout << "Would you like to add another hour?" << endl;
            if (answer == 'Y' || 'y') {
                defaultClock(hours, 0, 0);
            }
        }
        else if (menuSelection == 2) {
            defaultClock(0, minutes, 0);
            cout << "You have added one minute to the time." << endl;
            cout << "The time is now " << hours << ":" << minutes << ":" << seconds << endl;
            cout << "Would you like to add another minute?" << endl;
            if (answer == 'Y' || 'y') {
                defaultClock(0, minutes, 0);
            }
        }
        else if (menuSelection == 3) {
            defaultClock(0, 0, seconds);
            cout << "You have added one second to the time." << endl;
            cout << "The time is now " << hours << ":" << minutes << ":" << seconds << endl;
            cout << "Would you like to add another second?" << endl;
            if (answer == 'Y' || 'y') {
                defaultClock(0, 0, seconds);
            }
        }
        else {
            cout << "Invalid option. Please select from a vaild option." << endl;
        break;
        }

        menuDisplay();
//Inputs the user's Selection
        cin >> menuSelection;
    }

    cout << "We appreciate you adjusting the clock to the correct time, thank you!" << endl;

    return 0;
}

int defaultClock(int hours, int minutes, int seconds) {
//Declaring variables for the standard, 12-hour, clock
    int standardHours = 0;
    int standardMinutes = 0;
    int standardSeconds = 0;

//Declaring variables for military, 24-hour, clocl
    int militaryHours = 0;
    int militaryMinutes = 0;
    int militarySeconds = 0;

//Updating standard clock with the user's input from menuSelection
    standardHours = standardHours + hours;
    standardMinutes = standardMinutes + minutes;
    standardSeconds = standardSeconds + seconds;

//Updating militry clock with the user's input from menuSelection
    militaryHours = militaryHours + hours;
    militaryMinutes = militaryMinutes + minutes;
    militarySeconds = militarySeconds + seconds;

//Displaying clock
    cout << "The current time is: " << endl;
    cout << "**************************" << endl;
    cout << "******12-Hour Clock*******";
    cout << "**********";
    cout << "******24_Hour Clock******" << endl;
    cout << setw(2) << setfill('0') << standardHours << ":";
    cout << setw(2) << setfill('0') << standardMinutes << ":";
    cout << setw(2) << setfill('0') << standardSeconds << "          ";
    cout << setw(2) << setfill('0') << militaryHours << ":";
    cout << setw(2) << setfill('0') << militaryMinutes << ":";
    cout << setw(2) << setfill('0') << militarySeconds << " \n";
    cout << "**************************    **************************";

    return 0;

}

//Visual interface for user to view and see options in the menu
void menuDisplay() {
    cout << "**************************" << endl;
    cout << "*   1 - Add One Hour     *" << endl;
    cout << "*   2 - Add One Minute   *" << endl;
    cout << "*   3 - Add One Second   *" << endl;
    cout << "*   4 - Exit The Program *" << endl;
    cout << "**************************" << endl;
}
